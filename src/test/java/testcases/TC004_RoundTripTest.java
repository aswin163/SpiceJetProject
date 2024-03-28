package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecs;
import pages.HomePage;

public class TC004_RoundTripTest extends ProjectSpecs{
	
	
	@Test
	public void RoundTripTest() throws InterruptedException {
		
		HomePage obj = new HomePage(driver);
		obj.roudtrip("MAA", "DEL", "April 2024", "4", "April 2024", "6").selectflight().passengerdetails("Aswin", "Kumar","7010778832" , "test@guvi.com", "Chennai")
		.cardDetails().carddetails("2121313141415151", "Aswin Kumar", "12", "27", "971");
		
	}

}
