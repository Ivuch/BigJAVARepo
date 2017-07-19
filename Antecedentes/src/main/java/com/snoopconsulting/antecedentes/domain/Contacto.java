package com.snoopconsulting.antecedentes.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto.AntecedenteStepThree;

@RooJavaBean
@RooJpaEntity
@RooToString
public class Contacto {

	@NotBlank
	private String idCrm;
	
	@NotBlank(groups = AntecedenteStepThree.class)
	private String nombre;

	@NotBlank(groups = AntecedenteStepThree.class)
	private String email;

	@NotBlank(groups = AntecedenteStepThree.class)
	private String telefono;

	@NotBlank(groups = AntecedenteStepThree.class)
	private String areaPerteneciente;

}
