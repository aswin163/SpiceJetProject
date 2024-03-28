package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecs;
import pages.HomePage;

public class TC002_LoginTest extends ProjectSpecs {
	
	@BeforeTest
	public void setup() {
		
		excelbook = "TestData";
		excelsheet = "LoginData";
		
	}


	@Test(dataProvider = "readExcel")
	public void LoginTest(String mailid, String pswd, String fname) {
		
		HomePage obj = new HomePage(driver);
		obj.login().email(mailid).password(pswd).submit(fname);

	}

}
