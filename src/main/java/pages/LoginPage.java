package pages;
// Login page
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecs;

public class LoginPage extends ProjectSpecs {
	
	@FindBy(xpath = "(//div[text()='Email'])[1]")
	WebElement radiooption;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement passsword;
	
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement loginbutton;
	
	//Constructor
	public LoginPage(WebDriver Driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		click(radiooption); //Clicking the Email Radio button in the login pop up page
	}
	
	public LoginPage email(String mailid) {
		sendkeys(email, mailid);  // Enters the user email address
		return this;
		
	}
	
	public LoginPage password(String pswd) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(passsword));
		sendkeys(passsword, pswd);  // Enters user password
		return this;
		
	}
	
	public void submit(String fname) {
		click(loginbutton);  // Clicks submit button
		
		// Assertion to check whether the login happened successfully
		String expected = "Hi " +fname+"";
		String actual = driver.findElement(By.xpath("//div[text()='Hi "+fname+"']")).getText();
		Assert.assertEquals(actual, expected);
		
	}

}
