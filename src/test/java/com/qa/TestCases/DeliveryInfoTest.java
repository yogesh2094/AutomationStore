package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.AccountsPage;
import com.qa.pages.AddressBookPage;
import com.qa.pages.ChangePasswordPage;
import com.qa.pages.CheckoutAddressPage;
import com.qa.pages.CheckoutPage;
import com.qa.pages.DeliveryInfoPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.ShoppingCartPage;

public class DeliveryInfoTest extends TestBase {
	
	LoginPage lpage;
	
	AccountsPage apage;
	
	ChangePasswordPage cppage;
	
	AddressBookPage abpage;
	HomePage hpage;
	ProductsPage ppage;
	ShoppingCartPage spage;
	ProductDetailsPage pdpage;
	CheckoutPage cpage;
	DeliveryInfoPage dpage;
	CheckoutAddressPage capage;
	
	public DeliveryInfoTest()
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
		        ppage=new ProductsPage(getDriver());
		        spage=new ShoppingCartPage(getDriver());
		        
		        pdpage=new ProductDetailsPage(getDriver());
		        cpage=new CheckoutPage(getDriver());
		        
		        ppage.validateProductPageTitle();
		        ppage.getProductDetailsPage();
		        pdpage.clickonCartBtn();
	        
		        spage.clickonCheckoutBtn();
		        dpage=new DeliveryInfoPage(getDriver());
		        capage=new CheckoutAddressPage(getDriver());
		        cpage.clickOnEditShippingBtn();
	        
	    }

	    
	    @Test
	    public void validateDeliveryInfoPageTitleTest()
	    {
	    	setup();
	    	String title=dpage.validateDeliveryInfoPageTitle();
	    	Assert.assertEquals(title, "Delivery Information");
	    }
	    
	    @Test
	    public void clickonChangeAddBtnTest()
	    {
	    	setup();
	    	
	    	capage=dpage.clickonChangeAddBtn();
	    }
	    
	    @Test
	    public void validateShippingrateTest()
	    {   
	    	setup();
	    	String label=dpage.getShippingLabel();
	    	Assert.assertEquals(label, "Flat Shipping Rate");
	    	
	    	String rate=dpage.getShippingRate();
	    	Assert.assertEquals(rate, "$2.00");
	    }
	    
	    @Test
	    public void clickOnContinueBtn()
	    {
	    	setup();
	    	dpage.addCommentsandContinue();
	    }
}
