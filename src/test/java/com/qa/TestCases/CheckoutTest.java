package com.qa.TestCases;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.AccountsPage;
import com.qa.pages.AddressBookPage;
import com.qa.pages.ChangePasswordPage;
import com.qa.pages.CheckoutPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.ShoppingCartPage;

public class CheckoutTest extends TestBase{
	
	LoginPage lpage;
	
	AccountsPage apage;
	
	ChangePasswordPage cppage;
	
	AddressBookPage abpage;
	HomePage hpage;
	ProductsPage ppage;
	ShoppingCartPage spage;
	ProductDetailsPage pdpage;
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
		        ppage=new ProductsPage(getDriver());
		        spage=new ShoppingCartPage(getDriver());
		        
		        pdpage=new ProductDetailsPage(getDriver());
		        cpage=new CheckoutPage(getDriver());
		        
		        ppage.validateProductPageTitle();
		        ppage.getProductDetailsPage();
		        pdpage.clickonCartBtn();
	        
	        //spage.clickonCheckoutBtn();
	        
	    }
	 
	    @Test
	    public void validateTitleTest()
	    {
	    	setup();
	    	String title=cpage.validatePageTitle();
	    	
	    	Assert.assertEquals(title, "Checkout Confirmation");
	    }

	    @Test
	    public void validateShippingDetailsTest()
	    {
	    	setup();
	    	Map<String, String> expectedValues=new LinkedHashMap<>();
	    	
	    	expectedValues.put("ShippingName", "Yogesh Sarode");
	    	expectedValues.put("PhoneNumber", "8.987876751E9");
	    	
	    	expectedValues.put("ShippingCompany", "testsg");
	    	expectedValues.put("ShippingAdd1", "Airoli Bristol 400708.0");
	    	expectedValues.put("ShippingCountry", "United Kingdom");
	    	
	    	expectedValues.put("ShipRate", "Flat Shipping Rate");
	    	
	    	Map<String, String> actualValues=cpage.getShippingNameDetails();
	    	
	    	Assert.assertEquals(actualValues, expectedValues);
	    }
	    
	    @Test
	    public void validatePaymentDetailsTest()
	    {
	    	setup();
	    	Map<String, String> expectedValues=new LinkedHashMap<>();
	    	
	    	expectedValues.put("PaymentName", "Yogesh Sarode");
	    	expectedValues.put("PhoneNumber", "8.987876751E9");
	    	
	    	expectedValues.put("PaymentCom", "testsg");
	    	expectedValues.put("PaymentAdd1", "Airoli Bristol 400708.0");
	    	expectedValues.put("PaymentCountry", "United Kingdom");
	    	
	    	expectedValues.put("PaymentMode", "Cash On Delivery");
	    	
	    	Map<String, String> actualValues=cpage.getPaymentDetails();	   
	    	
	    	Assert.assertEquals(actualValues, expectedValues);
	    }
	    
	    @Test
	    public void validateProductsMatchTest()
	    {
	    	setup();
	    	System.out.println(getDriver().getCurrentUrl());
	    	List<String> shoppingCartProducts=spage.getCartProducts();
	    	spage.clickonCheckoutBtn();
	    	List<String> checkoutPageProducts=cpage.getCheckoutProducts();
	    	
	    	System.out.println("Shopping Cart Products : " +shoppingCartProducts);
	    	System.out.println("Checkout Page Products : " +checkoutPageProducts);
	    	
	    	Assert.assertEquals(shoppingCartProducts, checkoutPageProducts,"Products are not Matching!!!");
	    	
	    }
	    
	    @Test
	    public void validateTotalAmountMatchesTest()
	    {
	    	setup();
	    	double cartTotal=spage.getCartTotal();
	    	spage.clickonCheckoutBtn();
	    	double checkoutTotal=cpage.getCheckoutTotal();
	    	
	    	System.out.println("Shopping Cart Total : " +cartTotal);
	    	System.out.println("Checkout page Total : " +checkoutTotal);
	    	
	    	Assert.assertEquals(cartTotal, checkoutTotal);
	    }
}
