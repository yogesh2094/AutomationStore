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
import com.qa.pages.AddressBookPage;
import com.qa.pages.ChangePasswordPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsPage;

public class ProductDetailsTest extends TestBase {

LoginPage lpage;
	
	AccountsPage apage;
	
	ChangePasswordPage cppage;
	
	AddressBookPage abpage;
	HomePage hpage;
	ProductsPage ppage;
	ProductDetailsPage pdpage;
	
	ProductDetailsTest()
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
	        pdpage=new ProductDetailsPage(getDriver());
	        
	        ppage.validateProductPageTitle();
	        ppage.getProductDetailsPage();
	    }
	 
	 @Test
	 public void validateProductDetails()
	 {
		 String name=pdpage.validateProductName();
		 
		 Assert.assertEquals(name, "Pour Homme Eau de Toilette","Product Name is not Matching");
		 
		String price= pdpage.getProductPrice();
		
		Assert.assertEquals(price, "82.59€", "Product Price is not Matching !!");
	 }
	 
	 @Test
	 public void validateSizeDropDownTest()
	 {
		 List<String> expectedValues=Arrays.asList("1.7 oz","2.5 oz $20.00","3.4 oz $25.00");
		 
		 List<String> actualValues=pdpage.getSizeDropValues();
		 
		 Assert.assertEquals(actualValues, expectedValues);
	 }
	 
	 @Test
	 public void validateTotalPricewithQty()
	 {
		 double initialPrice=pdpage.getTotalPrice();
		 System.out.println("Initial Price is : " +initialPrice);
		 
		 //Change Qty to 2
		 
		 pdpage.updateProductQty("2");
		 
		 double updatedPrice=pdpage.getTotalPrice();
		 
		 //Expected Price
		 
		 double expectedPrice=initialPrice * 2;
		 
		 Assert.assertEquals(updatedPrice, expectedPrice,"Price Mismatch after qty Update");
	 }
	 
	 @Test
	 public void validateTotalPriceWithSize()
	 {
		 Map<String, String> expectedValues=new LinkedHashMap<>();
			
			expectedValues.put("1.7 oz", "$88.00");
			expectedValues.put("2.5 oz $20.00", "$108.00");
			expectedValues.put("3.4 oz $25.00", "$113.00");
			
			for(Map.Entry<String,String> entry
		            : expectedValues.entrySet()){

		        String size = entry.getKey();

		        String expectedPrice =
		                entry.getValue();

		        // Select Size
		        pdpage.selectSize(size);

		        // Get Actual Price
		        String actualPrice =
		                pdpage.getUpdatedPrice();

		        System.out.println(
		                "Size : " + size);
			
		        // Validation
		        Assert.assertEquals(
		                actualPrice,
		                expectedPrice,
		                "Price mismatch for size : "
		                        + size);
			
	 }
	 }
	 

}
