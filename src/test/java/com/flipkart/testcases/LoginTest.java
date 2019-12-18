package com.flipkart.testcases;

import org.omg.CORBA.ExceptionList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;

public class LoginTest extends TestBase {
	
	@Test (dataProvider = "getData")
	public void loginPage(String username, String password) {

		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		//Assert.assertTrue(isElementPresent(By.xpath("//a[text()='Login & Signup']")));
		driver.findElement(By.xpath("//a[text()='Login & Signup']")).click();
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys(username);
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("loginbtn"))).click();
	
		
		}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "LoginTest";
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int rowNum = 2; rowNum<=rows; rowNum++) {
			
		for(int colNum=0; colNum < cols; colNum++) {
			
			data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
		}
		}
		return data; 
	}

}
