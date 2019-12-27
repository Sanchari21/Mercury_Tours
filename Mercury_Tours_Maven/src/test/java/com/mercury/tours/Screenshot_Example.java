package com.mercury.tours;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Screenshot_Example {
	
	ChromeDriver driver;
	ChromeOptions options=new ChromeOptions();
	String ScreenshotFilepath="C:\\Selenium_Training\\workspace\\Mercury_Tours_Maven\\Screenshot";
  @Test
  public void signOn() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("logins")).click();

		
  }
  @AfterMethod
  public void captureScreenshot(ITestResult result) throws IOException
  {
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  File BrowserScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //FileUtils.copyFile(BrowserScreenshot,new File("C:\\Selenium_Training\\workspace\\Mercury_Tours_Maven\\Screenshot\\login.png"));
		 FileUtils.copyFile(BrowserScreenshot,new File(ScreenshotFilepath+"/"+result.getName()+"_"+System.nanoTime()+"."+"png"));
	  }
	  
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
		driver.get("http://newtours.demoaut.com/");
  }

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }

}
