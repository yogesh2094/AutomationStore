package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
	WebDriver driver;
	@FindBy(xpath="//a[text()='Login or register']")
	WebElement registerLink;
	
	@FindBy(xpath="//button[@title='Continue']")
	WebElement continueButton;
	
	@FindBy(name="firstname")
	WebElement firstname;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="email")
	WebElement email1;
	
	@FindBy(name="telephone")
	WebElement telephone;
	
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
	
	@FindBy(name="loginname")
	WebElement loginname;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirm")
	WebElement confirm;
	
	@FindBy(id="AccountFrm_newsletter0")
	WebElement newslettter;
	
	@FindBy(id="AccountFrm_agree")
	WebElement agree;
	
	@FindBy(xpath="//button[@title='Continue']")
	WebElement continueButton1;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void registerUser(String fn, String ln, String email, String number, String add, String city1,String postcode1,
			String nlogin, String pass, String cpass )
	{
		
		registerLink.click();
		continueButton.click();
		
		firstname.clear();
		firstname.sendKeys(fn);
		
		lastname.clear();
		lastname.sendKeys(ln);
		
		email1.clear();
		email1.sendKeys(email);
		
		telephone.clear();
		telephone.sendKeys(number);
		
		address.clear();
		address.sendKeys(add);
		
		city.clear();
		city.sendKeys(city1);
		
		Select sel=new Select(zone);
		sel.selectByVisibleText("Bristol");
		
		postcode.clear();
		postcode.sendKeys(postcode1);
		
		
		
		loginname.clear();
		loginname.sendKeys(nlogin);
		
		password.clear();
		password.sendKeys(pass);
		
		confirm.clear();
		confirm.sendKeys(cpass);
		
		newslettter.click();
		agree.click();
	
		continueButton1.click();

}
}