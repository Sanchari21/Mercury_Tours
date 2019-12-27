package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginPage_Example_UsingDataProvider extends ApplicationTestData {
	
	ChromeDriver driver;
  @Test(dataProvider="Login")
  public void signOn(String Uname,String StrPwd) throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(Uname);
		driver.findElement(By.name("password")).sendKeys(StrPwd);
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		driver.findElement(By.linkText("SIGN-OFF")).click();
		Thread.sleep(6000);
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
