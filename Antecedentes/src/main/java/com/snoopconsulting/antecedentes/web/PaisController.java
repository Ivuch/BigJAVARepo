package com.snoopconsulting.antecedentes.web;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snoopconsulting.antecedentes.domain.Pais;

@RequestMapping("/paises")
@Controller
@RooWebScaffold(path = "paises", formBackingObject = Pais.class)
public class PaisController {

}
