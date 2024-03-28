package utility;
//Extent Report 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSpiceJet {
	
	//Method to create extent report
	public static ExtentReports getReport() {
		
		String path = "E:\\JAT-Guvi\\SpiceJetCapstoneProject\\Reports\\SpiceJetReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("SpiceJet Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;

		}

}
