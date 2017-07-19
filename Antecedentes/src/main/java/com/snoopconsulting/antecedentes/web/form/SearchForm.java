package com.snoopconsulting.antecedentes.web.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.snoopconsulting.antecedentes.domain.Cuenta;
import com.snoopconsulting.antecedentes.domain.SBU;
import com.snoopconsulting.antecedentes.domain.Servicio;

public class SearchForm {

	private Cuenta cliente;

	private Servicio servicio;

	private SBU sbu;

	private String palabras;

	private Boolean soloUsuarioLogeado = false;
	
	private Integer page;
	
	private Integer size;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaDesde;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaHasta;

	public Cuenta getCliente() {
		return cliente;
	}

	public void setCliente(Cuenta cliente) {
		this.cliente = cliente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getPalabras() {
		return palabras;
	}

	public void setPalabras(String palabras) {
		this.palabras = palabras;
	}

	public Boolean getSoloUsuarioLogeado() {
		return soloUsuarioLogeado;
	}

	public void setSoloUsuarioLogeado(Boolean soloUsuarioLogeado) {
		this.soloUsuarioLogeado = soloUsuarioLogeado;
	}

	public SBU getSbu() {
		return sbu;
	}

	public void setSbu(SBU sbu) {
		this.sbu = sbu;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}
