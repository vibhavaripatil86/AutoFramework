package com.test.qa.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

// This is a test class which is used to test if the fuctionality is working fine
public class RunTest {
	
	public static void main(String[] args) {
		
	
//	WebDriver driver = new ChromeDriver();
	
	
	System.setProperty("webdriver.chrome.driver", "D:\\VibhaProject\\chrome\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
//System. setProperty("webdriver.chrome.driver", "path of the exe file\\chromedriver.exe");
	
	driver.get("http://blazedemo.com/");
	driver.manage().window().maximize();
	
	WebElement dropdownfrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
	
	WebElement dropdownto = driver.findElement(By.xpath("//select[@name='toPort']"));
	
	Select select1 = new Select(dropdownfrom);
	
	Select select2 = new Select(dropdownto);
	
	select1.selectByValue("Boston");
	select2.selectByIndex(3);
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	driver.findElement(By.xpath("//form[@name='VA43']//following::input[@type='submit'][2]")).click();
	
	WebElement dropdowncard = driver.findElement(By.xpath("//select[@name='cardType']"));


driver.findElement(By.xpath("//input[@placeholder='First Last']")).sendKeys("Vibhavari");

driver.findElement(By.xpath("//input[@placeholder='123 Main St.']")).sendKeys("viman nagar");

driver.findElement(By.xpath("//input[@placeholder='Anytown']")).sendKeys("Pune");

driver.findElement(By.xpath("//input[@placeholder='State']")).sendKeys("Maharashtra");

driver.findElement(By.xpath("//input[@placeholder='12345']")).sendKeys("411014");

	Select select3 = new Select(dropdowncard);
	
	select3.selectByIndex(1);
	
	driver.findElement(By.xpath("//input[@placeholder='Credit Card Number']")).sendKeys("1234567812345678");
	

	driver.findElement(By.xpath("//input[@placeholder='Month']")).sendKeys("09");
	
	
	driver.findElement(By.xpath("//input[@placeholder='Year']")).sendKeys("2020");
	
	driver.findElement(By.xpath("//input[@name='nameOnCard']")).sendKeys("VIBHAVARI PATIL");
	
	driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
	
	String ID = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText();
	
	Assert.assertTrue(ID.length()==13);
	
	driver.quit();
}

}
