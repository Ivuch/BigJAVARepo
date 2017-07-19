package com.snoopconsulting.antecedentes.web;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.poi.CustomXWPFDocument;
import com.snoopconsulting.antecedentes.repository.jpa.CuentaRepository;
import com.snoopconsulting.antecedentes.repository.jpa.SBURepository;
import com.snoopconsulting.antecedentes.repository.jpa.ServicioRepository;
import com.snoopconsulting.antecedentes.service.AntecedenteProyectoService;
import com.snoopconsulting.antecedentes.service.ReportesService;
import com.snoopconsulting.antecedentes.web.form.CamposReporte;
import com.snoopconsulting.antecedentes.web.form.SearchForm;

@RequestMapping("/reporte")
@Controller
public class ReporteController {
	
	@Autowired
	private SBURepository sbuRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private ServicioRepository servicioRepository;
	
	@Autowired
	private ReportesService reportesService;
	
	@Autowired
	private AntecedenteProyectoService antecedenteService;

	@RequestMapping(value = "/generarReporte", method = RequestMethod.POST, produces = "text/html")
	public void getFile(CamposReporte campos, HttpServletResponse response, Locale locale) throws InvalidFormatException, IOException {
		
    	List<AntecedenteProyecto> antecedentes = antecedenteService.findAll(campos.getIdsAsList());
    	
    	CustomXWPFDocument document = reportesService.generarWord(antecedentes, campos, locale);
    	
    	response.setHeader("Content-Disposition", "attachment; filename=reporte.docx");
    	document.write(response.getOutputStream());
    	
	    response.flushBuffer();

	}	
	
	@RequestMapping(produces = "text/html")
	public String list(Model uiModel) {
		populateBuscador(uiModel);	
		return "reporte";
	}
	
	private void populateBuscador(Model uiModel) {
		uiModel.addAttribute("camposReporte", new CamposReporte());
		uiModel.addAttribute("clientes", cuentaRepository.findAll());
		uiModel.addAttribute("servicios", servicioRepository.findAll());
		uiModel.addAttribute("sbus", sbuRepository.findAll());
		uiModel.addAttribute("form", new SearchForm());
	}
			
		

}
