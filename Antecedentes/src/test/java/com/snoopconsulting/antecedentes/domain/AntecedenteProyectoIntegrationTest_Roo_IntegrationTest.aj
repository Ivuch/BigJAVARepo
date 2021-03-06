// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.snoopconsulting.antecedentes.domain;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyectoDataOnDemand;
import com.snoopconsulting.antecedentes.domain.AntecedenteProyectoIntegrationTest;
import com.snoopconsulting.antecedentes.repository.jpa.AntecedenteRepository;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AntecedenteProyectoIntegrationTest_Roo_IntegrationTest {
    
    declare @type: AntecedenteProyectoIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: AntecedenteProyectoIntegrationTest: @Transactional;
    
    @Autowired
    AntecedenteProyectoDataOnDemand AntecedenteProyectoIntegrationTest.dod;
    
    @Autowired
    AntecedenteRepository AntecedenteProyectoIntegrationTest.antecedenteRepository;
    
    @Test
    public void AntecedenteProyectoIntegrationTest.testCount() {
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to initialize correctly", dod.getRandomAntecedenteProyecto());
        long count = antecedenteRepository.count();
        Assert.assertTrue("Counter for 'AntecedenteProyecto' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void AntecedenteProyectoIntegrationTest.testFind() {
        AntecedenteProyecto obj = dod.getRandomAntecedenteProyecto();
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to provide an identifier", id);
        obj = antecedenteRepository.findOne(id);
        Assert.assertNotNull("Find method for 'AntecedenteProyecto' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'AntecedenteProyecto' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void AntecedenteProyectoIntegrationTest.testFindAll() {
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to initialize correctly", dod.getRandomAntecedenteProyecto());
        long count = antecedenteRepository.count();
        Assert.assertTrue("Too expensive to perform a find all test for 'AntecedenteProyecto', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<AntecedenteProyecto> result = antecedenteRepository.findAll();
        Assert.assertNotNull("Find all method for 'AntecedenteProyecto' illegally returned null", result);
        Assert.assertTrue("Find all method for 'AntecedenteProyecto' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void AntecedenteProyectoIntegrationTest.testFindEntries() {
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to initialize correctly", dod.getRandomAntecedenteProyecto());
        long count = antecedenteRepository.count();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<AntecedenteProyecto> result = antecedenteRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
        Assert.assertNotNull("Find entries method for 'AntecedenteProyecto' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'AntecedenteProyecto' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void AntecedenteProyectoIntegrationTest.testFlush() {
        AntecedenteProyecto obj = dod.getRandomAntecedenteProyecto();
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to provide an identifier", id);
        obj = antecedenteRepository.findOne(id);
        Assert.assertNotNull("Find method for 'AntecedenteProyecto' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyAntecedenteProyecto(obj);
        Integer currentVersion = obj.getVersion();
        antecedenteRepository.flush();
        Assert.assertTrue("Version for 'AntecedenteProyecto' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void AntecedenteProyectoIntegrationTest.testSaveUpdate() {
        AntecedenteProyecto obj = dod.getRandomAntecedenteProyecto();
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to provide an identifier", id);
        obj = antecedenteRepository.findOne(id);
        boolean modified =  dod.modifyAntecedenteProyecto(obj);
        Integer currentVersion = obj.getVersion();
        AntecedenteProyecto merged = antecedenteRepository.save(obj);
        antecedenteRepository.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'AntecedenteProyecto' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void AntecedenteProyectoIntegrationTest.testSave() {
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to initialize correctly", dod.getRandomAntecedenteProyecto());
        AntecedenteProyecto obj = dod.getNewTransientAntecedenteProyecto(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'AntecedenteProyecto' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'AntecedenteProyecto' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void AntecedenteProyectoIntegrationTest.testDelete() {
        AntecedenteProyecto obj = dod.getRandomAntecedenteProyecto();
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'AntecedenteProyecto' failed to provide an identifier", id);
        obj = antecedenteRepository.findOne(id);
        antecedenteRepository.delete(obj);
        antecedenteRepository.flush();
        Assert.assertNull("Failed to remove 'AntecedenteProyecto' with identifier '" + id + "'", antecedenteRepository.findOne(id));
    }
    
}
