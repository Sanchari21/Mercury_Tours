package com.mercury.tours;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class LoginPage_ExtentReport extends ApplicationTestData {
	
	/*ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	//String ScreenshotFilepath="C:\\Selenium_Training\\workspace\\Mercury_Tours_Maven\\Screenshot";
 ChromeDriver driver;
  @Test(priority=2)
  public void signOn() throws InterruptedException {
	  
	  test=extent.createTest("Test Case2", "Login to Mercury Web Application");
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("Testing");
		driver.findElement(By.name("password")).sendKeys("Testing");
		driver.findElement(By.name("logins")).click();
		
  }
  @Test(priority=1)
  public void launchBrowser() {
	  
	  test=extent.createTest("Test Case1", "Launch browser and navigate to chrome driver");
	  String absolutePath= System.getProperty("user.dir");
		//String filePath=absolutePath+"\\chromedriver.exe";
		String filePath=absolutePath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filePath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
  }
  
  @BeforeTest()
  public void startReport()
  {
	  //initialize HTML reporter
	  htmlReporter=new ExtentHtmlReporter("C:\\Selenium_Training\\workspace\\Mercury_Tours_Maven\\test-output\\TestReport.html");
	  extent=new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	  extent.setSystemInfo("OS", "Window10");
	  extent.setSystemInfo("Browser", "Firefox 60+");
	 // htmlReporter.config().setChartVisibilityOnOpen(true);
	  htmlReporter.config().setDocumentTitle("Extent Report Demo");
	  htmlReporter.config().setReportName("Test Report");
	  htmlReporter.config().setTheme(Theme.STANDARD);
	  htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy, hh:mm a'('zzz')");
	  
  }
  @AfterMethod
  public void getResult(ITestResult result)
  {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
		 test.fail(result.getThrowable());
	  }
	  else if(result.getStatus()==ITestResult.SUCCESS)
	  {
		  test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
	  }
	  else
	  {
		  test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
		 test.skip(result.getThrowable());
	  }
  }

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
	  extent.flush();
  }*/

}
