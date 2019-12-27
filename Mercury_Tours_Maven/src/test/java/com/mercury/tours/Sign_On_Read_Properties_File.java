package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Sign_On_Read_Properties_File extends ApplicationTestData {
	
	 ChromeDriver driver;
	// String PropertyFileRelativePath= System.getProperty("user.dir");
	 //String PropertyFilePath=PropertyFileRelativePath+"\\mercury_tours.properties";
	 File file=new File("C:\\Selenium_Training\\workspace\\Mercury_Tours_Maven\\mercury_tours.properties");
	 Properties prop=new Properties();

	 //prop.load(fileInput);
	 
	  @Test(dataProvider="Login")
	  public void signOn(String Uname,String StrPwd) throws InterruptedException, IOException {
		  
		  FileInputStream fileInput=new FileInputStream(file);
		  prop.load(fileInput);
		  driver.findElement(By.linkText(prop.getProperty("lsignon"))).click();
			driver.findElement(By.name(prop.getProperty("Iusername"))).sendKeys(Uname);
			driver.findElement(By.name(prop.getProperty("Iuserpass"))).sendKeys(StrPwd);
			driver.findElement(By.name("login")).click();
			Thread.sleep(6000);
			driver.findElement(By.linkText("SIGN-OFF")).click();
			Thread.sleep(6000);
	  }
	  @BeforeTest
	  public void launchBrowser() throws IOException {
		  FileInputStream fileInput=new FileInputStream(file);
		  prop.load(fileInput);
		  String absolutePath= System.getProperty("user.dir");
			//String filePath=absolutePath+"\\chromedriver.exe";
			String filePath=absolutePath+"\\Drivers"+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",filePath);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("URL"));
	  }

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }

}
