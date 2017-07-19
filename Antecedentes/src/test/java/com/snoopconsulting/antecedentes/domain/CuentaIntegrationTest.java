package com.snoopconsulting.antecedentes.domain;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.test.context.ContextConfiguration;

@RooIntegrationTest(entity = Cuenta.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring-test/applicationContext*-test.xml")
public class CuentaIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
