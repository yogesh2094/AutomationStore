package com.qa.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AccountsPage {
	
	 WebDriver driver;
	@FindBy(xpath="//span[@class='subtext']")
	WebElement accountName;
	
	@FindBy(xpath="//ul//a[@data-original-title]")
	List<WebElement> iconList;
	
	@FindBy(xpath="//ul[@class='nav-dash']//a[@href='https://automationteststore.com/index.php?rt=account/edit']")
	WebElement editAccount;
	
	@FindBy(xpath="//label[@class='control-label col-md-4']")
	List<WebElement> fieldList;
	
	@FindBy(xpath="//input[@id='AccountFrm_firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='AccountFrm_lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='AccountFrm_email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='AccountFrm_telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='AccountFrm_fax']")
	WebElement fax;
	
	
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	//Action Methods
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public String validateAccountName()
	{
		return accountName.getText();
	}
	
	public List<String> validateIconList()
	{
		List<String> actualList=new ArrayList<String>();
		
		for(WebElement link : iconList) {
			
			String text=link.getAttribute("data-original-title");
			System.out.println(text);
			if(text != null && !text.trim().isEmpty()) {
	            actualList.add(text.trim());
	        }
            
        }
	
        return actualList;
	}
	
	public List<String> validateAccountDetails()
	{
		editAccount.click();
		
		List<String> actualFields=new ArrayList<String>();
		
		for(WebElement link:fieldList)
		{
			String text=link.getText();
			System.out.println(text);
			
			if (!text.isEmpty()) {

	            actualFields.add(text);
		}
		
	}
		return actualFields;
	}
	
	public Map<String, String> validateAccountdetailsFieldsValues()
	{
		editAccount.click();
		
		Map<String, String> actualValues=new LinkedHashMap<>();
		
		actualValues.put("First Name",firstname.getAttribute("value"));
		actualValues.put("Last Name",lastname.getAttribute("value"));
		actualValues.put("Email",email.getAttribute("value"));
		actualValues.put("Telephone",telephone.getAttribute("value"));
		actualValues.put("Fax",fax.getAttribute("value"));
		
		return actualValues;
		
	}
}



