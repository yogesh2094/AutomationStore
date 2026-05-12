package com.qa.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "D:\\Selenium\\edgedriver_win64\\msedgedriver.exe");

	    WebDriver driver = new EdgeDriver();

	    driver.get("https://google.com");

	}

}
