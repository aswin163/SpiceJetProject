package pages;
// Payments page
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecs;

public class PaymentPage extends ProjectSpecs{
	
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Method to enter payment details in the payment page
	public PaymentPage carddetails(String CardNumber, String CardHolderName, String ExpMonth, String ExpYear, String Cvv) {
		
		// To enter card number
		WebDriverWait cardNumberFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
		cardNumberFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='card_number_iframe']")));
		WebDriverWait cardNumberWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		cardNumberWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='card_number']"))).sendKeys(CardNumber);
		driver.switchTo().defaultContent();
		
		// To enter card holder name
		WebDriverWait cardHolderFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
		cardHolderFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='name_on_card_iframe']")));
		WebDriverWait cardHolderNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		cardHolderNameWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name_on_card']"))).sendKeys(CardHolderName);
		driver.switchTo().defaultContent();
		
		//To enter expire month
		WebDriverWait monthFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
		monthFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='card_exp_month_iframe']")));
		WebDriverWait cardMonthWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		cardMonthWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='card_exp_month']"))).sendKeys(ExpMonth);
		driver.switchTo().defaultContent();
		
		//To enter expire year
		WebDriverWait yearFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
		yearFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='card_exp_year_iframe']")));
		WebDriverWait cardYearWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		cardYearWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='card_exp_year']"))).sendKeys(ExpYear);
		driver.switchTo().defaultContent();
		
		//To enter CVV nummber
		WebDriverWait cvvFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
		cvvFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='security_code_iframe']")));
		WebDriverWait cvvWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		cvvWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='security_code']"))).sendKeys(Cvv);
		driver.switchTo().defaultContent();
		
		
		// Since card details are dummy, proceed to payment is not possible. So finishing the execution till entering the card details
		
		// Assertion to check whether the page is correctly in the payment page
		String expectedText = "Trip Summary";
		String actualText = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-qsz3a2 r-2t9rge r-1x35g6 r-1kfrs79']")).getText();
		Assert.assertEquals(actualText, expectedText);
		
		return this;
	}

}
