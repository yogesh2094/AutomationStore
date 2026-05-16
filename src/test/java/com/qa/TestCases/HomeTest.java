package com.qa.TestCases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.pages.AccountsPage;
import com.qa.pages.AddressBookPage;
import com.qa.pages.ChangePasswordPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import Listeners.TestListener;

@Listeners(TestListener.class)

public class HomeTest extends TestBase {

	LoginPage lpage;
	
	AccountsPage apage;
	
	ChangePasswordPage cppage;
	
	AddressBookPage abpage;
	HomePage hpage;
	
	HomeTest()
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
	    }
	 
	 @Test(groups= {"smoke"})
	 public void validateLogoTest()
	 {
		 logger.info("Validate Logo Test Started");

		    boolean flag = hpage.validateLogo();

		    Assert.assertTrue(flag, "Logo is not displayed");
		    
		    logger.info("Validate Logo Test Completed");
	 }
	 
	 @Test(groups= {"smoke"})
	 public void validateMenuListTest()
	 {
		 logger.info("Validate WelCome MenuTest Started");
		 List<String> expectedLinks=Arrays.asList("Account Dashboard", "My wish list","Edit account details","Change password","Manage Address Book","Order history",
			 		"Transaction history",
			 		"Downloads",
			 		"Notifications",
			 		"Not Yogesh? Logoff");
		 
		 List<String> actualLinks=hpage.validateWelcomeMenuList();
		 
		 Assert.assertEquals(actualLinks, expectedLinks, "Menu List not Matching");
		 
		 logger.info("Validate WelCome MenuTest Completed");
	 }
	 
	 @Test(groups= {"smoke"})
	 public void validateHeaderMenuTest()
	 {
		 logger.info("Validate Header MenuTest Started");
		 List<String> expectedMenu=Arrays.asList("SPECIALS","ACCOUNT","CART","CHECKOUT");
		 
		 List<String> actualMenu=hpage.validateHeaderMenu();
		 
		 Assert.assertEquals(actualMenu, expectedMenu,"Header Menu Links Not Matching !!");
		 
		 logger.info("Validate Header MenuTest Completed");
	 }
	 
	 @Test
	 public void validateSearchBarCatTest()
	 {
		 logger.info("Validate Search Bar Categories Test Started");
		 
		 List<String> expectedCat=Arrays.asList("All Categories","Apparel & accessories","Makeup","Skincare","Fragrance","Men","Hair Care","Books");
		 
		 List<String> actualCat=hpage.validateSearchBarCategories();
		 
		 Assert.assertEquals(actualCat, expectedCat,"Search Bar Categories Not Matching !!");
		 
		 logger.info("Validate Search Bar Categories Test Completed");
		 
	 }
	 
	 @Test
	 public void validateCurrencyDropValuesTest()
	 {
		 logger.info("Validate Currency Drop down values Test Started");
		 
		 List<String> expectedValues=Arrays.asList("€ EURO","£ POUND STERLING","$ US DOLLAR");
		 
		 List<String> actualValues=hpage.validateCurrencyDropdown();
		 
		 Assert.assertEquals(actualValues, expectedValues,"Currency Drop Down Values Not Matching !!");
		 
		 logger.info("Validate Currency Drop down values Test Completed");
		 
	 }
	 
	 @Test
	 public void validateSocialMediaIconsTest()
	 {
		 logger.info("Validate Social Media Icons Test Started");
		 
		 hpage.validateSocialMediaIcons();
		 
		 logger.info("Validate Social Media Icons Test Completed");
	 }
	 
	 @Test
	 public void validateFeatureProductSectionTest()
	 {
		boolean flag= hpage.validateFeaturedProductsDisplayed();
		Assert.assertFalse(flag);
		
		int productCount=hpage.validateNoofProducts();
		System.out.println("Total Products on Featured Section : " +productCount);
		
		hpage.printFeaturedProducts();
	 }
	 
	 @Test
	 public void validateFooterSectionItems()
	 {
		boolean flag= hpage.validateFooterSectionDisplayed();
		Assert.assertTrue(flag);
		
		String aboutUsText=hpage.validateFooterAboutUsDisplayed();
		Assert.assertEquals(aboutUsText, "ABOUT US", "About Us Text is not Matching !!");
		
		String aboutUsInfo=hpage.getFooterAbousUsInfo();
		Assert.assertEquals(aboutUsInfo, "This store has been created to enable students to practice their automation testing skills. This is not a real store, no orders are actually placed or payments taken. "
				+ "This store is to be used for educational purposes only.", "About Us Info Text is not Matching !!");
	 }
	 
	 @Test
	 public void validateContactUsSectionTest()
	 {
		String contactUs= hpage.validateContactUsSectionDisplayed();
		Assert.assertEquals(contactUs, "CONTACT US", "Contact Us Text is not Matching!!");
		
		List<String> expectedDetails=Arrays.asList("+123 456 7890","admin@automationteststore.com");
		
		List<String> actualDetails=hpage.getContactUsDetails();
		
		Assert.assertEquals(actualDetails, expectedDetails);
	 }

	 @Test
	 public void validatefooterLinksTest()
	 {
		 hpage.validateFooterLinks();
	 }
	 
	 @Test
	 public void validateBrandsLinksTest()
	 {
		 hpage.checkBrandLinks();
	 }
}
