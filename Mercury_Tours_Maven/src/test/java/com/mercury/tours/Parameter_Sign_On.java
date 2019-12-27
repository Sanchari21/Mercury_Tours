package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Parameter_Sign_On {
	
	ChromeDriver driver;
  @Test
  @Parameters({"uname","upass"})
  public void login(String uname,String upass) throws InterruptedException {
	  Thread.sleep(6000);
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(upass);
		driver.findElement(By.name("login")).click();
		
  }
  @BeforeTest
 
	  public void launchBrowser() {
		  String absolutePath= System.getProperty("user.dir");
			//String filePath=absolutePath+"\\chromedriver.exe";
			String filePath=absolutePath+"\\Drivers"+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",filePath);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://newtours.demoaut.com/");
  }

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }

}
