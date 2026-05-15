package com.qa.TestCases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.AccountsPage;
import com.qa.pages.ChangePasswordPage;
import com.qa.pages.LoginPage;

public class ChangePassTest extends TestBase {

	LoginPage lpage;
	
	AccountsPage apage;
	
	ChangePasswordPage cppage;
	
	ChangePassTest()
	{
		super();
	}
	
	 @BeforeMethod
	    public void setup() {

	        // ❌ DO NOT call initialization() here
	        // It is already called from TestBase

	        lpage = new LoginPage(getDriver());

	       apage = lpage.validateLogin(
	                prop.getProperty("username"),
	                prop.getProperty("password")
	        );

	        apage = new AccountsPage(getDriver());
	        cppage=new ChangePasswordPage(getDriver());
	    }

	 @Test
	 public void validateTitleTest()
	 {
		 logger.info("Change Password Page Title Test Executed");
		 String title=cppage.validatePageTitle();
		 Assert.assertEquals(title, "Change Password");
		 
		 logger.info("Change Password Page Title Test Passed");
	 }
	 
	 @Test
	 public void validatePassFieldsTest()
	 {
		 logger.info("Change Password fields validation Test Executed");
		 List<String> expectedFields=Arrays.asList("Current Password:","New Password:","New Password Confirm:");
		 
		 List<String> actualFields=cppage.validateChangePassFields();
		 
		 Assert.assertEquals(actualFields, expectedFields,"Fields are not Matching !!");
		 
		 logger.info("Change Password fields validation Test Passed");
	 }

	 @Test
	 public void validateChangePassFuncTest()
	 {
		 logger.info("Change Password functionality validation Test Executed");
		 
		 String successMsg=cppage.changePasswordfunc();
		 
		 Assert.assertEquals(successMsg, "× Success: Your password has been successfully updated.");
		 
		 logger.info("Change Password functionality validation Test Passed");
		 
	 }
}
