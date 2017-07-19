//package com.snoopconsulting.antecedentes.testfuncional;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;
//
//public class CrearAntecedenteIT extends TestPadre{
//	
//  @Test
//  public void testCrearAntecedente() throws Exception {
//    driver.findElement(By.linkText("Nuevo antecedente")).click();
//    assertEquals("Paso 1 /", driver.findElement(By.cssSelector("ol.breadcrumb li.active")).getText());
//    driver.findElement(By.id("nombre_del_proyecto")).sendKeys("sarasa");
//    driver.findElement(By.id("cliente")).sendKeys("Cenco");
//    for (int second = 0;; second++) {
//    	if (second >= 60) fail("timeout");
//    	try { if (driver.findElement(By.linkText("Cencosud Argentina")).isDisplayed()) break; } catch (Exception e) {}
//    	Thread.sleep(1000);
//    }
//
//    driver.findElement(By.linkText("Cencosud Argentina")).click();
//    driver.findElement(By.id("lider_proyecto")).sendKeys("Roman Cunci");
//    for (int second = 0;; second++) {
//    	if (second >= 60) fail("timeout");
//    	try { if ("Cencosud Argentina".equals(driver.findElement(By.cssSelector("input#clienteFinal")).getAttribute("value"))) break; } catch (Exception e) {}
//    	Thread.sleep(1000);
//    }
//
//    driver.findElement(By.name("commit")).click();
//    new Select(driver.findElement(By.id("servicio"))).selectByVisibleText("Desarrollo");
//    new Select(driver.findElement(By.id("tipo_solucion"))).selectByVisibleText("CRM");
//    new Select(driver.findElement(By.id("pais"))).selectByVisibleText("Argentina");
//    new Select(driver.findElement(By.id("sbu"))).selectByVisibleText("Consultoria");
//    driver.findElement(By.id("monto_contrato")).sendKeys("1111111111");
//    driver.findElement(By.id("cotizacion_moneda")).sendKeys("1");
//    driver.findElement(By.name("commit")).click();
//    new Select(driver.findElement(By.id("contacto_idCrm"))).selectByVisibleText("Silvana Bonaccio");
//    driver.findElement(By.id("area_usuaria")).sendKeys("Calidad");
//    for (int second = 0;; second++) {
//    	if (second >= 60) fail("timeout");
//    	try { if ("silvana.bonaccio@cencosud.com.ar".equals(driver.findElement(By.cssSelector("input#email_CF")).getAttribute("value"))) break; } catch (Exception e) {}
//    	Thread.sleep(1000);
//    }
//
//    driver.findElement(By.name("commit")).click();
//    driver.findElement(By.cssSelector("input#datetimepicker1")).sendKeys("14/08/2013");
//    driver.findElement(By.cssSelector("input#datetimepicker2")).sendKeys("15/10/2013");
//    driver.findElement(By.id("horas")).sendKeys("20");
//    driver.findElement(By.id("tags")).sendKeys("sarasa");
//    // ERROR: Caught exception [ERROR: Unsupported command [runScript | javascript{this.browserbot.getUserWindow().$('#recursosPerfiles').data('wysihtml5').editor.setValue('01234567890123456789012345678901234567890123456789');} | ]]
//    // ERROR: Caught exception [ERROR: Unsupported command [runScript | javascript{this.browserbot.getUserWindow().$('#descFuncionalProyecto').data('wysihtml5').editor.setValue('01234567890123456789012345678901234567890123456789');} | ]]
//    // ERROR: Caught exception [ERROR: Unsupported command [runScript | javascript{this.browserbot.getUserWindow().$('#descTecnicaProyecto').data('wysihtml5').editor.setValue('01234567890123456789012345678901234567890123456789');} | ]]
//    // ERROR: Caught exception [ERROR: Unsupported command [runScript | javascript{this.browserbot.getUserWindow().$('#logrosObtenidos').data('wysihtml5').editor.setValue('01234567890123456789012345678901234567890123456789');} | ]]
//    driver.findElement(By.name("commit")).click();
//  }
//
//}
