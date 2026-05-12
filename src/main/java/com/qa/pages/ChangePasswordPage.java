package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ChangePasswordPage extends TestBase{
	WebDriver driver;
	@FindBy(xpath="//ul[@class='nav-dash']//a[@href='https://automationteststore.com/index.php?rt=account/password']")
	WebElement changePass;
	
	@FindBy(xpath="//label[@class='control-label col-md-4']")
	List<WebElement> changePassFields;
	
	@FindBy(xpath="//input[@name='current_password']")
	WebElement currentPass;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement newPass;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement confirmPass;
	
	@FindBy(xpath="//button[@title='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successMsg;
	
	
	
	
	public ChangePasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	//Action Methods
	
	public String validatePageTitle()
	{
		changePass.click();
		return driver.getTitle();
	}
	
	public List<String> validateChangePassFields()
	{
		
		changePass.click();
		
		List<String> actualFields=new ArrayList<>();
		
		for(WebElement fields:changePassFields)
		{
			String fieldLabel=fields.getText();
			System.out.println(fieldLabel);
			
			if(!fieldLabel.isEmpty())
			{
				actualFields.add(fieldLabel);
			}
		}
		
		return actualFields;
		
	}
	
	public String changePasswordfunc()
	{
		changePass.click();
		currentPass.sendKeys("1234");
		newPass.sendKeys("12345");
		confirmPass.sendKeys("12345");
		
		if(continueButton.isEnabled())
		{
			continueButton.click();
		}
		
		return successMsg.getText();
	}
}
