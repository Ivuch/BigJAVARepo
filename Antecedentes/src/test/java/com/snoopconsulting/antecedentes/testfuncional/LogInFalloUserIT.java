package com.snoopconsulting.antecedentes.testfuncional;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class LogInFalloUserIT extends TestPadre{

  @Test
  public void testLogInFalloUser() throws Exception {
    driver.get(baseUrl + "/login");
    driver.findElement(By.name("j_username")).sendKeys("pedro");
    driver.findElement(By.name("j_password")).sendKeys("admin");
    driver.findElement(By.id("_spring_security_remember_me")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    boolean visible = isElementPresent(By.cssSelector("DIV.alert.alert-error"));
    assertTrue("Debe aparecer un error", visible);
    
  }


}
