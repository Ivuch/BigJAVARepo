package com.snoopconsulting.antecedentes.web.form;

import java.util.ArrayList;
import java.util.List;

public class CamposReporte {

	private String ids;
	private Boolean cliente;
	private Boolean servicio;
	private Boolean tipoSolucion;
	private Boolean pais;
	private Boolean sbu;
	private Boolean monto;
	private Boolean lider;
	private Boolean contacto;
	private Boolean areaUsuaria;
	private Boolean fechaInicioFin;
	private Boolean duracion;
	private Boolean horas;
	private Boolean perfilesRecursos;
	private Boolean descFuncional;
	private Boolean descTecnica;
	private Boolean logros;
	private Boolean diagrama;
	
	public Boolean getCliente() {
		return cliente;
	}
	public void setCliente(Boolean cliente) {
		this.cliente = cliente;
	}
	public Boolean getServicio() {
		return servicio;
	}
	public void setServicio(Boolean servicio) {
		this.servicio = servicio;
	}
	public Boolean getTipoSolucion() {
		return tipoSolucion;
	}
	public void setTipoSolucion(Boolean tipoSolucion) {
		this.tipoSolucion = tipoSolucion;
	}
	public Boolean getPais() {
		return pais;
	}
	public void setPais(Boolean pais) {
		this.pais = pais;
	}
	public Boolean getSbu() {
		return sbu;
	}
	public void setSbu(Boolean sbu) {
		this.sbu = sbu;
	}
	public Boolean getMonto() {
		return monto;
	}
	public void setMonto(Boolean monto) {
		this.monto = monto;
	}
	public Boolean getLider() {
		return lider;
	}
	public void setLider(Boolean lider) {
		this.lider = lider;
	}
	public Boolean getContacto() {
		return contacto;
	}
	public void setContacto(Boolean contacto) {
		this.contacto = contacto;
	}
	public Boolean getFechaInicioFin() {
		return fechaInicioFin;
	}
	public void setFechaInicioFin(Boolean fechaInicioFin) {
		this.fechaInicioFin = fechaInicioFin;
	}
	public Boolean getDuracion() {
		return duracion;
	}
	public void setDuracion(Boolean duracion) {
		this.duracion = duracion;
	}
	public Boolean getHoras() {
		return horas;
	}
	public void setHoras(Boolean horas) {
		this.horas = horas;
	}
	public Boolean getPerfilesRecursos() {
		return perfilesRecursos;
	}
	public void setPerfilesRecursos(Boolean perfilesRecursos) {
		this.perfilesRecursos = perfilesRecursos;
	}
	public Boolean getDescFuncional() {
		return descFuncional;
	}
	public void setDescFuncional(Boolean descFuncional) {
		this.descFuncional = descFuncional;
	}
	public Boolean getDescTecnica() {
		return descTecnica;
	}
	public void setDescTecnica(Boolean descTecnica) {
		this.descTecnica = descTecnica;
	}
	public Boolean getLogros() {
		return logros;
	}
	public void setLogros(Boolean logros) {
		this.logros = logros;
	}
	public Boolean getDiagrama() {
		return diagrama;
	}
	public void setDiagrama(Boolean diagrama) {
		this.diagrama = diagrama;
	}
	public Boolean getAreaUsuaria() {
		return areaUsuaria;
	}
	public void setAreaUsuaria(Boolean areaUsuaria) {
		this.areaUsuaria = areaUsuaria;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public List<Long> getIdsAsList() {
		List<Long> idsList = new ArrayList<Long>();
		for (String id : ids.split(",")) {
			idsList.add(Long.parseLong(id));
		}
		
		return idsList;
	}
}
