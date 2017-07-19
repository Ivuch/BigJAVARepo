package com.snoopconsulting.antecedentes.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaEntity
@RooToString
public class AntecedenteProyecto {

	@Enumerated(EnumType.STRING)
	private EstadoAntecedente estado = EstadoAntecedente.INCOMPLETO;

	@OneToOne(cascade = CascadeType.ALL)
	private Validacion validaciones;

	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	private Contacto contacto;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date fechaCarga = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date fechaModificacion = new Date();

	@ManyToOne
	private Usuario creadorAntecedente;

	@NotBlank(groups = AntecedenteStepOne.class)
	@Size(groups = AntecedenteStepOne.class, min = 2, max = 255)
	private String nombre;

	@ManyToOne
	@Valid
	private Cuenta cliente;

	@ManyToOne
	@Valid
	private Cuenta clienteFinal;

	@ManyToOne
	@NotNull(groups = AntecedenteStepTwo.class)
	private Servicio servicio;

	@NotBlank(groups = AntecedenteStepTwo.class)
	private String tipoSolucion;

	@ManyToOne
	@NotNull(groups = AntecedenteStepTwo.class)
	private SBU sbu;

	@ManyToOne
	@NotNull(groups = AntecedenteStepTwo.class)
	private Pais pais;

	@NotBlank(groups = AntecedenteStepOne.class)
	private String liderProyecto;

	@NotNull(message = "No puede estar vacio", groups = AntecedenteStepFour.class)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicio;

	@NotNull(message = "No puede estar vacio", groups = AntecedenteStepFour.class)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaFin;

	@NotBlank(groups = AntecedenteStepThree.class)
	private String areaUsuaria;

	private Integer duracion;

	@NotNull(message = "No puede estar vacio", groups = AntecedenteStepFour.class)
	private Integer horas;

	@Size(message = "Ingrese 50 caracteres", min = 50, groups = AntecedenteStepFour.class)
	@Lob
	private String recursosPerfiles;

	@Min(value = 0, groups = AntecedenteStepTwo.class)
	@NotNull(message = "No puede estar vacio", groups = AntecedenteStepTwo.class)
	private BigDecimal montoContrato;

	@ManyToOne
	@NotNull(message = "No puede estar vacio", groups = AntecedenteStepTwo.class)
	private MonedaContrato monedaContrato;

	private BigDecimal cotizacionMoneda;

	@Size(message = "Ingrese 50 caracteres", min = 50, groups = AntecedenteStepFour.class)
	@Lob
	private String descFuncionalProyecto;

	@Size(message = "Ingrese 50 caracteres", min = 50, groups = AntecedenteStepFour.class)
	@Lob
	private String descTecnicaProyecto;

	@Size(message = "Ingrese 50 caracteres", min = 50, groups = AntecedenteStepFour.class)
	@Lob
	private String logrosObtenidos;

	@NotBlank(groups = AntecedenteStepFour.class)
	private String tags;

	@Lob
	private byte[] diagrama;

	/*
	 * Validation groups
	 */
	public interface AntecedenteStepOne {
	};

	public interface AntecedenteStepTwo {
	};

	public interface AntecedenteStepThree {
	};

	public interface AntecedenteStepFour {
	};

}
