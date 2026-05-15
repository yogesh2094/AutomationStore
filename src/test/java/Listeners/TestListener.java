package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.TestCases.TestBase;
import com.qa.util.ExtentManager;
import com.qa.util.ScreenshotUtil;

public class TestListener implements ITestListener{
	
	ExtentReports extent = ExtentManager.getReportObject();
    ExtentTest test;
    
//	@Override
//    public void onTestStart(ITestResult result) {
//        System.out.println("Test Started : " + result.getName());
//    }
    
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        
        String path = ScreenshotUtil.captureScreenshot(
                TestBase.getDriver(),
                result.getName());

        System.out.println("Screenshot saved at: " + path);
        
        test.addScreenCaptureFromPath(path);
    }

    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
  

}
