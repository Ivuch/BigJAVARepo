package com.snoopconsulting.antecedentes.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.service.AntecedenteProyectoService;




@RequestMapping("/imprimir")
@Controller
public class ImprimirController {

	@Autowired
	private AntecedenteProyectoService antecedenteProyectoService;
	
	
	
	@RequestMapping(value = "/{id}", produces = "text/html")
	public String createImpresionIndividual(@PathVariable("id") Long id,
			Model uiModel) {
		uiModel.addAttribute("antecedente",
				antecedenteProyectoService.findAntecedenteProyecto(id));

		return "imprimir/antecedente";
	}
	
	@RequestMapping(value ="/lista", produces = "text/html")
	public String createImpresionLista(@RequestParam(value = "ids") String ids, Model uiModel){
			
		List<Long> idsList = new ArrayList<Long>();
		
	    for (String id : ids.split(",")) {
	            idsList.add(Long.parseLong(id));
	    }
	    List<AntecedenteProyecto> antecedentes = antecedenteProyectoService.findAll(idsList);
		uiModel.addAttribute("antecedentes", 
				antecedentes );
		
		return "imprimir/lista";
	}
	
	
		
	
}
