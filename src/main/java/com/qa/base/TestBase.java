package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static Properties prop;
	public Logger logger;
	
	 // Get driver
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    public TestBase()
	{
		
		try {
			prop=new Properties();
			
			FileInputStream ip=new FileInputStream("E:/Java Selenium/AutomationStore/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	

    @Parameters("browser")
    @BeforeMethod
    public void initialization(@Optional("chrome")String browser) {

    	logger=LogManager.getLogger(this.getClass());
    	
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());

        } else if (browser.equalsIgnoreCase("edge")) {
           // WebDriverManager.edgedriver().setup();
            try {
            	System.setProperty("webdriver.edge.driver","D:\\Selenium\\edgedriver_win64\\msedgedriver.exe");
                driver.set(new EdgeDriver());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //driver.set(new EdgeDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().get("https://automationteststore.com/");
    }
	
   // @AfterMethod
    public void tearDown() {

        if(getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

}