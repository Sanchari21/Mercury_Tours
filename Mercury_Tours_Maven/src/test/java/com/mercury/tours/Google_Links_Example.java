package com.mercury.tours;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Google_Links_Example {
	
	ChromeDriver driver;
	ChromeOptions options=new ChromeOptions();
  @Test
  public void signOn() throws InterruptedException {
	  Thread.sleep(4000);
	  
	  List<WebElement> linkElements=driver.findElements(By.tagName("a"));
	  int LinkCount=linkElements.size();
	  System.out.println("Total number of links available:" +LinkCount);
	  String[] links=new String[LinkCount];
	  System.out.println("List of links available: ");
	  //Print all the links
	  for(int i=0;i<LinkCount;i++)
	  {
		  links[i]=linkElements.get(i).getAttribute("href");
		  System.out.println(links[i]);
	  }
	  
	  //navigate to each link
	  for(int i=0;i<LinkCount;i++)
	  {
		  driver.navigate().to(links[i]);
		  System.out.println(driver.getTitle());
		  driver.navigate().back();
	  }
	  
		
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
		driver.navigate().to("https://www.google.co.in/");
  }

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }


}
