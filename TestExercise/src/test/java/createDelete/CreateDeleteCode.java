package createDelete;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.HomePage;


public class CreateDeleteCode {
	@Test
	public  void createDeleteCode() throws InterruptedException{
		
		   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		   
		  
		   WebDriver driver = new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		   driver.manage().window().maximize();
		   
		   
		   driver.get("http://hotel-test.equalexperts.io/");
		   
		   HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		   
		  // WebDriverWait wait = new WebDriverWait(driver, 60);
		   //wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));

		   //wait.until(ExpectedConditions.elementToBeClickable(HomePage.firstname));
		   
		   
		   //WebDriverWait wait = new WebDriverWait(driver, 60);
		  //wait.until(ExpectedConditions.visibilityOfAllElements(HomePage.firstnameCount()));
		   Thread.sleep(5000);
		   int a = HomePage.firstnameCount().size();
		   HomePage.createBooking();
		   System.out.println("booking created");
		   Thread.sleep(2000);
		   int e = HomePage.firstnameCount().size();
		   Assert.assertEquals(a+1, e); 
		   HomePage.deleteBooking();
		   System.out.println("booking deleted");
		   Thread.sleep(2000);
		   int deletecount = HomePage.firstnameCount().size();
		   Assert.assertEquals(a, deletecount);
		   
	
		   driver.close();
	}	
 
}
