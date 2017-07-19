package com.snoopconsulting.antecedentes.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaEntity
@RooToString
public class Grupo {

	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<PermisosUsuario> permisosUsuarios = new HashSet<PermisosUsuario>();

	@NotBlank
	@Size(min = 2)
	private String nombre;

	@NotNull
	private boolean enabled;
	
	
	public void addPermiso(PermisosUsuario permiso)
	{
		permisosUsuarios.add(permiso);
	}

}
