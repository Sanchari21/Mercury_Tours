package com.mercury.tours;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class Upload_Files_Using_RobotClass {
	
	ChromeDriver driver;
	ChromeOptions options=new ChromeOptions();
	String ScreenshotFilepath="C:\\Selenium_Training\\workspace\\Mercury_Tours_Maven\\Screenshot";
  @Test
  public void testUpload() throws InterruptedException {
	  String absolutePath=System.getProperty("user.dir");
	  String filepath=absolutePath+"\\Images\\FadedID.jpg";
	  System.out.println(filepath);
	  driver.findElement(By.id("btnChooseFiles")).click();
	  uploadFile(filepath);
	  Thread.sleep(1000);
		
  }
  
  public static void uploadFile(String fileLocation)
  {
	  try {
	  //Upload file through Robot API
	  StringSelection ss=new StringSelection(fileLocation);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	  
	  //native key strokes for CTRL,V and ENTER keys
	  Robot robot=new Robot();
	  robot.delay(1000);
	  //Press ctrl+V
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  
	  //Release ctrl+v
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyRelease(KeyEvent.VK_V);
	  
	  //Press enter
	  
	  robot.delay(1000);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  robot.delay(1000);
	  }catch(Exception exp)
	  {
		  exp.printStackTrace();
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
		driver.get("https://gofile.io/?t=uploadFiles");
  }

  @AfterTest
  public void closeBrowser() {
	  //driver.quit();
  }

}
