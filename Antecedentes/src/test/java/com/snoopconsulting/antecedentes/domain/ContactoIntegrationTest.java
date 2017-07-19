package com.snoopconsulting.antecedentes.domain;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.test.context.ContextConfiguration;

@RooIntegrationTest(entity = Contacto.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring-test/applicationContext*-test.xml")
public class ContactoIntegrationTest {

	@Test
	public void testMarkerMethod() {
	}
}
