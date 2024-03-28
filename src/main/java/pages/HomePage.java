package pages;
//HoomePage of the website
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecs;

public class HomePage extends  ProjectSpecs{
	
	@FindBy(xpath = "//div[text()='Signup']")
	WebElement signup;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement login;
	
	@FindBy(xpath = "//div[text()='one way']")
	WebElement onewaytrip;
	
	@FindBy(xpath = "//div[text()='round trip']")
	WebElement roundtrip;
	
	@FindBy(xpath = "(//input[contains(@type,'text')])[1]")
	WebElement origination;
	
	@FindBy(xpath = "(//input[contains(@type,'text')])[2]")
	WebElement destination;
	
	@FindBy(xpath = "(//div[contains(.,'Search Flight')])[9]")
	WebElement searchflight;
	
	//Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Method for signup page
	public SignUpPage signup() {
		click(signup);   // Clicks signup button
		return new SignUpPage(driver);
		
	}
	
	//Method for login page
	public LoginPage login() {
		click(login); // Clicks login button
		return new LoginPage(driver);
	}
	
	
	//Method to verify the links in homepage
	public void HomePageLinks(String link, String expectedTitle) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[text()='"+link+"']"));
		element.click();
		Thread.sleep(5000);
		String actual = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-qsz3a2 r-2t9rge r-adyw6z r-1kfrs79']")).getText();
		Assert.assertEquals(actual, expectedTitle);
		
	}
	
	//Method to select the date while searching for one way and round trip
	 public void selectRequiredDate(String month,String date) throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> departMonths = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")));
			// This is for selecting the Depart date from months
			// Instance to increment and count of the date occurrence of every month
			int i = 1;

			for (WebElement departMonth : departMonths) {

				String monthStr = departMonth.getText();
				//System.out.println("Depart Month is :"+monthStr);
				if (month.equals(monthStr)) {
					break;
				} else {
					// Clicking next arrow click
					driver.findElement(By.xpath(
							"//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[1]"))
							.click();
					i++;
				}
			}
			// Clicking the Depart date of the given month
			driver.findElement(By.xpath("(//div[text()='" + date + "'])[" + i + "]")).click();	        }

	    
	
	 //Method for one way trip
	public HomePage oneWayTrip(String from, String to, String date, String month) throws InterruptedException {
		sendkeys(origination, from);  //Clicks origination field and enters the origination city
		sendkeys(destination, to);   //Clicks destination field and enters the origination city
		selectRequiredDate(month, date);  // Calls the method to select the required date
		Thread.sleep(3000);
		click(searchflight);  // clicks search flight button
		return this;
	}
	
	// Method to choose flight from available options
	public HomePage selectflight() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement earlyFlight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"list-results-section-0\"]/div[5]/div[1]/div/div[2]/div[1]/div/div/div/div[2]")));
		Actions action = new Actions(driver);
		action.moveToElement(earlyFlight).click().perform();  // Selects and clicks the earliest available flight
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement continueClick = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79']")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(continueClick).click().perform(); //clicks continue button after selecting flight
		return this;
	}
	
	
	//Method to enter passenger details
	public HomePage passengerdetails(String FirstName, String LastName, String ContactNumber, String EmailID, String City) {
		
		//Entering the firstname of the passenger
		WebDriverWait firstNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement firstNameEle = firstNameWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[1]")));
		firstNameEle.sendKeys(FirstName);
		
		//Entering the lastName of the passenger
		WebDriverWait lastNameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement lastNameEle = lastNameWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"primary-contact-details\"]/div[3]/div[3]/div/div/div[2]/input")));
		lastNameEle.sendKeys(LastName);
		
		//Entering the contact number of the passenger
		WebDriverWait contactNoWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement contactNoEle = contactNoWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='css-1cwyjr8 r-1yadl64 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[1]")));
		contactNoEle.sendKeys(ContactNumber);

		//Entering the email address of the passenger
		WebDriverWait emailIDWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement emailIDEle = emailIDWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[3]")));
		emailIDEle.sendKeys(EmailID);
		
		//Entering the city of the passenger
		WebDriverWait cityWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cityEle = cityWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"primary-contact-details\"]/div[4]/div[3]/div/div/div[2]/input")));
		cityEle.sendKeys(City);	
		
		// Clicks the "I am flying as the primary passenger" check box
		WebDriverWait checkBoxWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement checkBoxEle = checkBoxWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[5]")));
		checkBoxEle.click();
		
		//Clicks continue button after filling passenger details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement continueClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-poiln3 r-adyw6z r-1kfrs79']")));
		Actions action = new Actions(driver);
		action.moveToElement(continueClick).click().perform();

		
		//The next page asks for add ons and it displays a pop up. Below clicks the pop up
		try {
			WebElement popUp = driver.findElement(By.xpath("//div[@class='at_addon_close']"));
			
			if(popUp.isDisplayed()) {
				System.out.println("Add-on pop up is present");
				popUp.click();
			}

		}catch(Exception e) {
			System.out.println("Add-on pop up is not present");
		}
		
		// Clicks Continue button in Add ons page
		WebDriverWait addonwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement continueclick = addonwait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='css-76zvg2 r-jwli3a r-poiln3 r-adyw6z r-1kfrs79'])[3]")));
		Actions addonaction = new Actions(driver);
		addonaction.moveToElement(continueclick).click().perform();
		
		
		//A pop is displayed after clicking continue asking to choose comfort, below clicks the Skip Comfort in the pop up
		WebDriverWait skipwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement skipComfortClick = skipwait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@id='skipfrompopup'])[1]")));
		Actions skipaction = new Actions(driver);
		skipaction.moveToElement(skipComfortClick).click().perform();

		
		return this;
	}
	
	
	//Method for Round Trip
	public HomePage roudtrip(String from, String to, String depmonth, String depdate, String returnmonth, String returndate) throws InterruptedException {
		click(roundtrip); //Clicks the Round Trip radio button
		sendkeys(origination, from); //Clicks origination field and enters the origination city
		sendkeys(destination, to);  //Clicks destination field and enters the origination city
		selectRequiredDate(depmonth, depdate);  // Calls the method to select the departure date
		selectRequiredDate(returnmonth, returndate);  // Calls the method to select the return date
		click(searchflight);  // Clicks search flight button
		return this; 
	}
	
	//Method for payment page
	public PaymentPage cardDetails() {
		return new PaymentPage(driver);
	}
	

}
