package Demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Demo1 {
	WebDriver driver;
	@BeforeTest
	public void bt() 
	{
		  System.setProperty("webdriver.chrome.driver", "/Users/vishnu.raju/Desktop/Chrome_Driverforselenuim/chromedriver 3");
	        driver = new ChromeDriver();
	       //this is to maximize the browser
	        driver.manage().window().maximize();
	        //i want to open any URL
	        driver.get("https://opensource-demo.orangehrmlive.com");
	        String title = driver.getTitle();
	        AssertJUnit.assertEquals(title, "OrangeHRM");
	}
	
	
	@AfterTest
	public void at() {
		driver.close();
	}
	
	@Test
	public void t() throws InterruptedException,IOException {
		
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='Submit' or @id='btnLogin']")).click();
		 driver.findElement(By.id("welcome")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
	}

}
