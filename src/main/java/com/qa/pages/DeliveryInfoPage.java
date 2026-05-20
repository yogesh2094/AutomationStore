package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.WaitUtility;

public class DeliveryInfoPage {

	WebDriver driver;
	
	@FindBy(xpath="//h4[text()='Shipping Address']")
	WebElement shippingAdd;
	
	@FindBy(xpath="//a[@title='Change Address']")
	WebElement changeAddBtn;
	
	@FindBy(xpath="//h4[text()='Shipping Method']")
	WebElement shippingMethod;
	
	@FindBy(xpath="//div[@class='registerbox'][2]/table/tbody/tr/td[2]/label")
	WebElement shippingLabel;
	
	@FindBy(xpath="//div[@class='registerbox'][2]/table/tbody/tr/td[3]/label")
	WebElement shippingRate;
	
	@FindBy(id="shipping_comment")
	WebElement comments;
	
	@FindBy(xpath="//button[@title='Continue']")
	WebElement continueBtn;
	
	WaitUtility util;
	
	// Constructor
    public DeliveryInfoPage(WebDriver driver) 
    { 

        this.driver = driver;

        PageFactory.initElements(driver, this);
        util = new WaitUtility(driver);

    }
    
    //Action Methods
    
    public String validateDeliveryInfoPageTitle()
    {
    	return driver.getTitle();
    }
    
    public CheckoutAddressPage clickonChangeAddBtn()
    {
    	if(shippingAdd.isDisplayed())
    	{
    		if(changeAddBtn.isDisplayed())
    		{
    			changeAddBtn.click();
    		}
    	}
    	return new CheckoutAddressPage(driver);
    }
    
    public String getShippingLabel()
    {
    	String label=shippingLabel.getText().trim();
    	
    	return label;	
    			
    }
    
    public String getShippingRate()
    {
    	String rate=shippingRate.getText().trim();
    	return rate;
    }
    
    public void addCommentsandContinue()
    {
    	comments.sendKeys("Delivery Information is Correct");
    	continueBtn.click();
    }
}
