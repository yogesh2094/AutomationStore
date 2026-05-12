package com.qa.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir") + "/reports/ExtentReport.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName(" Automation Store Results");
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo(path, path);

        return extent;

}

}
