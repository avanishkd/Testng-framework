package com.mindtree.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageObjects.Seller_SignUp_Page;

public class Seller_SignUp_Page_Action extends Seller_SignUp_Page{
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		PageFactory.initElements(driver, Seller_SignUp_Page_Action.class);
		Seller_SignUp_Page_Action.driver = driver;
	}

}
