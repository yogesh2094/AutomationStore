package com.qa.TestCases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.AccountsPage;
import com.qa.pages.AddressBookPage;
import com.qa.pages.ChangePasswordPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.ShoppingCartPage;

public class ShoppingCartTest extends TestBase{
	
	LoginPage lpage;
	
	AccountsPage apage;
	
	ChangePasswordPage cppage;
	
	AddressBookPage abpage;
	HomePage hpage;
	ProductsPage ppage;
	ShoppingCartPage spage;
	ProductDetailsPage pdpage;
	
	ShoppingCartTest()
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
	        
	        ppage.validateProductPageTitle();
	        ppage.getProductDetailsPage();
	        pdpage.clickonCartBtn();
	    }

	    @Test
	    public void validatePageTitle()
	    {
	    	setup();
	    	String title=spage.returnPageTitle();
	    	Assert.assertEquals(title, "Shopping Cart");
	    }
	    
	    @Test
	    public void validateCartHeadersTest()
	    {
	    	setup();
	    	List<String> expectedHeaders=Arrays.asList("Image","Name","Model","Unit Price","Quantity","Total","Remove");
	    	
	    	List<String> actualHeaders=spage.validateCartTableHeaders();
	    	
	    	Assert.assertEquals(actualHeaders, expectedHeaders);
	    	
	    }
	    
	    @Test
	    public void validateProductDetailsTest()
	    {
	    	setup();
	    	
	    	Map<String, String> expectedDetails=new LinkedHashMap<>();
	    	
	    	expectedDetails.put("Name", "Pour Homme Eau de Toilette");
	    	expectedDetails.put("Model", "374622");
	    	expectedDetails.put("UnitPrice", "$113.00");
	    	expectedDetails.put("Quantity", "2");
	    	expectedDetails.put("Total", "$226.00");
	    	
	    	Map<String, String> actualDetails=spage.getProductDetails();
	    	
	    	Assert.assertEquals(actualDetails, expectedDetails);
	    }
	    
	    @Test
	    public void validateAllProductPriceTotal()
	    {
	    	setup();
	    	
	    	spage.validateAllproductPricewithSubTotal();
	    }
	    
	    @Test
	    public void validateGrandTotalTest()
	    {
	    	setup();
	    	
	    	double calculatedTotal=spage.getCalculatedTotal();
	    	double actualTotal=spage.getActualTotal();
	    	
	    	Assert.assertEquals(calculatedTotal, actualTotal,"Grand Total is not Matching !!");
	    }
	    
	    @Test
	    public void validateNoofProductRowsTest()
	    {
	    	setup();
	    	spage.getAllProductRows();
	    }
	    
}
	    	
	    

