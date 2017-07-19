package com.snoopconsulting.antecedentes.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.io.IOUtils;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.snoopconsulting.antecedentes.crm.SugarCRMClient;
import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.Contacto;
import com.snoopconsulting.antecedentes.domain.Cuenta;
import com.snoopconsulting.antecedentes.repository.jpa.AntecedenteRepository;
import com.snoopconsulting.antecedentes.repository.jpa.ContactoRepository;
import com.snoopconsulting.antecedentes.repository.jpa.CuentaRepository;
import com.snoopconsulting.antecedentes.repository.jpa.MonedaContratoRepository;
import com.snoopconsulting.antecedentes.repository.jpa.PaisRepository;
import com.snoopconsulting.antecedentes.repository.jpa.SBURepository;
import com.snoopconsulting.antecedentes.repository.jpa.ServicioRepository;
import com.snoopconsulting.antecedentes.repository.jpa.UsuarioRepository;
import com.snoopconsulting.antecedentes.security.SecurityUtils;
import com.snoopconsulting.antecedentes.service.AntecedenteProyectoService;
import com.snoopconsulting.antecedentes.web.form.SearchForm;

@RequestMapping("/antecedenteProyectos")
@Controller
public class AntecedenteProyectoController {

	@Autowired
	private CuentaRepository cuentaRepository;

	@Autowired
	private ContactoRepository contactoRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private SBURepository sBURepository;

	@Autowired
	private ServicioRepository servicioRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AntecedenteProyectoService antecedenteProyectoService;

	@Autowired
	private MonedaContratoRepository monedaRepository;

