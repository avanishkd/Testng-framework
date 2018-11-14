package com.mindtree.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageObjects.Products_Page;

public class Products_Page_Action extends Products_Page{
	
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		PageFactory.initElements(driver, Products_Page.class);
		Products_Page.driver = driver;
	}
	
	public static boolean clickProduct(int i) {
		try{
			products.get(i).click();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}


}
