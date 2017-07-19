package com.snoopconsulting.antecedentes.domain.solr;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJavaBean
public class AntecedenteSolrDocument {

	@Id
	@Field
	private String id;

	@Field
	private String nombre;

	@Field
	private String estado;

	@Field
	private Date fechaCarga;

	@Field
	private Date fechaModificacion;

	@Field
	private String cliente;

	@Field
	private String clienteFinal;
	
	@Field
	private String creadorAntecedente;

	@Field
	private String servicio;

	@Field
	private String tipoSolucion;

	@Field
	private String sbu;

	@Field
	private String pais;

	@Field
	private String liderProyecto;

	@Field
	private Date fechaInicio;

	@Field
	private Date fechaFin;

	@Field
	private String areaUsuaria;

	@Field
	private String recursosPerfiles;

	@Field
	private String monedaContrato;

	@Field
	private String formaContratacion;

	@Field
	private String descFuncionalProyecto;

	@Field
	private String descTecnicaProyecto;

	@Field
	private String logrosObtenidos;

	@Field
	private String tags;
}
