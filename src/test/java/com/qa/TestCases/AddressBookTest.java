package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.AccountsPage;
import com.qa.pages.AddressBookPage;
import com.qa.pages.ChangePasswordPage;
import com.qa.pages.LoginPage;

public class AddressBookTest extends TestBase{

LoginPage lpage;
	
	AccountsPage apage;
	
	ChangePasswordPage cppage;
	
	AddressBookPage abpage;
	
	AddressBookTest()
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
	        abpage=new AddressBookPage(getDriver());
	    }

	 
	 @Test
	 public void validateAddressBookPageTitleTest()
	 {
		 logger.info("Address Book  Page Title Test Executed");
		 String title=abpage.validateAddressBookPageTitle();
		 
		 Assert.assertEquals(title, "Address Book");
		 logger.info("Address Book  Page Title Test Passed");
		 
	 }
	 
	 @Test
	 public void validateAddressBookEntriesTest()
	 {
		 logger.info("Address Book  Entries  Test Executed");
		 
		String actualEntry= abpage.validateAddressBookEntries();
		
		Assert.assertEquals(actualEntry, "Yogesh Sarode testsg Airoli 400708.0 Bristol United Kingdom");
				
	 }
		 
	 
}
