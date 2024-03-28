package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecs;
import pages.HomePage;

public class TC003_OneWayTripTest extends ProjectSpecs {

	@Test
	public void OneWayTripTest() throws InterruptedException {

		HomePage obj = new HomePage(driver);
		obj.oneWayTrip("MAA", "DEL", "4", "April 2024").selectflight().passengerdetails("Aswin", "Kumar","7010778832" , "test@guvi.com", "Chennai")
		.cardDetails().carddetails("2121313141415151", "Aswin Kumar", "12", "27", "971");

	}

}
