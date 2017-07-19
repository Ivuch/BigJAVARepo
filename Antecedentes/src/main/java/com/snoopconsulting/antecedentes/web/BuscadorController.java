package com.snoopconsulting.antecedentes.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.service.BuscadorService;
import com.snoopconsulting.antecedentes.web.form.SearchForm;

@Controller
public class BuscadorController {

	@Autowired
	private BuscadorService buscadorService;

	private Gson json = new GsonBuilder().create();

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public String buscar(SearchForm form, Model uiModel, HttpServletRequest request, 
			@RequestParam(required = false, value = "tipoBotones") Integer tipoBotones) {
		
		int sizeNo;
		final int firstResult;
		
		if ((form.getPage() != null && form.getPage()  > 0) || (form.getSize() != null && form.getSize() > 0)) {
			sizeNo = form.getSize() == null ? 20 : form.getSize().intValue();
			firstResult = form.getPage() == null ? 0 : (form.getPage().intValue() - 1) * sizeNo;	
		} else {
			sizeNo = 20;
			firstResult = 0;
		}		
		
		Page<AntecedenteProyecto> antecedentes = 
				buscadorService.searchAntecedentes(form.getPalabras(), form.getCliente(), form.getServicio(),
						form.getSoloUsuarioLogeado(), form.getSbu(), form.getFechaDesde(), form.getFechaHasta(),
						firstResult, sizeNo);
		
		uiModel.addAttribute("antecedentes", antecedentes.getContent());
		uiModel.addAttribute("maxPages", antecedentes.getTotalPages());
		
		if(tipoBotones != null){
			uiModel.addAttribute("tipoBotones", tipoBotones);
		}
		
		return "antecedenteProyectos/tabla";
	}
		

	@RequestMapping(value = "/suggest", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String suggest(@RequestParam("q") String query, Model uiModel) {

		List<String> suggestions = buscadorService.getSuggestions(query);

		return json.toJson(suggestions);
	}
}

