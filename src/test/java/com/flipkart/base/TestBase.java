package com.flipkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.flipkart.utilities.ExcelReader;

import io.github.bonigarcia.wdm.Config;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader("C:\\Users\\Lenovo\\eclipse-workspace\\LiveProject\\DataDrivenFramework\\src\\test\\resources\\excel\\testdata.xlsx");
	
	@BeforeSuite
	public void setUP() throws IOException {
		
	if(driver== null) {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Confiq.properties");
		config.load(fis);
	
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
	}
	
	if (config.getProperty("browser").equals("firefox")) {
		
		//System.setProperty("webdriver.geckodriver.driver", "C:\\Users\\Lenovo\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
	}else if(config.getProperty("browser").equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\LiveProject\\DataDrivenFramework\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}else if (config.getProperty("browser").equals("ie")) {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\LiveProject\\DataDrivenFramework\\src\\test\\resources\\executables\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	  driver.get(config.getProperty("testsiteurl"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	public boolean isElementPresent(By by) {
	
		try {
			
			driver.findElement(by);
			return true;
			
		} catch(NoSuchElementException e) {
			
			return false;
			
		}

	}
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
		driver.quit();
	}
	}
}
