package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecs;
import pages.HomePage;

public class TC005_HomePageLinksValidation extends ProjectSpecs{
	
	@BeforeTest
	public void setup() {
		excelbook = "TestData";
		excelsheet = "HomePageLinks";
	}

	@Test(dataProvider = "readExcel")
	public void HomePageLinksValidation(String link, String expectedTitle) throws InterruptedException {
		
		HomePage obj = new HomePage(driver);
		obj.HomePageLinks(link, expectedTitle);

	}

}
