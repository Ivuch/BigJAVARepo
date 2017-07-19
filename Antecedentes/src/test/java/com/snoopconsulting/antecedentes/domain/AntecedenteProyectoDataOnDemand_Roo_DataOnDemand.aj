// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.snoopconsulting.antecedentes.domain;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.AntecedenteProyectoDataOnDemand;
import com.snoopconsulting.antecedentes.domain.ContactoDataOnDemand;
import com.snoopconsulting.antecedentes.domain.CuentaDataOnDemand;
import com.snoopconsulting.antecedentes.domain.EstadoAntecedente;
import com.snoopconsulting.antecedentes.domain.MonedaContrato;
import com.snoopconsulting.antecedentes.domain.Pais;
import com.snoopconsulting.antecedentes.domain.PaisDataOnDemand;
import com.snoopconsulting.antecedentes.domain.SBU;
import com.snoopconsulting.antecedentes.domain.SBUDataOnDemand;
import com.snoopconsulting.antecedentes.domain.Servicio;
import com.snoopconsulting.antecedentes.domain.ServicioDataOnDemand;
import com.snoopconsulting.antecedentes.domain.UsuarioDataOnDemand;
import com.snoopconsulting.antecedentes.domain.ValidacionDataOnDemand;
import com.snoopconsulting.antecedentes.repository.jpa.AntecedenteRepository;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect AntecedenteProyectoDataOnDemand_Roo_DataOnDemand {
    
    declare @type: AntecedenteProyectoDataOnDemand: @Component;
    
    private Random AntecedenteProyectoDataOnDemand.rnd = new SecureRandom();
    
    private List<AntecedenteProyecto> AntecedenteProyectoDataOnDemand.data;
    
    @Autowired
    CuentaDataOnDemand AntecedenteProyectoDataOnDemand.cuentaDataOnDemand;
    
    @Autowired
    ContactoDataOnDemand AntecedenteProyectoDataOnDemand.contactoDataOnDemand;
    
    @Autowired
    UsuarioDataOnDemand AntecedenteProyectoDataOnDemand.usuarioDataOnDemand;
    
    @Autowired
    PaisDataOnDemand AntecedenteProyectoDataOnDemand.paisDataOnDemand;
    
    @Autowired
    SBUDataOnDemand AntecedenteProyectoDataOnDemand.sBUDataOnDemand;
    
    @Autowired
    ServicioDataOnDemand AntecedenteProyectoDataOnDemand.servicioDataOnDemand;
    
    @Autowired
    ValidacionDataOnDemand AntecedenteProyectoDataOnDemand.validacionDataOnDemand;
    
    @Autowired
    AntecedenteRepository AntecedenteProyectoDataOnDemand.antecedenteRepository;
    
    public AntecedenteProyecto AntecedenteProyectoDataOnDemand.getNewTransientAntecedenteProyecto(int index) {
        AntecedenteProyecto obj = new AntecedenteProyecto();
        setAreaUsuaria(obj, index);
        setCotizacionMoneda(obj, index);
        setDescFuncionalProyecto(obj, index);
        setDescTecnicaProyecto(obj, index);
        setDiagrama(obj, index);
        setDuracion(obj, index);
        setEstado(obj, index);
        setFechaCarga(obj, index);
        setFechaFin(obj, index);
        setFechaInicio(obj, index);
        setFechaModificacion(obj, index);
        setHoras(obj, index);
        setLiderProyecto(obj, index);
        setLogrosObtenidos(obj, index);
        setMonedaContrato(obj, index);
        setMontoContrato(obj, index);
        setNombre(obj, index);
        setPais(obj, index);
        setRecursosPerfiles(obj, index);
        setSbu(obj, index);
        setServicio(obj, index);
        setTags(obj, index);
        setTipoSolucion(obj, index);
        return obj;
    }
    
    public void AntecedenteProyectoDataOnDemand.setAreaUsuaria(AntecedenteProyecto obj, int index) {
        String areaUsuaria = "areaUsuaria_" + index;
        obj.setAreaUsuaria(areaUsuaria);
    }
    
    public void AntecedenteProyectoDataOnDemand.setCotizacionMoneda(AntecedenteProyecto obj, int index) {
        BigDecimal cotizacionMoneda = BigDecimal.valueOf(index);
        obj.setCotizacionMoneda(cotizacionMoneda);
    }
    
    public void AntecedenteProyectoDataOnDemand.setDescFuncionalProyecto(AntecedenteProyecto obj, int index) {
        String descFuncionalProyecto = "descFuncionalProyectoxxxxxxxxxxxxxxxxxxxxxxxxxxx_" + index;
        obj.setDescFuncionalProyecto(descFuncionalProyecto);
    }
    
    public void AntecedenteProyectoDataOnDemand.setDescTecnicaProyecto(AntecedenteProyecto obj, int index) {
        String descTecnicaProyecto = "descTecnicaProyectoxxxxxxxxxxxxxxxxxxxxxxxxxxxxx_" + index;
        obj.setDescTecnicaProyecto(descTecnicaProyecto);
    }
    
    public void AntecedenteProyectoDataOnDemand.setDiagrama(AntecedenteProyecto obj, int index) {
        byte[] diagrama = String.valueOf(index).getBytes();
        obj.setDiagrama(diagrama);
    }
    
    public void AntecedenteProyectoDataOnDemand.setDuracion(AntecedenteProyecto obj, int index) {
        Integer duracion = new Integer(index);
        obj.setDuracion(duracion);
    }
    
    public void AntecedenteProyectoDataOnDemand.setEstado(AntecedenteProyecto obj, int index) {
        EstadoAntecedente estado = EstadoAntecedente.class.getEnumConstants()[0];
        obj.setEstado(estado);
    }
    
    public void AntecedenteProyectoDataOnDemand.setFechaCarga(AntecedenteProyecto obj, int index) {
        Date fechaCarga = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCarga(fechaCarga);
    }
    
    public void AntecedenteProyectoDataOnDemand.setFechaFin(AntecedenteProyecto obj, int index) {
        Date fechaFin = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaFin(fechaFin);
    }
    
    public void AntecedenteProyectoDataOnDemand.setFechaInicio(AntecedenteProyecto obj, int index) {
        Date fechaInicio = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaInicio(fechaInicio);
    }
    
    public void AntecedenteProyectoDataOnDemand.setFechaModificacion(AntecedenteProyecto obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }
    
    public void AntecedenteProyectoDataOnDemand.setHoras(AntecedenteProyecto obj, int index) {
        Integer horas = new Integer(index);
        obj.setHoras(horas);
    }
    
    public void AntecedenteProyectoDataOnDemand.setLiderProyecto(AntecedenteProyecto obj, int index) {
        String liderProyecto = "liderProyecto_" + index;
        obj.setLiderProyecto(liderProyecto);
    }
    
    public void AntecedenteProyectoDataOnDemand.setLogrosObtenidos(AntecedenteProyecto obj, int index) {
        String logrosObtenidos = "logrosObtenidosxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx_" + index;
        obj.setLogrosObtenidos(logrosObtenidos);
    }
    
    public void AntecedenteProyectoDataOnDemand.setMonedaContrato(AntecedenteProyecto obj, int index) {
        MonedaContrato monedaContrato = null;
        obj.setMonedaContrato(monedaContrato);
    }
    
    public void AntecedenteProyectoDataOnDemand.setMontoContrato(AntecedenteProyecto obj, int index) {
        BigDecimal montoContrato = BigDecimal.valueOf(index);
        obj.setMontoContrato(montoContrato);
    }
    
    public void AntecedenteProyectoDataOnDemand.setNombre(AntecedenteProyecto obj, int index) {
        String nombre = "nombre_" + index;
        if (nombre.length() > 255) {
            nombre = nombre.substring(0, 255);
        }
        obj.setNombre(nombre);
    }
    
    public void AntecedenteProyectoDataOnDemand.setPais(AntecedenteProyecto obj, int index) {
        Pais pais = paisDataOnDemand.getRandomPais();
        obj.setPais(pais);
    }
    
    public void AntecedenteProyectoDataOnDemand.setRecursosPerfiles(AntecedenteProyecto obj, int index) {
        String recursosPerfiles = "recursosPerfilesxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx_" + index;
        obj.setRecursosPerfiles(recursosPerfiles);
    }
    
    public void AntecedenteProyectoDataOnDemand.setSbu(AntecedenteProyecto obj, int index) {
        SBU sbu = sBUDataOnDemand.getRandomSBU();
        obj.setSbu(sbu);
    }
    
    public void AntecedenteProyectoDataOnDemand.setServicio(AntecedenteProyecto obj, int index) {
        Servicio servicio = servicioDataOnDemand.getRandomServicio();
        obj.setServicio(servicio);
    }
    
    public void AntecedenteProyectoDataOnDemand.setTags(AntecedenteProyecto obj, int index) {
        String tags = "tags_" + index;
        obj.setTags(tags);
    }
    
    public void AntecedenteProyectoDataOnDemand.setTipoSolucion(AntecedenteProyecto obj, int index) {
        String tipoSolucion = "tipoSolucion_" + index;
        obj.setTipoSolucion(tipoSolucion);
    }
    
    public AntecedenteProyecto AntecedenteProyectoDataOnDemand.getSpecificAntecedenteProyecto(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        AntecedenteProyecto obj = data.get(index);
        Long id = obj.getId();
        return antecedenteRepository.findOne(id);
    }
    
    public AntecedenteProyecto AntecedenteProyectoDataOnDemand.getRandomAntecedenteProyecto() {
        init();
        AntecedenteProyecto obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return antecedenteRepository.findOne(id);
    }
    
    public boolean AntecedenteProyectoDataOnDemand.modifyAntecedenteProyecto(AntecedenteProyecto obj) {
        return false;
    }
    
    public void AntecedenteProyectoDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = antecedenteRepository.findAll(new org.springframework.data.domain.PageRequest(from / to, to)).getContent();
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'AntecedenteProyecto' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<AntecedenteProyecto>();
        for (int i = 0; i < 10; i++) {
            AntecedenteProyecto obj = getNewTransientAntecedenteProyecto(i);
            try {
                antecedenteRepository.save(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            antecedenteRepository.flush();
            data.add(obj);
        }
    }
    
}
