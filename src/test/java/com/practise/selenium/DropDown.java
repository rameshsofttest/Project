package com.practise.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\LiveProject\\DataDrivenFramework\\src\\test\\resources\\executables\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.indianrail.gov.in/enquiry/StaticPages/StaticEnquiry.jsp?StaticPage=index.html&locale=en");
		driver.findElement(By.xpath("//a[text()='Fare Enquiry']")).click();
		WebElement classdb = driver.findElement(By.id("class"));
		Select sel = new Select(classdb);
		boolean b = sel.isMultiple();
		System.out.println(b);
		}
		
		
			}


