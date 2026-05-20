package com.qa.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	@FindBy(xpath="//table[@class='table confirm_shippment_options']/tbody/tr/td[2]/address")
	WebElement shippingAddress;
	
	@FindBy(xpath="//table[@class='table confirm_shippment_options']/tbody/tr/td[3]")
	WebElement shippingRate;
	
	@FindBy(xpath="//table[@class='table confirm_shippment_options']/tbody/tr//a[@class='btn btn-default btn-xs']")
	WebElement editShipping;
	
	@FindBy(xpath="//table[@class='table confirm_payment_options']/tbody/tr/td[1]")
	WebElement paymentName;
	
	@FindBy(xpath="//table[@class='table confirm_payment_options']/tbody/tr/td[2]/address")
	WebElement paymentAddress;
	
	@FindBy(xpath="//table[@class='table confirm_payment_options']/tbody/tr/td[3]")
	WebElement paymentType;
	
	@FindBy(xpath="//table[@class='table confirm_payment_options']/tbody/tr//a[@class='btn btn-default btn-xs']")
	WebElement editPayment;
	
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
    
    public Map<String, String> getShippingNameDetails()
    {
    	//List<String> actualDetails=new ArrayList<>();
    	
    	Map<String, String> actualDetails=new LinkedHashMap<>();
    	
    	String fullText =
                shippingName.getText();
    	String[] details =
                fullText.split("\n");
    	
    	 actualDetails.put(
    	            "ShippingName",
    	            details[0].trim());
    	
    	 actualDetails.put(
    	            "PhoneNumber",
    	            details[1].trim());
    	 
    	String addressText=shippingAddress.getText();
    	String [] adetails=addressText.split("\n");
    	
    	actualDetails.put("ShippingCompany", adetails[0].trim());
    	actualDetails.put("ShippingAdd1", adetails[1].trim());
    	actualDetails.put("ShippingCountry", adetails[2].trim());
    	
    	actualDetails.put("ShipRate", shippingRate.getText());
    	
    	return actualDetails;
    	
    }
    
    public void clickOnEditShippingBtn()
    {
    	editShipping.click();
    }
	
    public Map<String, String> getPaymentDetails()
    {
    	//List<String> actualDetails=new ArrayList<>();
    	
    	Map<String, String> actualDetails=new LinkedHashMap<>();
    	
    	String fullText =
                paymentName.getText();
    	String[] details =
                fullText.split("\n");
    	
    	 actualDetails.put(
    	            "PaymentName",
    	            details[0].trim());
    	
    	 actualDetails.put(
    	            "PhoneNumber",
    	            details[1].trim());
    	 
    	String paddressText=paymentAddress.getText();
    	String [] adetails=paddressText.split("\n");
    	
    	actualDetails.put("PaymentCom", adetails[0].trim());
    	actualDetails.put("PaymentAdd1", adetails[1].trim());
    	actualDetails.put("PaymentCountry", adetails[2].trim());
    	
    	actualDetails.put("PaymentMode", paymentType.getText());
    	
    	return actualDetails;
	}
    
    public void clickOnEditPaymentBtn()
    {
    	editPayment.click();
    }
}
