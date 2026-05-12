package com.qa.pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;
import com.qa.util.WaitUtility;

public class ProductsPage extends TestBase {

	WebDriver driver;
	
	@FindBy(xpath="//a[@class='logo']")
	WebElement logo;
	
	@FindBy(xpath="//li//a[@href='https://automationteststore.com/index.php?rt=product/category&path=49']")
	WebElement fragrance;
	
	@FindBy(xpath="//li//a[@href='https://automationteststore.com/index.php?rt=product/category&path=49_51']")
	WebElement Menfragrance;
	
	@FindBy(xpath="//select[@name='sort']")
	WebElement SortByDrop;
	
	@FindBy(xpath="//div[@class='pricetag jumbotron']//a[@data-id='63']")
	WebElement product;
	
	
	WaitUtility util =new WaitUtility(getDriver());
	
	// Constructor
    public ProductsPage(WebDriver driver) 
    { 

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }
    
    //Action Methods
    
    public String validateProductPageTitle()
    {
    	logo.click();
    	
    	Actions ac=new Actions(getDriver());
    	ac.moveToElement(fragrance).perform();
    	//fragrance.click();
    	util.elementToBeClickable(Menfragrance, 20); // Wait Utility Method
    	Menfragrance.click();
    	
    	return driver.getTitle();
    	
    }
    
    public List<String> getSortByDropdownValues()
    {
    	Select sel=new Select(SortByDrop);
    	
    	List<WebElement> allOptions=sel.getOptions();
    	
    	List<String> actualValues=new ArrayList<String>();
    	
    	for(WebElement option :allOptions)
    	{
    		System.out.println(option.getText());
    		actualValues.add(option.getText());
    	}
    	
    	return actualValues;
    	
    }
    
	public String getProductDetailsPage()
	{
		product.click();
		
		return driver.getTitle();
		
		
	}
	
}
