package utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class Utilities {
	
	public static WebDriver driver;
	public String excelbook;
	public String excelsheet;
	
	
	//Method to launch browser and open the URL
	public void browserLaunch(String browser, String url) {
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if (browser.equals("safari")) {
			driver = new SafariDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.navigate().to(url); //Opens the url
		driver.manage().window().maximize(); //Maximizes the browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Adds implicit wait
	}
	
	//Common method to perform click operation on a web element
	public void click(WebElement element) {
		element.click();
	}
	
	
	//Method to handle windows(Tabs)
	public void windowhandle(int index) {
		Set<String> windows = driver.getWindowHandles();  // Gets the set of all tabs that are opened
		List<String> tabs = new ArrayList<String>(windows);  // Storing it in list so that tabs will be stored in ascending order
		driver.switchTo().window(tabs.get(index));  // Switches to desired window
	}
	
	
	//Common method to enter values in a webelement
	public void sendkeys(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	
	
	//Method to read data from excel sheet
	public String[][] readExcel(String excelFile, String  excelSheet) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("E:\\JAT-Guvi\\SpiceJetCapstoneProject\\src\\test\\resources\\"+excelFile+".xlsx");  // Excelfile name will be passed from Testcase as it may differ for each test case
		XSSFSheet sheet = book.getSheet(excelSheet); // Sheet number which needs to be read is also passed from testcase as it may differ for each test case
		 
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowcount][columncount];
		
		for(int i=1; i<=rowcount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0; j<columncount; j++) {
				
				XSSFCell cell = row.getCell(j);
				
				data[i-1][j] = cell.getStringCellValue();
			}
		}
		book.close();
		return data;
	}
	
	//Method to take screenshot
	public String getScreenshot(String test) throws IOException {
		
		int ranNum = (int) (Math.random() * 9999999 + 1000000);
		
		String path = "E:\\JAT-Guvi\\SpiceJetCapstoneProject\\ScreenShot\\"+test+ranNum+".png";
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(source, dest);
		
		return path;
	}
		
		//Method that closes the browser
		public void closeBrowser() {
			driver.close();
		}


}
