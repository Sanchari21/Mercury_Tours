package com.mercury.tours;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class HdfcNet_Banking_HandleWindowAlert {
	
	ChromeDriver driver;
	ChromeOptions options=new ChromeOptions();
  @Test
  public void signOn() throws InterruptedException {
	  Thread.sleep(4000);
	  driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("//td/a/img[@alt='continue']")).click();
		String ActText=driver.switchTo().alert().getText();
		String ExpText="Customer ID  cannot be left blank.";
		Assert.assertEquals(ExpText, ActText);
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
		
  }
  @BeforeTest
  public void launchBrowser() {
	  String absolutePath= System.getProperty("user.dir");
		//String filePath=absolutePath+"\\chromedriver.exe";
		String filePath=absolutePath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filePath);
		options.setHeadless(false);
		//options.addArguments("incognito");
		driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
  }

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }


}
