package com.snoopconsulting.antecedentes.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snoopconsulting.antecedentes.domain.Usuario;

@RequestMapping("/usuarios")
@Controller
@RooWebScaffold(path = "usuarios", formBackingObject = Usuario.class)
public class UsuarioController {

	@Autowired
	ShaPasswordEncoder passwordEncoder;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Usuario usuario, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, usuario);
            return "usuarios/create";
        }
        uiModel.asMap().clear();
        encodePassword(usuario);
        usuarioRepository.save(usuario);
        return "redirect:/usuarios/" + encodeUrlPathSegment(usuario.getId().toString(), httpServletRequest);
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Usuario usuario, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, usuario);
            return "usuarios/update";
        }
        uiModel.asMap().clear();
        encodePassword(usuario);
        usuarioRepository.save(usuario);
        return "redirect:/usuarios/" + encodeUrlPathSegment(usuario.getId().toString(), httpServletRequest);
    }
	
	private void encodePassword(Usuario usuario){
		String hash = passwordEncoder.encodePassword(usuario.getPassword(), usuario.getUsername());
		usuario.setPassword(hash);
	}
}
