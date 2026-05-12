package com.qa.TestCases;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AccountsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class AccountTest extends TestBase{
	
	LoginPage lpage;
	
	AccountsPage apage;
	
	AccountTest()
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
	    }

	 //@Test
	 public void validateTitleTest()
	 {
		 logger.info("Title Test Executed");
		 
		 String title=apage.validatePageTitle();
		 
		 Assert.assertEquals(title, "My Account");
		 
		 logger.info("Title Test Completed");
	 }
	 
	 @Test
	 public void validateAccountNameTest()
	 {
		 logger.info("Test Case -- validateAccountNameTest is Executed ");
		 
		 List<String> expectedLinks=Arrays.asList("Edit account details","Change password","Manage Address Book",
				 "My wish list","Order history",
		 		"Transaction history",
		 		"Downloads",
		 		"Notifications",
		 		"Logoff");
		 
		 List<String> actualLinks=apage.validateIconList();
		 
		 Assert.assertEquals(actualLinks, expectedLinks,
                "Link names are not matching!");
	 }
	 
	 @Test
	 public void validateAccountDetailsTest()
	 {
		 logger.info("Account Details Test Executed");
		 
		 List<String> expectedFields=Arrays.asList("Login Name:","First Name:","Last Name:","E-Mail:","Telephone:","Fax:");
		 
		 List<String> actualfields=apage.validateAccountDetails();
		 
		 Assert.assertEquals(actualfields, expectedFields, "Fields are not matching!");
	 }
	
	@Test
	public void validateAccountFieldValues()
	{
		logger.info("Test Case Account Details Field Values Started");
		
		Map<String, String> expectedValues=new LinkedHashMap<>();
		
		expectedValues.put("First Name", "Yogesh");
		expectedValues.put("Last Name", "Sarode");
		expectedValues.put("Email", "sa1@gmail.com");
		expectedValues.put("Telephone", "8.987876751E9");
		expectedValues.put("Fax", "");
		
		Map<String, String> actualValues=apage.validateAccountdetailsFieldsValues();
		
		Assert.assertEquals(actualValues, expectedValues, "Fields Values are Not Matching !!");
		
		logger.info("Test Case Account Details Field Values Passed");
	}
	

}
