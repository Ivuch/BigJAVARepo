package com.snoopconsulting.antecedentes.web;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snoopconsulting.antecedentes.domain.MonedaContrato;

@RequestMapping("/monedas")
@Controller
@RooWebScaffold(path = "monedas", formBackingObject = MonedaContrato.class)
public class MonedaController {

}
