package com.snoopconsulting.antecedentes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.service.AntecedenteProyectoService;

@RequestMapping("/bandeja")
@Controller
public class BandejaController {

	@Autowired
	private AntecedenteProyectoService antecedenteProyectoService;

	@RequestMapping(produces = "text/html")
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {

		if ((page != null && page > 0) || (size != null && size > 0)) {

			int sizeNo = size == null ? 10 : size.intValue();
			final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
			
			Page<AntecedenteProyecto> pageAntecedentes = 
					antecedenteProyectoService.getAntecedentesForCurrentUser(firstResult, sizeNo);

			uiModel.addAttribute("antecedentes", pageAntecedentes.getContent());

			uiModel.addAttribute("maxPages", pageAntecedentes.getTotalPages());
		} else {
			return "redirect:/bandeja?page=1&size=10";
		}
		return "bandeja";
	}
}
