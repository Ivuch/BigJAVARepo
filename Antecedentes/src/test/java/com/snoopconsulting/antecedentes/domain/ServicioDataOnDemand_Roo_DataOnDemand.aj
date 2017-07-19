// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.snoopconsulting.antecedentes.domain;

import com.snoopconsulting.antecedentes.domain.Servicio;
import com.snoopconsulting.antecedentes.domain.ServicioDataOnDemand;
import com.snoopconsulting.antecedentes.repository.jpa.ServicioRepository;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect ServicioDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ServicioDataOnDemand: @Component;
    
    private Random ServicioDataOnDemand.rnd = new SecureRandom();
    
    private List<Servicio> ServicioDataOnDemand.data;
    
    @Autowired
    ServicioRepository ServicioDataOnDemand.servicioRepository;
    
    public Servicio ServicioDataOnDemand.getNewTransientServicio(int index) {
        Servicio obj = new Servicio();
        setNombre(obj, index);
        return obj;
    }
    
    public void ServicioDataOnDemand.setNombre(Servicio obj, int index) {
        String nombre = "nombre_" + index;
        obj.setNombre(nombre);
    }
    
    public Servicio ServicioDataOnDemand.getSpecificServicio(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Servicio obj = data.get(index);
        Long id = obj.getId();
        return servicioRepository.findOne(id);
    }
    
    public Servicio ServicioDataOnDemand.getRandomServicio() {
        init();
        Servicio obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return servicioRepository.findOne(id);
    }
    
    public boolean ServicioDataOnDemand.modifyServicio(Servicio obj) {
        return false;
    }
    
    public void ServicioDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = servicioRepository.findAll(new org.springframework.data.domain.PageRequest(from / to, to)).getContent();
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Servicio' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Servicio>();
        for (int i = 0; i < 10; i++) {
            Servicio obj = getNewTransientServicio(i);
            try {
                servicioRepository.save(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            servicioRepository.flush();
            data.add(obj);
        }
    }
    
}
