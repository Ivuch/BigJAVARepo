package com.snoopconsulting.antecedentes.testfuncional;


import org.junit.Test;
import org.openqa.selenium.By;

public class LogInAdminIT extends TestPadre{

  @Test
  public void testLogInAdmin() throws Exception {
    driver.get(baseUrl + "/login");
    driver.findElement(By.name("j_username")).sendKeys("admin");
    driver.findElement(By.name("j_password")).sendKeys("admin");
    driver.findElement(By.id("_spring_security_remember_me")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

}
