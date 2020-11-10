package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
	
		}
	@FindBy(how=How.ID,using="firstname")
	public
	WebElement  firstname;
	@FindBy(how=How.ID,using="lastname") WebElement lastname;
	@FindBy(how=How.ID,using="totalprice") WebElement Price;
	@FindBy(how=How.ID,using="depositpaid") WebElement DepositDropdown;	
	@FindBy(how=How.ID,using="checkin") WebElement checkinCalendar;
	@FindBy(how=How.LINK_TEXT,using="12") WebElement checkinDate;
	@FindBy(how=How.ID,using="checkout") WebElement checkoutCalendar;
	@FindBy(how=How.LINK_TEXT,using="14") WebElement checkoutDate;
	@FindBy(how=How.CSS,using="input[value=' Save ']") WebElement SaveBtn;
	@FindBy(how=How.CSS,using="div#bookings > div:nth-of-type(2)  input[value='Delete']") WebElement DeleteBtn;
	
	public void createBooking() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",firstname );	
		firstname.sendKeys("Test");
		lastname.sendKeys("Test");
		Price.sendKeys("10000");
		Select drpDeposit = new Select(DepositDropdown);
		drpDeposit.selectByVisibleText("false");
		checkinCalendar.click();
		checkinDate.click();
		checkoutCalendar.click();
		checkoutDate.click();
	    SaveBtn.click();
	    //System.out.println("New Booking created Successfully.");
	}
	
	public void deleteBooking() {
		DeleteBtn.click();
		System.out.println("Booking deleted Successfully.");
	}
	
	
	
	public List<WebElement> firstnameCount() {
	   
		List<WebElement> firstnameCount =   driver.findElements(By.className("row"));
		
		return firstnameCount;
	}
}
	
