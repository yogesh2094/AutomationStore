package com.qa.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	WebDriver driver;
	
	public WaitUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	public void elementToBeClickable(WebElement element, int timeouts)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void visibilityOfAllElements(List<WebElement> elements, int timeouts)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitforElementVisible(WebElement element, int timeouts)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
