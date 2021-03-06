// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.snoopconsulting.antecedentes.domain;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.Contacto;
import com.snoopconsulting.antecedentes.domain.Cuenta;
import com.snoopconsulting.antecedentes.domain.EstadoAntecedente;
import com.snoopconsulting.antecedentes.domain.MonedaContrato;
import com.snoopconsulting.antecedentes.domain.Pais;
import com.snoopconsulting.antecedentes.domain.SBU;
import com.snoopconsulting.antecedentes.domain.Servicio;
import com.snoopconsulting.antecedentes.domain.Usuario;
import com.snoopconsulting.antecedentes.domain.Validacion;
import java.math.BigDecimal;
import java.util.Date;

privileged aspect AntecedenteProyecto_Roo_JavaBean {
    
    public EstadoAntecedente AntecedenteProyecto.getEstado() {
        return this.estado;
    }
    
    public void AntecedenteProyecto.setEstado(EstadoAntecedente estado) {
        this.estado = estado;
    }
    
    public Validacion AntecedenteProyecto.getValidaciones() {
        return this.validaciones;
    }
    
    public void AntecedenteProyecto.setValidaciones(Validacion validaciones) {
        this.validaciones = validaciones;
    }
    
    public Contacto AntecedenteProyecto.getContacto() {
        return this.contacto;
    }
    
    public void AntecedenteProyecto.setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
    
    public Date AntecedenteProyecto.getFechaCarga() {
        return this.fechaCarga;
    }
    
    public void AntecedenteProyecto.setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }
    
    public Date AntecedenteProyecto.getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void AntecedenteProyecto.setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    public Usuario AntecedenteProyecto.getCreadorAntecedente() {
        return this.creadorAntecedente;
    }
    
    public void AntecedenteProyecto.setCreadorAntecedente(Usuario creadorAntecedente) {
        this.creadorAntecedente = creadorAntecedente;
    }
    
    public String AntecedenteProyecto.getNombre() {
        return this.nombre;
    }
    
    public void AntecedenteProyecto.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Cuenta AntecedenteProyecto.getCliente() {
        return this.cliente;
    }
    
    public void AntecedenteProyecto.setCliente(Cuenta cliente) {
        this.cliente = cliente;
    }
    
    public Cuenta AntecedenteProyecto.getClienteFinal() {
        return this.clienteFinal;
    }
    
    public void AntecedenteProyecto.setClienteFinal(Cuenta clienteFinal) {
        this.clienteFinal = clienteFinal;
    }
    
    public Servicio AntecedenteProyecto.getServicio() {
        return this.servicio;
    }
    
    public void AntecedenteProyecto.setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public String AntecedenteProyecto.getTipoSolucion() {
        return this.tipoSolucion;
    }
    
    public void AntecedenteProyecto.setTipoSolucion(String tipoSolucion) {
        this.tipoSolucion = tipoSolucion;
    }
    
    public SBU AntecedenteProyecto.getSbu() {
        return this.sbu;
    }
    
    public void AntecedenteProyecto.setSbu(SBU sbu) {
        this.sbu = sbu;
    }
    
    public Pais AntecedenteProyecto.getPais() {
        return this.pais;
    }
    
    public void AntecedenteProyecto.setPais(Pais pais) {
        this.pais = pais;
    }
    
    public String AntecedenteProyecto.getLiderProyecto() {
        return this.liderProyecto;
    }
    
    public void AntecedenteProyecto.setLiderProyecto(String liderProyecto) {
        this.liderProyecto = liderProyecto;
    }
    
    public Date AntecedenteProyecto.getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void AntecedenteProyecto.setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public Date AntecedenteProyecto.getFechaFin() {
        return this.fechaFin;
    }
    
    public void AntecedenteProyecto.setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public String AntecedenteProyecto.getAreaUsuaria() {
        return this.areaUsuaria;
    }
    
    public void AntecedenteProyecto.setAreaUsuaria(String areaUsuaria) {
        this.areaUsuaria = areaUsuaria;
    }
    
    public Integer AntecedenteProyecto.getDuracion() {
        return this.duracion;
    }
    
    public void AntecedenteProyecto.setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    
    public Integer AntecedenteProyecto.getHoras() {
        return this.horas;
    }
    
    public void AntecedenteProyecto.setHoras(Integer horas) {
        this.horas = horas;
    }
    
    public String AntecedenteProyecto.getRecursosPerfiles() {
        return this.recursosPerfiles;
    }
    
    public void AntecedenteProyecto.setRecursosPerfiles(String recursosPerfiles) {
        this.recursosPerfiles = recursosPerfiles;
    }
    
    public BigDecimal AntecedenteProyecto.getMontoContrato() {
        return this.montoContrato;
    }
    
    public void AntecedenteProyecto.setMontoContrato(BigDecimal montoContrato) {
        this.montoContrato = montoContrato;
    }
    
    public MonedaContrato AntecedenteProyecto.getMonedaContrato() {
        return this.monedaContrato;
    }
    
    public void AntecedenteProyecto.setMonedaContrato(MonedaContrato monedaContrato) {
        this.monedaContrato = monedaContrato;
    }
    
    public BigDecimal AntecedenteProyecto.getCotizacionMoneda() {
        return this.cotizacionMoneda;
    }
    
    public void AntecedenteProyecto.setCotizacionMoneda(BigDecimal cotizacionMoneda) {
        this.cotizacionMoneda = cotizacionMoneda;
    }
    
    public String AntecedenteProyecto.getDescFuncionalProyecto() {
        return this.descFuncionalProyecto;
    }
    
    public void AntecedenteProyecto.setDescFuncionalProyecto(String descFuncionalProyecto) {
        this.descFuncionalProyecto = descFuncionalProyecto;
    }
    
    public String AntecedenteProyecto.getDescTecnicaProyecto() {
        return this.descTecnicaProyecto;
    }
    
    public void AntecedenteProyecto.setDescTecnicaProyecto(String descTecnicaProyecto) {
        this.descTecnicaProyecto = descTecnicaProyecto;
    }
    
    public String AntecedenteProyecto.getLogrosObtenidos() {
        return this.logrosObtenidos;
    }
    
    public void AntecedenteProyecto.setLogrosObtenidos(String logrosObtenidos) {
        this.logrosObtenidos = logrosObtenidos;
    }
    
    public String AntecedenteProyecto.getTags() {
        return this.tags;
    }
    
    public void AntecedenteProyecto.setTags(String tags) {
        this.tags = tags;
    }
    
    public byte[] AntecedenteProyecto.getDiagrama() {
        return this.diagrama;
    }
    
    public void AntecedenteProyecto.setDiagrama(byte[] diagrama) {
        this.diagrama = diagrama;
    }
    
}
