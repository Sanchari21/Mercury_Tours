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

public class Testng_Priority_Example {
	
	ChromeDriver driver;
	ChromeOptions options=new ChromeOptions();
 
	@Test(priority=1)
  public void signOn() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
  }
		
  @Test(priority=2)
  public void verifyAndSelectTrip() throws InterruptedException 
  {
		//To verify whether roundtrip is selected or not
		String str=driver.findElement(By.xpath("//input[@value='roundtrip']")).getAttribute("checked");
		if(str.equalsIgnoreCase("true"))
		{
			System.out.println("Round trip selected");
		}
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		Thread.sleep(6000);
		
		//verify Oneway get selected
		WebElement element1=driver.findElement(By.xpath("//input[@value='oneway']"));
		Assert.assertEquals(element1.isSelected(), true);
  }	
		
		//Select Business class
  @Test(priority=3)
  public void selectFlight() throws InterruptedException
  {
		WebElement element2=driver.findElement(By.cssSelector("input[value='Business']"));
		element2.click();
		Thread.sleep(6000);
		Assert.assertEquals(element2.isSelected(), true);
		
		//Select passenger from dropdown
		Select selectpassenger=new Select(driver.findElement(By.name("passCount")));
		selectpassenger.selectByValue("4");
		
		//Select Departing from Dropdown
		
		Select selectDeparting=new Select(driver.findElement(By.name("fromPort")));
		selectDeparting.selectByValue("London");
		
		//Select Airline
		
		Select selectAirline=new Select(driver.findElement(By.name("airline")));
		selectAirline.selectByVisibleText("Unified Airlines");
		Thread.sleep(6000);
  
		//Click Continue
		
		driver.findElement(By.name("findFlights")).click();
  }
  
  @Test(priority=4)
  public void verifyPageisDisplayed() throws InterruptedException
  {
		
		String depart=driver.findElement(By.xpath("//td[@class='title']//font[text()='DEPART']")).getText();
		System.out.println(depart);
		Assert.assertEquals("DEPART", depart);
		Thread.sleep(6000);
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
