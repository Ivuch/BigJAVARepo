package com.snoopconsulting.antecedentes.service;

import static com.snoopconsulting.antecedentes.security.SecurityUtils.getCurrentUserAuthorities;
import static com.snoopconsulting.antecedentes.security.SecurityUtils.getCurrentUserName;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.snoopconsulting.antecedentes.common.AntecedenteDocumentParser;
import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.Cuenta;
import com.snoopconsulting.antecedentes.domain.EstadoAntecedente;
import com.snoopconsulting.antecedentes.domain.EstadoValidacion;
import com.snoopconsulting.antecedentes.domain.PermisosUsuario;
import com.snoopconsulting.antecedentes.domain.Usuario;
import com.snoopconsulting.antecedentes.domain.Validacion;
import com.snoopconsulting.antecedentes.repository.jpa.AntecedenteRepository;
import com.snoopconsulting.antecedentes.repository.jpa.CuentaRepository;
import com.snoopconsulting.antecedentes.repository.jpa.UsuarioRepository;
import com.snoopconsulting.antecedentes.repository.solr.AntecedenteDocumentIndex;

@Service
@Transactional
public class AntecedenteProyectoServiceImpl implements AntecedenteProyectoService {

	@Autowired
	private MailService mailService;
	
	@Autowired
	private AntecedenteRepository antecedenteRepository;

	@Autowired
	private CuentaRepository cuentaRepository;

	@Autowired
	private AntecedenteDocumentIndex antecedenteDocumentIndex;

	@Autowired
	private AntecedenteDocumentParser parser;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private List<EstadoAntecedente> estadosUsuarioValidador;

	private List<EstadoAntecedente> estadosCualquierUsuario;

	@PostConstruct
	public void init() {
		estadosUsuarioValidador = Lists.newArrayList(
				EstadoAntecedente.PENDIENTE_APROBACION,
				EstadoAntecedente.MODIFICADO);

		estadosCualquierUsuario = Lists.newArrayList(
				EstadoAntecedente.RECHAZADO, EstadoAntecedente.INCOMPLETO);
	}

	@Override
	public AntecedenteProyecto saveAntecedenteProyecto(
			AntecedenteProyecto antecedenteProyecto) {
		antecedenteProyecto = antecedenteRepository.save(antecedenteProyecto);
		antecedenteDocumentIndex.save(parser.parseToDocument(antecedenteProyecto));
		return antecedenteProyecto;
	}

	@Override
	public void deleteAntecedenteProyecto(Long id) {
		antecedenteRepository.delete(id);
		antecedenteDocumentIndex.delete(id.toString());
	}

	public AntecedenteProyecto findAntecedenteProyecto(Long id) {
		return antecedenteRepository.findOne(id);
	}

	@Override
	public List<AntecedenteProyecto> findAllAntecedenteProyectoes() {
		return antecedenteRepository.findAll();
	}

	@Override
	public void validarAntecedente(Long id) {
		AntecedenteProyecto antecedente = findAntecedenteProyecto(id);
		antecedente.setEstado(EstadoAntecedente.APROBADO);
		saveAntecedenteProyecto(antecedente);
		mailService.enviarMail(antecedente);
	}

	@Override
	public AntecedenteProyecto completarNuevoAntecedente(
			AntecedenteProyecto antecedente) {
		if (antecedente.getEstado().equals(EstadoAntecedente.INCOMPLETO)) {
			antecedente.setEstado(EstadoAntecedente.PENDIENTE_APROBACION);
			mailService.enviarMail(antecedente);
		} else if (antecedente.getEstado().equals(EstadoAntecedente.RECHAZADO)) {
			antecedente.setEstado(EstadoAntecedente.MODIFICADO);
			mailService.enviarMail(antecedente);
		}
		return antecedente;
		
	}

	@Override
	public void rechazarAntecedente(Long id, String motivoRechazo) {
		Validacion validacion = new Validacion(EstadoValidacion.RECHAZADO, motivoRechazo);

		AntecedenteProyecto antecedente = findAntecedenteProyecto(id);
		antecedente.setValidaciones(validacion);
		antecedente.setEstado(EstadoAntecedente.RECHAZADO);
		saveAntecedenteProyecto(antecedente);
		mailService.enviarMail(antecedente);
		
	}

	@Override
	public AntecedenteProyecto completarClientes(AntecedenteProyecto antecedente) {
		String idCrmCliente = antecedente.getCliente().getIdCrm();
		String idCrmClienteFinal = antecedente.getClienteFinal().getIdCrm();

		Cuenta cliente = cuentaRepository.findByIdCrm(idCrmCliente);
		if (cliente == null) {
			antecedente.setCliente(cuentaRepository.save(antecedente.getCliente()));
		} else {
			antecedente.setCliente(cliente);
		}

		Cuenta clienteFinal = cuentaRepository.findByIdCrm(idCrmClienteFinal);
		if (clienteFinal == null) {
			antecedente.setClienteFinal(cuentaRepository.save(antecedente.getClienteFinal()));
		} else {
			antecedente.setClienteFinal(clienteFinal);
		}

		return antecedente;
	}

	@Override
	public List<AntecedenteProyecto> findAll(List<Long> ids) {		
		return Lists.newArrayList(antecedenteRepository.findAll(ids));
	}
	
	@Override
	public Page<AntecedenteProyecto> getAntecedentesForCurrentUser(int firstResult, int sizeNo) {
		
		Collection<PermisosUsuario> permisos = getCurrentUserAuthorities();
		
		Usuario currentUser = usuarioRepository.findByNombre(getCurrentUserName());

		Page<AntecedenteProyecto> antecedentes;

		if (esUsuarioValidador(permisos)) {
			antecedentes = findForUsuarioValidador(currentUser, firstResult, sizeNo);
		} else{
			antecedentes = findForUsuarioNoValidador(currentUser, firstResult, sizeNo);
		}

		return antecedentes;

	}
	
	private Page<AntecedenteProyecto> findForUsuarioNoValidador(Usuario usuario, int firstResult, int maxResults) {
		return antecedenteRepository.findByEstadoInAndCreadorAntecedente(estadosCualquierUsuario, usuario, 
					new PageRequest(firstResult / maxResults, maxResults));
	}

	private Page<AntecedenteProyecto> findForUsuarioValidador(Usuario usuario, int firstResult, int maxResults) {
		return antecedenteRepository.findByEstadoInOrEstadoInAndCreadorAntecedente(estadosUsuarioValidador,
					estadosCualquierUsuario, usuario, new PageRequest(firstResult / maxResults, maxResults));
	}	
	
	private Boolean esUsuarioValidador(Collection<PermisosUsuario> permisos) {
		return permisos.contains(PermisosUsuario.VALIDAR_ANTECEDENTE);
	}

}