	@Autowired
	private SugarCRMClient crmClient;

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}

	@RequestMapping(value = "/create/paso/4", method = RequestMethod.POST, produces = "text/html")
	public String createStepFour(
			@Validated(AntecedenteProyecto.AntecedenteStepFour.class) AntecedenteProyecto antecedenteProyecto,
			BindingResult bindingResult, Model uiModel) {
		
		validarFechas(antecedenteProyecto, bindingResult);
		
		if (bindingResult.hasErrors()) {
			populateEditFormStepFour(uiModel, antecedenteProyecto);
			return "antecedenteProyectos/create4";
		}
		uiModel.asMap().clear();

		antecedenteProyecto = mergeFieldsStep4(antecedenteProyecto,
				antecedenteProyectoService.findAntecedenteProyecto(antecedenteProyecto.getId()));
		antecedenteProyectoService.saveAntecedenteProyecto(
				antecedenteProyectoService.completarNuevoAntecedente(antecedenteProyecto));

		return "redirect:/bandeja";
	}

	@RequestMapping(value = "/create/paso/3", method = RequestMethod.POST, produces = "text/html")
	public String createStepThree(
			@Validated(AntecedenteProyecto.AntecedenteStepThree.class) AntecedenteProyecto antecedenteProyecto,
			BindingResult bindingResult, Model uiModel)
			throws NoSuchAlgorithmException, EncoderException, Exception {
		if (bindingResult.hasErrors()) {
			populateEditFormStepThree(uiModel, antecedenteProyecto);
			return "antecedenteProyectos/create3";
		}
		uiModel.asMap().clear();
		antecedenteProyectoService.saveAntecedenteProyecto(
				mergeFieldsStep3(antecedenteProyecto, 
						antecedenteProyectoService.findAntecedenteProyecto(antecedenteProyecto.getId())));

		return "redirect:/antecedenteProyectos/" + antecedenteProyecto.getId()
				+ "?form4";
	}

	@RequestMapping(value = "/create/paso/2", method = RequestMethod.POST, produces = "text/html")
	public String createStepTwo(
			@Validated(AntecedenteProyecto.AntecedenteStepTwo.class) AntecedenteProyecto antecedenteProyecto,
			BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
			populateEditFormStepTwo(uiModel, antecedenteProyecto);
			return "antecedenteProyectos/create2";
		}

		uiModel.asMap().clear();

		antecedenteProyectoService.saveAntecedenteProyecto(
				mergeFieldsStep2(antecedenteProyecto, 
						antecedenteProyectoService.findAntecedenteProyecto(antecedenteProyecto.getId())));

		return "redirect:/antecedenteProyectos/" + antecedenteProyecto.getId()
				+ "?form3";
	}

	@RequestMapping(value = "/create/paso/1", method = RequestMethod.POST, produces = "text/html")
	public String createStepOne(
			@Validated(AntecedenteProyecto.AntecedenteStepOne.class) AntecedenteProyecto antecedenteProyecto,
			BindingResult bindingResult, Model uiModel) {

		if (bindingResult.hasErrors()) {
			populateEditFormStepOne(uiModel, antecedenteProyecto);
			return "antecedenteProyectos/create1";
		}
		uiModel.asMap().clear();
		antecedenteProyectoService.completarClientes(antecedenteProyecto);
		if (antecedenteProyecto.getId() != null) {
			antecedenteProyecto = mergeFieldsStep1(antecedenteProyecto,
					antecedenteProyectoService.findAntecedenteProyecto(antecedenteProyecto.getId()));
		} else {
			antecedenteProyecto.setCreadorAntecedente(
					usuarioRepository.findByNombre(SecurityUtils.getCurrentUserName()));
		}
		antecedenteProyectoService.saveAntecedenteProyecto(antecedenteProyecto);

		return "redirect:/antecedenteProyectos/" + antecedenteProyecto.getId()
				+ "?form2";
	}

	@RequestMapping(value = "/{id}", params = "form4", produces = "text/html")
	public String createFormStepFour(@PathVariable("id") Long id, Model uiModel) {
		populateEditFormStepFour(uiModel, antecedenteProyectoService.findAntecedenteProyecto(id));
		return "antecedenteProyectos/create4";
	}

	@RequestMapping(value = "/{id}", params = "form3", produces = "text/html")
	public String createFormStepThree(@PathVariable("id") Long id, Model uiModel)
			throws NoSuchAlgorithmException, EncoderException, Exception {
		populateEditFormStepThree(uiModel, antecedenteProyectoService.findAntecedenteProyecto(id));
		return "antecedenteProyectos/create3";
	}

	@RequestMapping(value = "/{id}", params = "form2", produces = "text/html")
	public String createFormStepTwo(@PathVariable("id") Long id, Model uiModel) {
		populateEditFormStepTwo(uiModel, antecedenteProyectoService.findAntecedenteProyecto(id));
		return "antecedenteProyectos/create2";
	}

	@RequestMapping(params = "form", produces = "text/html")
	public String createFormStepOne(Model uiModel) {
		AntecedenteProyecto antecedente = new AntecedenteProyecto();
		antecedente.setLiderProyecto(SecurityUtils.getCurrentUserName());
		populateEditFormStepOne(uiModel, antecedente);
		return "antecedenteProyectos/create1";
	}

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public void delete(@PathVariable("id") Long id) {
		antecedenteProyectoService.deleteAntecedenteProyecto(id);
	}

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
	public String updateForm(@PathVariable("id") Long id, Model uiModel) {
		populateEditFormStepOne(uiModel, antecedenteProyectoService.findAntecedenteProyecto(id));
		return "antecedenteProyectos/create1";
	}

	@RequestMapping(produces = "text/html")
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {
		populateBuscador(uiModel);		
		return "antecedenteProyectos/list";
	}

	@RequestMapping(value = "validar/{id}", produces = "text/html")
	public String validar(@PathVariable("id") Long id, Model uiModel) {
		antecedenteProyectoService.validarAntecedente(id);
		return "redirect:/bandeja";
	}

	@RequestMapping(value = "rechazar", method = RequestMethod.POST, produces = "text/html")
	public String rechazar(@RequestParam("id_antecedente") Long id,
			@RequestParam("texto_rechazo") String motivoRechazo, Model uiModel) {
		antecedenteProyectoService.rechazarAntecedente(id, motivoRechazo);
		return "redirect:/bandeja";
	}

	private AntecedenteProyecto mergeFieldsStep1(
			AntecedenteProyecto fromAntecedente,
			AntecedenteProyecto targetAntecedente) {
		targetAntecedente.setNombre(fromAntecedente.getNombre());
		targetAntecedente.setCliente(fromAntecedente.getCliente());
		targetAntecedente.setClienteFinal(fromAntecedente.getClienteFinal());
		targetAntecedente.setLiderProyecto(fromAntecedente.getLiderProyecto());
		return targetAntecedente;
	}

	private AntecedenteProyecto mergeFieldsStep2(
			AntecedenteProyecto fromAntecedente,
			AntecedenteProyecto targetAntecedente) {
		targetAntecedente.setServicio(fromAntecedente.getServicio());
		targetAntecedente.setTipoSolucion(fromAntecedente.getTipoSolucion());
		targetAntecedente.setPais(fromAntecedente.getPais());
		targetAntecedente.setSbu(fromAntecedente.getSbu());
		targetAntecedente.setMonedaContrato(fromAntecedente.getMonedaContrato());
		targetAntecedente.setMontoContrato(fromAntecedente.getMontoContrato());
		targetAntecedente.setCotizacionMoneda(fromAntecedente.getCotizacionMoneda());
		return targetAntecedente;
	}

	private AntecedenteProyecto mergeFieldsStep3(
			AntecedenteProyecto fromAntecedente,
			AntecedenteProyecto targetAntecedente) {
		Contacto contacto;
		if (fromAntecedente.getContacto().getId() != null) {
			contacto = contactoRepository.findOne(fromAntecedente.getContacto().getId());
			Contacto fromContacto = fromAntecedente.getContacto();
			contacto.setIdCrm(fromContacto.getIdCrm());
			contacto.setEmail(fromContacto.getEmail());
			contacto.setAreaPerteneciente(fromContacto.getAreaPerteneciente());
			contacto.setNombre(fromContacto.getNombre());
			contacto.setTelefono(fromContacto.getTelefono());
		} else {
			contacto = fromAntecedente.getContacto();
		}

		targetAntecedente.setContacto(contacto);
		targetAntecedente.setAreaUsuaria(fromAntecedente.getAreaUsuaria());
		return targetAntecedente;
	}

	private AntecedenteProyecto mergeFieldsStep4(
			AntecedenteProyecto fromAntecedente,
			AntecedenteProyecto targetAntecedente) {
		targetAntecedente.setFechaInicio(fromAntecedente.getFechaInicio());
		targetAntecedente.setFechaFin(fromAntecedente.getFechaFin());
		targetAntecedente.setDuracion(fromAntecedente.getDuracion());
		targetAntecedente.setHoras(fromAntecedente.getHoras());
		targetAntecedente.setRecursosPerfiles(fromAntecedente.getRecursosPerfiles());
		targetAntecedente.setDescFuncionalProyecto(fromAntecedente.getDescFuncionalProyecto());
		targetAntecedente.setDescTecnicaProyecto(fromAntecedente.getDescTecnicaProyecto());
		targetAntecedente.setLogrosObtenidos(fromAntecedente.getLogrosObtenidos());
		targetAntecedente.setTags(fromAntecedente.getTags());
		if (fromAntecedente.getDiagrama().length != 0) {
			targetAntecedente.setDiagrama(fromAntecedente.getDiagrama());
		}
		return targetAntecedente;
	}

	private void populateEditFormStepFour(Model uiModel,
			AntecedenteProyecto antecedenteProyecto) {
		uiModel.addAttribute("antecedenteProyecto", antecedenteProyecto);
		addDateTimeFormatPatterns(uiModel);
	}

	private void populateEditFormStepThree(Model uiModel, AntecedenteProyecto antecedenteProyecto) throws
			NoSuchAlgorithmException, EncoderException, Exception {
		Cuenta clienteFinal;
		if (antecedenteProyecto.getClienteFinal() == null) {
			clienteFinal = antecedenteProyectoService.findAntecedenteProyecto(
					antecedenteProyecto.getId()).getClienteFinal();
		} else {
			clienteFinal = antecedenteProyecto.getClienteFinal();
		}
		uiModel.addAttribute("contactos", crmClient.getContactos(clienteFinal.getIdCrm()));
		uiModel.addAttribute("antecedenteProyecto", antecedenteProyecto);
	}

	private void populateEditFormStepTwo(Model uiModel,
			AntecedenteProyecto antecedenteProyecto) {
		uiModel.addAttribute("antecedenteProyecto", antecedenteProyecto);
		uiModel.addAttribute("servicios", servicioRepository.findAll());
		uiModel.addAttribute("paises", paisRepository.findAll());
		uiModel.addAttribute("sbus", sBURepository.findAll());
		uiModel.addAttribute("monedas", monedaRepository.findAll());
	}

	void populateEditFormStepOne(Model uiModel,
			AntecedenteProyecto antecedenteProyecto) {
		uiModel.addAttribute("antecedenteProyecto", antecedenteProyecto);
		uiModel.addAttribute("clientes", cuentaRepository.findAll());
		uiModel.addAttribute("contactos", contactoRepository.findAll());
	}

	private void populateBuscador(Model uiModel) {
		uiModel.addAttribute("clientes", cuentaRepository.findAll());
		uiModel.addAttribute("servicios", servicioRepository.findAll());
		uiModel.addAttribute("sbus", sBURepository.findAll());
		uiModel.addAttribute("form", new SearchForm());
	}

	private void addDateTimeFormatPatterns(Model uiModel) {
		uiModel.addAttribute("antecedenteProyecto_fechacarga_date_format",
				DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
		uiModel.addAttribute("antecedenteProyecto_fechamodificacion_date_format",
				DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
		uiModel.addAttribute("antecedenteProyecto_fechainicio_date_format",
				DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
		uiModel.addAttribute("antecedenteProyecto_fechafin_date_format",
				DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
	}
	
	private void validarFechas(AntecedenteProyecto antecedente, BindingResult bindingResult) {
		if(antecedente.getFechaFin() != null && antecedente.getFechaInicio() != null){
			if(antecedente.getFechaFin().before(antecedente.getFechaInicio())){
				bindingResult.rejectValue("fechaFin", "AnteriorFechaFin.antecedenteProyecto.fechaFin");
			}
		}
	}

	@RequestMapping(value = "/getDiagrama/{id}")
	public void getUserImage(HttpServletResponse response,
			@PathVariable("id") Long id) throws IOException {

		response.setContentType("image/jpeg");
		byte[] buffer = antecedenteProyectoService.findAntecedenteProyecto(id).getDiagrama();
		InputStream in1 = new ByteArrayInputStream(buffer);
		IOUtils.copy(in1, response.getOutputStream());
	}

	@Autowired
	AntecedenteRepository antecedenteRepository;

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") Long id, Model uiModel) {
		addDateTimeFormatPatterns(uiModel);
		uiModel.addAttribute("antecedenteproyecto", antecedenteRepository.findOne(id));
		uiModel.addAttribute("itemId", id);
		return "antecedenteProyectos/show";
	}
	
	
	
//	
//	@RequestMapping
//	
//	
//	
//	@RequestMapping(value = "/dataEntry", method = RequestMethod.POST, produces = "text/html")
//	public String createDataEntryForm( AntecedenteProyecto antecedenteProyecto,
//			BindingResult bindingResult, Model uiModel)
//			throws NoSuchAlgorithmException, EncoderException, Exception {
//		if (bindingResult.hasErrors()) {
//			populateEditFormStepThree(uiModel, antecedenteProyecto);
//			return "antecedenteProyectos/DataEF";
//		}
//		uiModel.asMap().clear();
//		antecedenteProyectoService.saveAntecedenteProyecto(
//				mergeFieldsStep3(antecedenteProyecto, 
//						antecedenteProyectoService.findAntecedenteProyecto(antecedenteProyecto.getId())));
//
//		return "redirect:/antecedenteProyectos/" + antecedenteProyecto.getId()
//				+ "?form4";
//	}
//	
	
}
