package com.snoopconsulting.antecedentes.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto.AntecedenteStepOne;

@RooJavaBean
@RooJpaEntity
public class Cuenta {

	@NotBlank(groups = AntecedenteStepOne.class)
	private String idCrm;

	@NotBlank(groups = AntecedenteStepOne.class)
	private String nombre;

	@NotBlank
	private String linkCRM;

	private String direccion;

	private String telefono;

	private String vertical;

	public String toString() {
		return nombre;
	}

	public void setIdCrm(String idCrm) {
		this.idCrm = idCrm;
		linkCRM = "http://mycrm.snoopconsulting.com/index.php?module=Accounts&action=DetailView&record="
				+ idCrm;
	}
}
