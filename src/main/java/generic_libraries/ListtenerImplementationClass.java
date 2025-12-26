package generic_libraries;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListtenerImplementationClass implements 	ITestListener ,ISuiteListener{   //ITestListener is from -org.testng
	ExtentReports report;
	ExtentTest test;
	
	public static ThreadLocal<ExtentTest> extentTest = new  ThreadLocal<ExtentTest>();  //for parallel and cross browser exceution//extent methods
	//ThreadLocal  --ONly for PARALLEL excution, everything is stored , stores new adress also
	//we want adress of both old and new class also, in on memory , (map conecpt),key(thread ID) and value(webdrive Id)
	//key- thread, value-specfic object
	
	//right click --.soucre-->select which methods we need
	
//	@Override
//	public void onStart(ITestContext context) {
//ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\report\\"+new JavaUtils().sysDate()+".html");
//
//htmlreport.config().setDocumentTitle("TP-30");
//htmlreport.config().setTheme(Theme.DARK);  //DARK is just color visulation
//htmlreport.config().setReportName("VTiger");
//
//
//
// report = new ExtentReports();
//report.attachReporter(htmlreport);
//report.setSystemInfo("base_browser", "chrome");
//report.setSystemInfo("base_platform", "windows");
//report.setSystemInfo("base_url", "http://localhost:8888");
//report.setSystemInfo("RepoterName", "Anitha A H");
//
//	}

	
	@Override
	public void onStart(ISuite suite) {
//ExtentSparkReporter - To configufe UI 
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\report\\"+new JavaUtils().sysDate()+".html");  //to get html path report

		htmlreport.config().setDocumentTitle("TP-30");
		htmlreport.config().setTheme(Theme.DARK);  //DARK is just color visulation
		htmlreport.config().setReportName("VTiger");


		//ExtentReports()            // for providing content for extent reports
		 report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base_browser", "chrome");//collection--// MAP concept is used 
		report.setSystemInfo("base_platform", "windows");
		report.setSystemInfo("base_url", "http://localhost:8888");
		report.setSystemInfo("RepoterName", "Anitha A H");

	
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);      //to get            
		
		extentTest.set(test);
		extentTest.get().log(Status.INFO, methodName+"----------->Execution starts");  //extentTest is for extent method
		
	//	public static ThreadLocal<WebDriver> extentTest = new  ThreadLocal<WebDriver>(); //its in base calss	
		//get method()-->from this we can exttrcat web driver and extent dricer
		//replcae test varibale with extent -->for parallel and cross Browser exceution
	}

	

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		extentTest.get().log(Status.PASS, methodName+"<b>--------->Passed</b>"); //for BOLD format
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
//		String methodName = new JavaUtils().systemdate(); //to genreate random method name
		
//		String methodName = result.getMethod().getMethodName();
//		String fileName = methodName+new JavaUtils().systemdate();
		
	
//		//TakesScreenshot ts = (TakesScreenshot) driver;
//		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
//
//		//sdriver--static driver to take SS//by taking SS , we need to take new session, the same driver wil ont work, create new driver for new session ID //do chnage in Baseclass 
//		
//		File src = ts.getScreenshotAs(OutputType.FILE);
//	    File dst = new File(".\\screen_shot\\"+methodName+".html");
//	
//	    try {
//			FileUtils.copyFile(src, dst);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//   
		
	    try {
	    	String methodName = result.getMethod().getMethodName();
			String fileName = methodName+new JavaUtils().sysDate();
			
			String filepath = ".\\screen_shot\\"+fileName+".png";
			
	    	TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
	    	
	    	File src = ts.getScreenshotAs(OutputType.FILE);
		    File dst = new File(filepath);
		    
		    FileUtils.copyFile(src, dst);
		    String path = dst.getAbsolutePath();
		    extentTest.get().addScreenCaptureFromPath(path); //method to attach failed Screenshot into extent report
		    
		    extentTest.get().log(Status.FAIL, result.getThrowable());  //getThrowable - for exception
		    extentTest.get().log(Status.FAIL, methodName+"<i>----> failed<i>");  //<i></i> for italic format
		    
		    // extentTest.get().log -->to print in msg in Extent report
		    //                 .log--> to print msg in TestNg report
		    
	    } catch(IOException e) 
	      {
	    	e.printStackTrace();
	      } 
	    
	  //-->
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
//		String methodName = result.getMethod().getMethodName();
//		extentTest.get().log(Status.ExtentReports();// for providing content for extent reportsSKIP, methodName+"-->skipped");
		
		String testName = result.getTestClass().getName();
		if (result.wasRetried()) {
			extentTest.get().log(Status.WARNING, "<b>"+testName+" failed, but Retrying... (Attempt " +
					((IRetryImpClass)result.getMethod().getRetryAnalyzer(result)).count + ")</b>");
		} else {
			extentTest.get().log(Status.SKIP, "<b>"+testName+" has been Skipped</b>");
		}    
	
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	
	}
	

//	@Override
//	public void onFinish(ITestContext context) {
//report.flush();
//	}

	
}
//syso-output prints in concole
//reporter.log--output prints in - TestNg((pass one string var)no, pass , no fail)-var prints in TestNg report
//test.log- 
//method contains Test -->belongs to Test script  --.reult
//method //onStrat//onFinish// to configure the report