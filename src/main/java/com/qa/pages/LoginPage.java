package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	WebDriver driver;
	@FindBy(xpath="//a[text()='Login or register']")
	WebElement registerLink;
	
	@FindBy(name="loginname")
	WebElement loginname;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@title='Login']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public AccountsPage validateLogin(String user, String pass)
	{
		registerLink.click();
		loginname.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		
		return new AccountsPage(driver);
		
	}
	
}
