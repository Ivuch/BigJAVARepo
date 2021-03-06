// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.snoopconsulting.antecedentes.domain;

import com.snoopconsulting.antecedentes.domain.Contacto;
import com.snoopconsulting.antecedentes.domain.ContactoDataOnDemand;
import com.snoopconsulting.antecedentes.repository.jpa.ContactoRepository;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect ContactoDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ContactoDataOnDemand: @Component;
    
    private Random ContactoDataOnDemand.rnd = new SecureRandom();
    
    private List<Contacto> ContactoDataOnDemand.data;
    
    @Autowired
    ContactoRepository ContactoDataOnDemand.contactoRepository;
    
    public Contacto ContactoDataOnDemand.getNewTransientContacto(int index) {
        Contacto obj = new Contacto();
        setAreaPerteneciente(obj, index);
        setEmail(obj, index);
        setIdCrm(obj, index);
        setNombre(obj, index);
        setTelefono(obj, index);
        return obj;
    }
    
    public void ContactoDataOnDemand.setAreaPerteneciente(Contacto obj, int index) {
        String areaPerteneciente = "areaPerteneciente_" + index;
        obj.setAreaPerteneciente(areaPerteneciente);
    }
    
    public void ContactoDataOnDemand.setEmail(Contacto obj, int index) {
        String email = "foo" + index + "@bar.com";
        obj.setEmail(email);
    }
    
    public void ContactoDataOnDemand.setIdCrm(Contacto obj, int index) {
        String idCrm = "idCrm_" + index;
        obj.setIdCrm(idCrm);
    }
    
    public void ContactoDataOnDemand.setNombre(Contacto obj, int index) {
        String nombre = "nombre_" + index;
        obj.setNombre(nombre);
    }
    
    public void ContactoDataOnDemand.setTelefono(Contacto obj, int index) {
        String telefono = "telefono_" + index;
        obj.setTelefono(telefono);
    }
    
    public Contacto ContactoDataOnDemand.getSpecificContacto(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Contacto obj = data.get(index);
        Long id = obj.getId();
        return contactoRepository.findOne(id);
    }
    
    public Contacto ContactoDataOnDemand.getRandomContacto() {
        init();
        Contacto obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return contactoRepository.findOne(id);
    }
    
    public boolean ContactoDataOnDemand.modifyContacto(Contacto obj) {
        return false;
    }
    
    public void ContactoDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = contactoRepository.findAll(new org.springframework.data.domain.PageRequest(from / to, to)).getContent();
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Contacto' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Contacto>();
        for (int i = 0; i < 10; i++) {
            Contacto obj = getNewTransientContacto(i);
            try {
                contactoRepository.save(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            contactoRepository.flush();
            data.add(obj);
        }
    }
    
}
