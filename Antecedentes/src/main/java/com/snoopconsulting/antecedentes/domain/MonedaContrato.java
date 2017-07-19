package com.snoopconsulting.antecedentes.domain;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaEntity(versionField = "")
@RooToString
public class MonedaContrato {

	@NotBlank
	@Column(unique = true)
	private String nombre;
}
