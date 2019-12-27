package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class SignOn_InternetExplorer_Example {
	
	InternetExplorerDriver driver;
	//WebDriver driver;
  @Test
  public void login() throws InterruptedException {
	  Thread.sleep(6000);
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		
  }
  @BeforeTest
 
	  public void launchBrowser() {
		  String absolutePath= System.getProperty("user.dir");
			String filePath=absolutePath+"\\Drivers"+"\\IEDriverServer.exe";
		  //String filePath=absolutePath+"\\Drivers"+"\\geckodriver.exe";
			System.setProperty("webdriver.ie.driver",filePath);
		  //System.setProperty("webdriver.gecko.driver",filePath);
			driver=new InternetExplorerDriver();
		   //driver=new FirefoxDriver();
			driver.manage().window().maximize();
			//driver.get("http://newtours.demoaut.com/");
			driver.get("http://newtours.demoaut.com/");
  }

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }

}
