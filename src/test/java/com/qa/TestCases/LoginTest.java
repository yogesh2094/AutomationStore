package com.qa.TestCases;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AccountsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.RegisterPage;

public class LoginTest extends TestBase {
	LoginPage lpage;
	HomePage hpage;
	
	LoginTest()
	{
		super();
	}
	
	@Test
	public void validateLoginTest()
	{
		logger.info("Started Validate Login Test");
        LoginPage lpage = new LoginPage(getDriver());
        
        
        logger.info("Entering the Username & Password");
        lpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
        logger.info("Login Successful");
        
        
		
	}

}
