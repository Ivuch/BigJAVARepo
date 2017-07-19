package com.ivuch.zionweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("ZionWeb/helloWorld")
public class UsuarioController {
	
	@Autowired
	private Usuario user;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		model.addAttribute("message", user.getName()+user.getPass());
		return "hola";

	}
}
