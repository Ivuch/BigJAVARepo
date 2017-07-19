package com.snoopconsulting.antecedentes.testfuncional;


import org.junit.Test;
import org.openqa.selenium.By;

public class LogInIT extends TestPadre{

  @Test
   public void testLogIn() throws Exception {
	driver.get(baseUrl + "/login");
    driver.findElement(By.name("j_username")).sendKeys("user");
    driver.findElement(By.name("j_password")).sendKeys("user");
    driver.findElement(By.id("_spring_security_remember_me")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

}
