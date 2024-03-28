package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.ProjectSpecs;

public class SignUpPage extends ProjectSpecs {
	
	@FindBy(id = "first_name")
	WebElement firstname;
	
	@FindBy(id = "last_name")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@class=' form-control']")
	WebElement mobilenumber;
	
	@FindBy(id = "email_id")
	WebElement emailid;
	
	@FindBy(id = "new-password")
	WebElement password;
	
	@FindBy(id = "c-password")
	WebElement confirmpassword;
	
	@FindBy(id = "defaultCheck1")
	WebElement checkbox;
	
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submit;
	
	@FindBy(xpath = "//select[@class='form-control form-select ']")
	WebElement selecttitle;
	
	@FindBy(xpath = "//select[@class='react-datepicker__month-select']")
	WebElement month;
	
	@FindBy(xpath = "//select[@class='react-datepicker__year-select']")
	WebElement year;
	
	//Constructor
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		windowhandle(1); // Changes the current window to the new window
		PageFactory.initElements(driver, this);
	}
	
	// Selects the title of the passenger
	public SignUpPage selectTitle(String title) {
		Select select = new Select(selecttitle);
		select.selectByVisibleText(title);
		return this;
	}
	
	//Enters the fist name and last name of the passenger
	public SignUpPage setname(String fname, String lname) {
		sendkeys(firstname, fname);
		sendkeys(lastname, lname);
		return this;
	}
	
	// Selects the date of birth of the passenger
	public SignUpPage dateofbirth(String birthdate, String birthmonth, String birthyear) {
		
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText(birthmonth);
		
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText(birthyear);
		
		WebElement date = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--"+birthdate+"']"));
		click(date);
		return this;
		
	}
	
	//Enters the phone number of the passenger
	public SignUpPage phonenumber(String pnumber) {
		
		sendkeys(mobilenumber, pnumber);
		return this;
		
	}
	
	//Enters the email ID of the passenger
	public SignUpPage email(String mailid) {
		sendkeys(emailid, mailid);
		return this;
	}
	
	// Enters the password and re-enters it again in re-enter field
	public SignUpPage password(String passwrd) {
		sendkeys(password, passwrd);
		sendkeys(confirmpassword, passwrd);
		
		// Page doesn't work properly, so finishing execution upto this point
		
		//Assertion to check the current page is signup page
		String expectedText ="Member Enrollment";
		String actualText = driver.findElement(By.xpath("//h1[@class='title-black mb-2']")).getText();
		Assert.assertEquals(actualText, expectedText);
		
		return this;
		
	}
	
//	commenting below code since the signup page doesn't work properly, below code is to submit the details in signup page
//	public SignUpPage submit() {
//		click(checkbox);
//		click(submit);
//		return this;
//	}
	


}
