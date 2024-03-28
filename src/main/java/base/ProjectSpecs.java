package base;
//Base Class for the project
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utility.Utilities;

public class ProjectSpecs extends Utilities {
	
	//Method call launch brower method in utility
	@Parameters({"browser", "url"})
	@BeforeMethod
	public void launchBrowser(String browser, String url) {
		
		browserLaunch(browser, url);
		
	}
	
	//Method to read Excel data
	@DataProvider(name = "readExcel")
	public String[][] getExceldata() throws IOException {
		String[][] data = readExcel(excelbook, excelsheet);
		return data;
	}
	
	

}
