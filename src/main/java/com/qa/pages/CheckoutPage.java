package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.WaitUtility;

public class CheckoutPage {

	WebDriver driver;
	
	@FindBy(xpath="//h4[@class='heading4'][1]")
	WebElement shipping;
	
	@FindBy(xpath="//h4[@class='heading4'][2]")
	WebElement payment;
	
	@FindBy(xpath="//h4[@class='heading4'][3]")
	WebElement itemsCart;
	
	@FindBy(xpath="//table[@class='table confirm_shippment_options']/tbody/tr/td[1]")
	WebElement shippingName;
	
WaitUtility util;
	
	// Constructor
    public CheckoutPage(WebDriver driver) 
    { 

        this.driver = driver;

        PageFactory.initElements(driver, this);
        util = new WaitUtility(driver);

    }
    
    //Action Methods
    
    public String validatePageTitle()
    {
    	return driver.getTitle();
    }
    
    public void getShippingNameDetails()
    {
    	//List<String> actualDetails=new ArrayList<>();
    	
    	String ship=shipping.getText();
    	System.out.println(ship);
    	
    }
	
	
	
	
}
