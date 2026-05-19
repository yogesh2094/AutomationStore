package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.AccountsPage;
import com.qa.pages.AddressBookPage;
import com.qa.pages.ChangePasswordPage;
import com.qa.pages.CheckoutPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class CheckoutTest extends TestBase{
	
	LoginPage lpage;
	
	AccountsPage apage;
	
	ChangePasswordPage cppage;
	
	AddressBookPage abpage;
	HomePage hpage;
	CheckoutPage cpage;
	
	public CheckoutTest()
	{
		super();
	}
	
	 
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
	        hpage=new HomePage(getDriver());
	        cpage=new CheckoutPage(getDriver());
	    }
	 
	    @Test
	    public void validateTitleTest()
	    {
	    	String title=cpage.validatePageTitle();
	    	
	    	Assert.assertEquals(title, "Checkout Confirmation");
	    }

}
