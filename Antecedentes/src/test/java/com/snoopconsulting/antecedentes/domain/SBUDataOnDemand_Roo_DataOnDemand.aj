// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.snoopconsulting.antecedentes.domain;

import com.snoopconsulting.antecedentes.domain.SBU;
import com.snoopconsulting.antecedentes.domain.SBUDataOnDemand;
import com.snoopconsulting.antecedentes.repository.jpa.SBURepository;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect SBUDataOnDemand_Roo_DataOnDemand {
    
    declare @type: SBUDataOnDemand: @Component;
    
    private Random SBUDataOnDemand.rnd = new SecureRandom();
    
    private List<SBU> SBUDataOnDemand.data;
    
    @Autowired
    SBURepository SBUDataOnDemand.sBURepository;
    
    public SBU SBUDataOnDemand.getNewTransientSBU(int index) {
        SBU obj = new SBU();
        setNombre(obj, index);
        return obj;
    }
    
    public void SBUDataOnDemand.setNombre(SBU obj, int index) {
        String nombre = "nombre_" + index;
        obj.setNombre(nombre);
    }
    
    public SBU SBUDataOnDemand.getSpecificSBU(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        SBU obj = data.get(index);
        Long id = obj.getId();
        return sBURepository.findOne(id);
    }
    
    public SBU SBUDataOnDemand.getRandomSBU() {
        init();
        SBU obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return sBURepository.findOne(id);
    }
    
    public boolean SBUDataOnDemand.modifySBU(SBU obj) {
        return false;
    }
    
    public void SBUDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = sBURepository.findAll(new org.springframework.data.domain.PageRequest(from / to, to)).getContent();
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'SBU' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<SBU>();
        for (int i = 0; i < 10; i++) {
            SBU obj = getNewTransientSBU(i);
            try {
                sBURepository.save(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            sBURepository.flush();
            data.add(obj);
        }
    }
    
}
