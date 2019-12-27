package com.mercury.tours;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Radio_Btn_example {
	
	ChromeDriver driver;
	ChromeOptions options=new ChromeOptions();
  @Test
  public void signOn() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		WebElement element=driver.findElement(By.linkText("SIGN-OFF"));
		String ActValue=element.getText();
		String ExpValue="SIGN-OFF"; 
		System.out.println(ActValue);
		Assert.assertEquals(ExpValue, ActValue);
		
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
		
		
		//Select Business class
		
		WebElement element2=driver.findElement(By.cssSelector("input[value='Business']"));
		element2.click();
		Thread.sleep(6000);
		Assert.assertEquals(element2.isSelected(), true);
		
		String ExpUrl="http://newtours.demoaut.com/mercuryreservation.php";
		String ActUrl=driver.getCurrentUrl();
		System.out.println(ActUrl);
		Assert.assertEquals(ExpUrl, ActUrl);
	/*	
		String ExpTitle="Find a Flight: Mercury Tours:";
		String ActTitle=driver.getTitle();
		System.out.println(ActTitle);
		Assert.assertEquals(ExpTitle, ActTitle);
		element.click();*/
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
