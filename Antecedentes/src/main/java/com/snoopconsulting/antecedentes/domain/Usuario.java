package com.snoopconsulting.antecedentes.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaEntity
@RooToString
public class Usuario {

	@NotBlank
	private String username;

	@NotBlank
	private String nombre;

	@NotBlank
	private String email;

	@ManyToMany
	private Set<Grupo> grupos = new HashSet<Grupo>();

	@NotNull
	private boolean enabled;

	@NotBlank
	private String password;
	
	
	public void addGrupo(Grupo grupo)
	{
		grupos.add(grupo);
	}
}
