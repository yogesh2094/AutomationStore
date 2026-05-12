package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressBookPage {
	
	WebDriver driver;
	@FindBy(xpath="//ul[@class='nav-dash']//a[@href='https://automationteststore.com/index.php?rt=account/address']")
	WebElement manageAddress;
	
	@FindBy(xpath="//div[@class='genericbox border-bottom']/table/tbody/tr/td/address")
	WebElement addressEntries;
	
		
	
	
	
	
	public AddressBookPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	//Action Methods
	
	public String validateAddressBookPageTitle()
	{
		manageAddress.click();
		return driver.getTitle();
		
	}

	public String validateAddressBookEntries()
	{
		manageAddress.click();
		return addressEntries.getText().replace("\n", " ").trim();
	}
}
