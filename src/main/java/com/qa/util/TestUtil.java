package com.qa.util;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	
	WebDriver driver;
	
	// Constructor
    public TestUtil(WebDriver driver) {

        this.driver = driver;
    }

    
    
	public void switchToChildWindow(String parentId) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windowIds = driver.getWindowHandles();

        for (String window : windowIds) {

            if (!window.equals(parentId)) {

                driver.switchTo().window(window);
                break;
            }

}
	}
}

