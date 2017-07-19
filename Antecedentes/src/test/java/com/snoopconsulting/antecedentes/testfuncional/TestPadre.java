package com.snoopconsulting.antecedentes.testfuncional;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestPadre {
	 protected static WebDriver driver;
	 protected static String baseUrl;
	 protected boolean acceptNextAlert = true;
	 protected StringBuffer verificationErrors = new StringBuffer(); 
	 
	  @Before
	  public void setUp() throws Exception {
		driver = new HtmlUnitDriver(true); 
	    //driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/antecedentes";
	    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	    //driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
	    driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
	  }
	  	  

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  protected boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  protected String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	  
}
