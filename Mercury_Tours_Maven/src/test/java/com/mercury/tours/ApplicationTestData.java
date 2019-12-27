package com.mercury.tours;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;

public class ApplicationTestData {
	
	@DataProvider(name="Login")
	public Object[][] getDataForLogin(){
		
		return new Object[][]
				{
			{"testing","testing"},
			{"dixit","dixit"},
			{"testabhi","testabhi"}
				};			
	}
	
	//This is to read Excel Data
	
	@DataProvider(name="LoginDataXLS")
	public Object[][] ExcelXLS() throws Exception, IOException
	{
		ReadExcel_XLS_Example excel=new ReadExcel_XLS_Example();
		Object[][] testObjArray=excel.getExcelData("C:\\Selenium_Training\\workspace\\Mercury_Tours_Maven\\Mercury_Tours_Maven.xls", "Sign_On");
		System.out.println(testObjArray);
		return testObjArray;
	}
	@DataProvider(name="LoginDataXLSX")
	public Object[][] ExcelXLSX() throws Exception, IOException
	{
		ReadExcel_XLSX_Example2 excel=new ReadExcel_XLSX_Example2();
		Object[][] testObjArray=excel.getExcelData("C:\\Selenium_Training\\workspace\\Mercury_Tours_Maven\\Mercury_Tours_Maven.xlsx", "Sign_On");
		System.out.println(testObjArray);
		return testObjArray;
	}
	
	@DataProvider(name="LoginDataXLSAndXLSX")
	public Object[][] Excel_XLS_XLSX() throws Exception, IOException
	{
		ReadExcel_XLS_XLSX excel=new ReadExcel_XLS_XLSX();
		Object[][] testObjArray=excel.getExcelData("C:\\Selenium_Training\\workspace\\Mercury_Tours_Maven\\Mercury_Tours_Maven.xls", "Sign_On");
		System.out.println(testObjArray);
		return testObjArray;
	}
	
}
