package com.qa.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.RegisterPage;
import com.qa.util.ExcelUtils;





public class RegisterTest extends TestBase {
	
	
	RegisterTest()
	{
		super();
	}
	
	
	
   
    
    @Test(dataProvider = "registerData")
    public void testRegisterForm(String fn, String ln, String email, String number, String add, String city1,String postcode1, 
			String nlogin, String pass, String cpass ) {
    	
    	RegisterPage rpage = new RegisterPage(getDriver());

    	rpage.registerUser(fn, ln, email, number, add, city1, postcode1, nlogin, pass, cpass);
    	
    	System.out.println("Registration form Filled for : "+fn);
    }
    
    @DataProvider(name="registerData")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getExcelData("C:\\Users\\dell\\Desktop\\AutomationRegister.xlsx", "Testing");
    }
}
