package com.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BaseFormPage {
	
	WebDriver driver;
	@FindBy(xpath="//a[text()='Login or register']")
	WebElement registerLink;
	
	@FindBy(name="firstname")
	WebElement firstname;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	
	@FindBy(name="address_1")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="zone_id")
	WebElement zone;
	
	@FindBy(name="postcode")
	WebElement postcode;
	
	@FindBy(name="country_id")
	WebElement country;
	
	
	public BaseFormPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Action Methods
	
	public void enterUserDetails(
			String fn,
            String ln,
            String add,
            String city1,
            String state,
            String postcode1)
	{
		firstname.clear();
		firstname.sendKeys(fn);
		
		lastname.clear();
		lastname.sendKeys(ln);
		
		address.clear();
		address.sendKeys(add);
		
		city.clear();
		city.sendKeys(city1);
		
		Select sel=new Select(zone);
		sel.selectByVisibleText("Bristol");
		
		postcode.clear();
		postcode.sendKeys(postcode1);
		
		
	}

}
