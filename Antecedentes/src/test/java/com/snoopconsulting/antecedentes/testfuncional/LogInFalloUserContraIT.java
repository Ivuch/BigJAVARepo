package com.snoopconsulting.antecedentes.testfuncional;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class LogInFalloUserContraIT extends TestPadre{

  @Test
  public void testLogInFalloUserContra() throws Exception {
    driver.get(baseUrl + "/login");
    driver.findElement(By.name("j_username")).sendKeys("pedro");
    driver.findElement(By.name("j_password")).sendKeys("pedro");
    driver.findElement(By.id("_spring_security_remember_me")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    // ERROR: Caught exception [unknown command []]
    boolean visible = isElementPresent(By.cssSelector("DIV.alert.alert-error"));
    assertTrue("Debe aparecer un error", visible);
    
  }

}
