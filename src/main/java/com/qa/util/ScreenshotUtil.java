package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
public static String captureScreenshot(WebDriver driver, String testName) {
        
        //String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        
        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        String path =
        		System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
        
        if(driver == null)
        {
            System.out.println("Driver is null");
            return null;
        }
        
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }


}
