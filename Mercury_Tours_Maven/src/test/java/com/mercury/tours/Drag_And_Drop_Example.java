package com.mercury.tours;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Drag_And_Drop_Example {
	
	ChromeDriver driver;
	ChromeOptions options=new ChromeOptions();
  @Test
  public void signOn() throws InterruptedException {
	  Thread.sleep(4000);
	  Actions action=new Actions(driver);
	  WebElement drag=driver.findElementById("draggable");
	  WebElement drop=driver.findElementById("droppable");
	  action.dragAndDrop(drag, drop).build().perform();
	  Thread.sleep(4000);
		
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
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
  }

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }


}
