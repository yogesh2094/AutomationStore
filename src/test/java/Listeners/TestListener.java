package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.TestCases.TestBase;
import com.qa.util.ExtentManager;
import com.qa.util.ScreenshotUtil;

public class TestListener implements ITestListener{
	
	ExtentReports extent = ExtentManager.getReportObject();
	//ThreadLocal<ExtentTest> test;
	
	ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
//	@Override
//    public void onTestStart(ITestResult result) {
//        System.out.println("Test Started : " + result.getName());
//    }
    
   /* public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
    	
    	 test.fail(result.getThrowable());

    	    WebDriver driver = TestBase.getDriver();

    	    if(driver != null)
    	    {
    	        String path = ScreenshotUtil.captureScreenshot(driver, result.getName());

    	        System.out.println("Screenshot saved at: " + path);

    	        test.addScreenCaptureFromPath(path);
    	    }
    	    else
    	    {
    	        System.out.println("Driver is null. Screenshot not captured.");
    	    }
            }

    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
    */
	
	 @Override
	    public void onTestStart(ITestResult result) {

	        ExtentTest extentTest =
	                extent.createTest(result.getMethod().getMethodName());

	        test.set(extentTest);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {

	        test.get().pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {

	    	test.get().fail(result.getThrowable());

	    	 WebDriver driver = TestBase.getDriver();

	    	   	    	    if (driver != null) {

	    	        String path = ScreenshotUtil.captureScreenshot(
	    	                driver,
	    	                result.getMethod().getMethodName());

	    	        System.out.println("Screenshot saved at: " + path);

	    	        test.get().addScreenCaptureFromPath(path);

	    	    } else {

	    	        System.out.println("Driver is null. Screenshot not captured.");
	    	    }
	       	    }

	    @Override
	    public void onFinish(ITestContext context) {

	        extent.flush();
	    }
	
  

}
