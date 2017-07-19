package com.snoopconsulting.antecedentes.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaEntity
@RooToString
public class Validacion {

	public Validacion(EstadoValidacion estado, String mensaje) {
		this.estado = estado;
		this.mensaje = mensaje;
	}

	@ManyToOne
	private Usuario usuario;

	@Enumerated(EnumType.STRING)
	private EstadoValidacion estado;

	@Column(length = 10000)
	private String mensaje;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date fechaValidacion = new Date();
}
