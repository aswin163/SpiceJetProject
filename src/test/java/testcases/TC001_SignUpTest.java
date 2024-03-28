package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecs;
import pages.HomePage;

public class TC001_SignUpTest extends ProjectSpecs {
	
	@BeforeTest
	public void setup() {
		
		excelbook = "TestData";
		excelsheet = "SignUpData";
		
	}

	
	@Test(dataProvider = "readExcel")
	public void SignUpTest(String title, String fname, String lname, String date, String month, String year, String phone, String mail, String password ) {
		
		HomePage obj = new HomePage(driver);
		obj.signup().selectTitle(title).setname(fname, lname).phonenumber(phone).email(mail).password(password);
	}

}
