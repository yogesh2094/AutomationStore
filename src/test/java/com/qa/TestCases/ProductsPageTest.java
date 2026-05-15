package com.qa.TestCases;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.AccountsPage;
import com.qa.pages.AddressBookPage;
import com.qa.pages.ChangePasswordPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;

public class ProductsPageTest extends TestBase{

	LoginPage lpage;
	
	AccountsPage apage;
	
	ChangePasswordPage cppage;
	
	AddressBookPage abpage;
	HomePage hpage;
	ProductsPage ppage;
	
	ProductsPageTest()
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
	        hpage=new HomePage(getDriver());
	        ppage=new ProductsPage(getDriver());
	    }
	 
	 @Test
	 public void validateProductPageTitleTest()
	 {
		 logger.info("Validate Product Page Title Test Case Started");
		 
		 String title=ppage.validateProductPageTitle();
		 assertEquals(title, "Men","Title is not Matching !!");
		 
		 logger.info("Validate Product Page Title Test Case Completed");
	 }
	 
	 @Test
	 public void validateSortByDropTest()
	 {
		 logger.info("Validate Product Page Sort By Drop Down Test Case Started");
		 
		 ppage.validateProductPageTitle();
		 
		 List<String> expectedValues=Arrays.asList("Name A - Z","Name Z - A","Price Low > High","Price High > Low","Rating Highest","Rating Lowest","Date New > Old","Date Old > New");
		 
		 List<String> actualValues=ppage.getSortByDropdownValues();
		 
		 Assert.assertEquals(actualValues, expectedValues, "Sort By Drop Down Values not Matching !!");
	 }
	 
	 @Test
	 public void navigatetoProductPage()
	 {
		 logger.info("Navigate to Product Page Test Case Started");
		 ppage.validateProductPageTitle();
		 
		 String title=ppage.getProductDetailsPage();
		 
		 Assert.assertEquals(title, "Pour Homme Eau de Toilette", "Title not Matching !!");
		 
		 logger.info("Navigate to Product Page Test Case Completed");
	 }
	 
	 
}
