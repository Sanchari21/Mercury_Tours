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

public class CrossBrowser_Example extends ApplicationTestData {
	
	WebDriver driver;
  @Test(dataProvider="Login")
  public void login( String uname,String upass ) throws InterruptedException {
	  Thread.sleep(6000);
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(upass);
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		driver.findElement(By.linkText("SIGN-OFF")).click();
		Thread.sleep(6000);
  }
  @BeforeTest
  @Parameters("browser")
  public void launchBrowser(String browser) {
	  
	  if(browser.equalsIgnoreCase("firefox"))
	  {
		  String absolutePath= System.getProperty("user.dir");
		  String filePath=absolutePath+"\\Drivers"+"\\geckodriver.exe";
		  System.setProperty("webdriver.gecko.driver",filePath);
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get("http://newtours.demoaut.com/");
	  }
	  else if(browser.equalsIgnoreCase("chrome"))
	  {
		  String absolutePath= System.getProperty("user.dir");
		  String filePath=absolutePath+"\\Drivers"+"\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver",filePath);
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://newtours.demoaut.com/");
	  }
	  else if(browser.equalsIgnoreCase("IE"))
	  {
		  String absolutePath= System.getProperty("user.dir");
		  String filePath=absolutePath+"\\Drivers"+"\\IEDriverServer.exe";
		  System.setProperty("webdriver.ie.driver",filePath);
		  driver=new InternetExplorerDriver();
		  driver.manage().window().maximize();
		  driver.get("http://newtours.demoaut.com/");
	  }
	 /*else {
		  throw new Exception("");
	  }*/
}

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }

}
