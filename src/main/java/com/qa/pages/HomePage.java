package com.qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestUtil;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='logo']")
	WebElement logo;
	
	@FindBy(xpath="//ul[@id='customer_menu_top']")
	WebElement welcomeBack;

	@FindBy(xpath="//div[@class='block_2']//li[@class='dropdown']//a")
	List<WebElement> menuList;
	
	@FindBy(xpath="//ul[@id='main_menu_top']/li/a/span[@class='menu_text']")
	List<WebElement> headerMenu;
	
	@FindBy(xpath="//form[@id='search_form']")
	WebElement searchBar;
	
	@FindBy(xpath="//li[@class='search-category']/a")
	List<WebElement> searchCategories;
	
	@FindBy(xpath="//div[@class='block_6']//ul/li/a")
	WebElement currencyDrop;
	
	@FindBy(xpath="//ul[@class='dropdown-menu currency']/li/a")
	List<WebElement> currencyValues;

	
	@FindBy(xpath="//div[@class='header_block']/div/a")
	List<WebElement> socialIcons;
	
	@FindBy(xpath="//div[@class='header_block']/div/a[@class='facebook']")
	WebElement facebookIcon;

	@FindBy(xpath="//div[@class='header_block']/div/a[@class='twitter']")
	WebElement twitterIcon;

	@FindBy(xpath="//div[@class='header_block']/div/a[@class='linkedin']")
	WebElement linkedinIcon;
	
	@FindBy(xpath="//div[@class='block_frame block_frame_featured']//span[@class='maintext']")
	WebElement featuredProducts;
	
	@FindBy(xpath="//div[@class='block_frame block_frame_featured']//div[@class='col-md-3 col-sm-6 col-xs-12']")
	List<WebElement> featuredProductsList;
	
	@FindBy(xpath="//div[@class='fixed_wrapper']//a[@class='prdocutname']")
	List<WebElement> productsName;

	@FindBy(xpath="//section[@class='footersocial']")
	WebElement footerSection;
	
	@FindBy(xpath="//div[@id='block_frame_html_block_1775']/h2")
	WebElement AboutUs;
	
	@FindBy(xpath="//div[@id='block_frame_html_block_1775']/p")
	WebElement AboutUsInfo;
	
	@FindBy(xpath="//div[@id='block_frame_html_block_1776']/h2")
	WebElement ContactUs;
	
	@FindBy(xpath="//ul[@class='contact']/li")
	List<WebElement> contactUsInfo;
	
	@FindBy(xpath="//ul[@class='info_links_footer']/li")
	List<WebElement> footerLinks;
	
	@FindBy(xpath="//a[contains(@href,'manufacturer_id=')]")
	List<WebElement> brandLinks;
	
	
	
	TestUtil util;
	
	// Constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        util = new TestUtil(driver);
    }
	
	//Action Methods
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public List<String> validateWelcomeMenuList()
	{
		List<String> actualLinks=new ArrayList<>();
		if(welcomeBack.isDisplayed())
		{
			Actions ac=new Actions(driver);
			ac.moveToElement(welcomeBack).build().perform();
			
			WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(20));

	        wait.until(ExpectedConditions
	                .visibilityOfAllElements(menuList));
	        
			for(WebElement link:menuList)
			{
				String menu=link.getText();
				System.out.println(menu);
				
				if(!menu.isEmpty())
				{
					actualLinks.add(menu);
				}
			}
		}
		return actualLinks;
	}
	
	public List<String> validateHeaderMenu()
	{
		List<String> actualMenu=new ArrayList<>();
		
		for(WebElement menu:headerMenu)
		{
			String menuName=menu.getText();
			System.out.println(menuName);
			
			if(!menuName.isEmpty())
			{
				actualMenu.add(menuName);
			}
		}
		return actualMenu;
	}
	
	public List<String> validateSearchBarCategories()
	{
		List<String> actualCategories=new ArrayList<String>();
		if(searchBar.isDisplayed())
		{
			
			searchBar.click();
			WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(20));

	        wait.until(ExpectedConditions
	                .visibilityOfAllElements(searchCategories));
	        
			for(WebElement cat:searchCategories)
			{
				String categories=cat.getText();
				
				if(!categories.isEmpty())
				{
					actualCategories.add(categories);				}
					
			}
		}
		return actualCategories;
	}
	
	public List<String> validateCurrencyDropdown()
	{
		List<String> actualvalues=new ArrayList<String>();
		if(currencyDrop.isDisplayed())
		{
			
//			Actions ac=new Actions(driver);
//			ac.moveToElement(currencyDrop).perform();
			
			currencyDrop.click();
			
			WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(20));

	        wait.until(ExpectedConditions
	                .visibilityOfAllElements(currencyValues));
	        
			for(WebElement cat:currencyValues)
			{
				String values=cat.getText().trim();
				System.out.println(values);
				
				if(!values.isEmpty())
				{
					actualvalues.add(values);				}
					
			}
		}
		return actualvalues;
	}
	
	public void validateSocialMediaIcons() 
	{
		String parentId = driver.getWindowHandle();
		facebookIcon.click();
		
		 util.switchToChildWindow(parentId);

		 System.out.println("Facebook Title : " + driver.getTitle());

	        driver.close();

	        driver.switchTo().window(parentId);

	        // TWITTER
	        twitterIcon.click();

	        util.switchToChildWindow(parentId);

	        System.out.println("Twitter Title : " + driver.getTitle());

	        driver.close();

	        driver.switchTo().window(parentId);
	    }
		
		
	public boolean validateFeaturedProductsDisplayed()
	{
		logo.click();
		return featuredProducts.isDisplayed();
	}
		
	public int validateNoofProducts()
	{
		
		return featuredProductsList.size();
	}
	
	public void printFeaturedProducts()
	{
		
		for(WebElement product: productsName)
		{
			System.out.println("List of Products :" +product.getText());
		}
	}
	
	public boolean validateFooterSectionDisplayed()
	{
		logo.click();
		return footerSection.isDisplayed();
	}
	
	public String validateFooterAboutUsDisplayed()
	{
		String aboutusText="";
		logo.click();
		if(AboutUs.isDisplayed())
		{
			aboutusText=AboutUs.getText();
		}
		return aboutusText;
	}

	public String getFooterAbousUsInfo()
	{
		return AboutUsInfo.getText();
	}
	
	public String validateContactUsSectionDisplayed()
	{
		logo.click();
		String contactUsText="";
		if(ContactUs.isDisplayed())
		{
			contactUsText=ContactUs.getText();
		}
		return contactUsText;
	}
	
	public List<String> getContactUsDetails()
	{
		
		List<String> actualDetails=new ArrayList<String>();
		
		for(WebElement details:contactUsInfo)
		{
			String cDetails=details.getText().trim();
			
			if(!cDetails.isEmpty())
			{
				actualDetails.add(cDetails);
			}
		}
		return actualDetails;
	}
	
	public void validateFooterLinks()
	{
		int totalLinks=footerLinks.size();
		
		System.out.println("Total Footer Links : "+totalLinks);
		
		for(int i=0;i<totalLinks;i++)
		{
			// Re-locate elements after navigation
			footerLinks=driver.findElements(By.xpath("//div[@class='dropdown']/a"));
			
			String linkName=footerLinks.get(i).getText();
			System.out.println("Clicking Link : "
                    + linkName);
			
			 footerLinks.get(i).click();
			 
			// Print page title
	            System.out.println("Navigated Page : "
	                    + driver.getTitle());

	            // Navigate back
	            driver.navigate().back();
		}
	}
	
	public void checkBrandLinks()
	{
		logo.click();
		int totalbrands=brandLinks.size();
		System.out.println("Total no. of Brands :" +totalbrands);
		
		for(int i=0;i<totalbrands;i++)
		{
			brandLinks=driver.findElements(By.xpath("//a[contains(@href,'manufacturer_id=')]"));
			
			brandLinks.get(i).click();
			
			System.out.println("Page Title :"+driver.getTitle());
			
			driver.navigate().back();
		}
	}
	
	}

