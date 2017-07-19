package com.snoopconsulting.antecedentes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(produces = "text/html")
	public String index(){
		return "redirect:/bandeja";
	}
}
