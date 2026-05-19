package com.qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.qa.util.WaitUtility;

public class ProductDetailsPage  {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='bgnone']")
	WebElement productName;
	
	@FindBy(xpath="//div[@class='productfilneprice']")
	WebElement productPrice;
	
	@FindBy(id="option316")
	WebElement sizeDrop;
	
	@FindBy(id="product_quantity")
	WebElement quantity;
	
	@FindBy(xpath="//span[@class='total-price']")
	WebElement TotalPrice;
	
	@FindBy(id="option316")
	WebElement sizeDropDown;
	
	@FindBy(xpath="//a[@class='cart']")
	WebElement cartBtn;
	
	WaitUtility util;
	
	// Constructor
    public ProductDetailsPage(WebDriver driver) 
    { 

        this.driver = driver;

        PageFactory.initElements(driver, this);
        util = new WaitUtility(driver);

    }
    
    //Action Methods
    
    public String validateProductName()
    {
    	return productName.getText();
    }
    
    public String getProductPrice()
    {
    	return productPrice.getText();
    }
    
    public List<String> getSizeDropValues()
    {
    	List<String> actualValues=new ArrayList<>();
    	
    	Select sel=new Select(sizeDrop);
    	List<WebElement> options=sel.getOptions();
    	for(WebElement op:options)
    	{
    		System.out.println(op.getText());
    		actualValues.add(op.getText());
    	}
    	return actualValues;
    }
    
    public double getTotalPrice()
    {
    	util.waitforElementVisible(TotalPrice, 20);
    	String price=TotalPrice.getText();
    	System.out.println(price);
    	price=price.replace("$", "").trim();
    	
    	return Double.parseDouble(price);
    }
    
    //Update Quantity 102303493273
    
    public void updateProductQty(String qty)
    {
    	quantity.clear();
    	quantity.sendKeys(qty);
    }
    
    public void selectSize(String size){

        Select sc = new Select(sizeDropDown);

        sc.selectByVisibleText(size);
    }

    // Get Updated Price

    public String getUpdatedPrice(){

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(driver ->
                !TotalPrice.getText()
                        .trim()
                        .isEmpty());

        return TotalPrice.getText().trim();
    }
    
    public void clickonCartBtn()
    {
    	cartBtn.click();
    }
}
