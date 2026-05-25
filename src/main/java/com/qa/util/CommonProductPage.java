package com.qa.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonProductPage {
	
	WebDriver driver;
	//@FindBy(xpath="//td[@class='align_left']/a")
	//List<WebElement> allProducts;
	
	//table[@id='totals_table']/tbody/tr[3]/td[2]
	
	//table[@class='table table-striped table-bordered']/tbody/tr[3]/td[2]
	
	public CommonProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Action Methods
	
	public List<String> getAllProductsNames(List<WebElement> elements)
	{
		List<String> products=new ArrayList<>();
		
//		WebDriverWait wait =
//                new WebDriverWait(driver,
//                        Duration.ofSeconds(20));
//
//        wait.until(ExpectedConditions
//                .visibilityOfAllElements(elements));

		
		for(WebElement product:elements)
		{
			System.out.println(product.getText().trim());
			products.add(product.getText().trim());
		}
		return products;
	}
	
	public double getProductPriceTotal(WebElement element)
	{
		String amount=element.getText().trim();
		amount=amount.replace("$", "").replace(",", "");
		double total=Double.parseDouble(amount);
		return total;
	}
	
	public int getAllProductsList(List<WebElement> elements)
	{
		List<String> products=new ArrayList<>();
		int noOfRows=0;
		for(int i=1;i<elements.size();i++) //Rows
		{
			System.out.println(noOfRows);
		}
		
		return noOfRows;
	}
	

}
