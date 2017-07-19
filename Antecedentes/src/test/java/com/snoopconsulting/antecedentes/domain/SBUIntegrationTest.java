package com.snoopconsulting.antecedentes.domain;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.test.context.ContextConfiguration;

@RooIntegrationTest(entity = SBU.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring-test/applicationContext*-test.xml")
public class SBUIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
