package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
import com.qa.util.ExcelUtils;

public class CheckoutAddressTest extends TestBase{

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
	
	public CheckoutAddressTest()
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
		        dpage.clickonChangeAddBtn();
	        
	    }

	    @Test
	    public void validateCheckoutAddressPageTitleTest()
	    {
	    	setup();
	    	String title=capage.validatePageTitle();
	    	Assert.assertEquals(title, "Checkout Address");
	    }
	    
	    @Test
	    public void validateAddressBookEntriesTest()
	    {
	    	setup();
	    	String actualEntries=capage.getAddressBookEntries();
	    	Assert.assertEquals(actualEntries, "Yogesh Sarode, testsg, Airoli, Bristol, 400708.0, United Kingdom");
	    	
	    	cpage=capage.clickOnContinueBtn();
	    }
	    
	    @Test(dataProvider = "AddNewAdd")
	    public void validateAddNewAddressTest(String fn,
	            String ln,
	            String company1,
	            String add,
	            String city1,
	            String state,
	            String postcode1)
	    {
	    	setup();
	    	capage.addNewAddress(fn,ln,company1,add,city1,state,postcode1);
	    }
	    
	    @DataProvider(name="AddNewAdd")
	    public Object[][] getData() throws Exception {
	        return ExcelUtils.getExcelData("C:\\Users\\dell\\Desktop\\NewAddress.xlsx", "NewAddress");
	    }
}
