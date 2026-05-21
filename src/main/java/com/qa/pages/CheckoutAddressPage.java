package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.BaseFormPage;
import com.qa.util.WaitUtility;

public class CheckoutAddressPage extends BaseFormPage {
	
WebDriver driver;
	
	@FindBy(xpath="//section[@class='old_address']//h4")
	WebElement addressBookTitle;
	
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr/td[2]/label")
	WebElement addressBookEntries;
	
	@FindBy(xpath="//button[@class='btn btn-orange pull-right']")
	WebElement continueBtn;
	
	@FindBy(name="company")
	WebElement com;
	
	@FindBy(xpath="//button[@class='btn btn-orange pull-right lock-on-click']")
	WebElement continueBtn1;
	
	WaitUtility util;
	
	// Constructor
    public CheckoutAddressPage(WebDriver driver) 
    { 

        super(driver);

        PageFactory.initElements(driver, this);
        util = new WaitUtility(driver);

    }
    
    public String validatePageTitle()
    {
    	return driver.getTitle();
    }
    
    public String getAddressBookEntries()
    {
    	String entries="";
    	if(addressBookTitle.isDisplayed())
    	{
    		 entries=addressBookEntries.getText();
    		System.out.println(entries);
    		
    	}
    	
    	return entries;
    }
    
    public CheckoutPage clickOnContinueBtn()
    {
    	continueBtn.click();
    	return new CheckoutPage(driver);
    }

    public void addNewAddress(String fn,
            String ln,
            String company1,
            String add,
            String city1,
            String state,
            String postcode1)
    {
    	com.clear();
    	com.sendKeys(company1);
    	
    	enterUserDetails(fn, ln, add, city1, state, postcode1);
    	continueBtn1.click();
    }
}
