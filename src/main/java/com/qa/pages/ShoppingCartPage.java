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

public class ShoppingCartPage {
	
WebDriver driver;
	
	@FindBy(xpath="//div[@class='container-fluid cart-info product-list']/table/tbody/tr/th")
	List<WebElement> cartHeaders;
	
	@FindBy(xpath="//div[@class='container-fluid cart-info product-list']/table/tbody/tr[2]/td[2]/a")
	WebElement productName;
	
	@FindBy(xpath="//div[@class='container-fluid cart-info product-list']/table/tbody/tr[2]/td[3]")
	WebElement productModel;
	
	@FindBy(xpath="//div[@class='container-fluid cart-info product-list']/table/tbody/tr[2]/td[4]")
	WebElement unitPrice;
	
	@FindBy(xpath="//input[@id='cart_quantity6365aa2de1a315740513d57700a595f6d2']")
	WebElement quantity;
	
	@FindBy(xpath="//div[@class='container-fluid cart-info product-list']/table/tbody/tr[2]/td[6]")
	WebElement total;
	
	@FindBy(xpath="//div[@class='container-fluid cart-info product-list']/table/tbody/tr/td[6]")
	List<WebElement> allProductsTotal;
	
	@FindBy(xpath="//table[@id='totals_table']/tbody/tr[1]/td[2]")
	WebElement subTotal;
	
	@FindBy(xpath="//table[@id='totals_table']/tbody/tr[2]/td[2]")
	WebElement flatRate;
	
	@FindBy(xpath="//table[@id='totals_table']/tbody/tr[3]/td[2]")
	WebElement grandTotal;
	
	WaitUtility util;
	
	// Constructor
    public ShoppingCartPage(WebDriver driver) 
    { 

        this.driver = driver;

        PageFactory.initElements(driver, this);
        util = new WaitUtility(driver);

    }
    
    //Action Methods
    
    public String returnPageTitle()
    {
    	return driver.getTitle();    
    	
    }

    public List<String> validateCartTableHeaders()
    {
    	List<String> actualHeaders=new ArrayList<>();
    	
    	for(WebElement headers:cartHeaders)
    	{
    		String hs=headers.getText();
    		
    		actualHeaders.add(hs);
    	}
    	return actualHeaders;
    }
    
    public Map<String, String> getProductDetails()
    {
    	Map<String, String> actualDetails=new LinkedHashMap<>();
    	
    	actualDetails.put("Name", productName.getText());
    	actualDetails.put("Model", productModel.getText());
    	actualDetails.put("UnitPrice", unitPrice.getText());
    	actualDetails.put("Quantity", quantity.getAttribute("value"));
    	actualDetails.put("Total", total.getText());
    	
    	return actualDetails;
    	
    }
    
    public void validateAllproductPricewithSubTotal()
    {
    	
    	double sum=0;
    	//Capture all totals
    	for(WebElement to:allProductsTotal)
    	{
    		String price=to.getText();
    		price=price.replace("$", "").trim();
    		System.out.println(price);
    		
    		double allPrice=Double.parseDouble(price);
    		
    		sum=sum+allPrice;
    	}
    	
    	System.out.println("Total Price :" +sum);
    	
    	//Capture Sub Total
    	
    	String sTotal=subTotal.getText().trim();
    	sTotal=sTotal.replace("$", "").trim();
    	
    	double subTotal=Double.parseDouble(sTotal);
    	
    	if(sum==subTotal)
    	{
    		System.out.println("All Products Total price is matches with SubTotal");
    	}
    }
    
    public double getCalculatedTotal()
    {
    	String rate=flatRate.getText().trim();
    	rate=rate.replace("$", "");
    	
    double shipRate=Double.parseDouble(rate);
    
    
    
  //Capture Sub Total
	
	String sTotal=subTotal.getText().trim();
	sTotal=sTotal.replace("$", "").trim();
	
	double subTotal=Double.parseDouble(sTotal);
    
    
    //Addition of SubToatl and Flat Rate
    
    double calculatedTotal=subTotal+shipRate;
    
   System.out.println("Calculated Total is :" +calculatedTotal);
   return calculatedTotal;
    
    }

    public double getActualTotal()
    {
    	//Capture Grand Total
        String gTotal=grandTotal.getText().trim();
        gTotal=gTotal.replace("$", "");
        
        double actualTotal=Double.parseDouble(gTotal);
        System.out.println("Actual Total is :"+actualTotal);
        
        return actualTotal;
    }
    	
}
