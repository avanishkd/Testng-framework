package com.mindtree.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageObjects.Cart_Page;

public class Cart_Page_Action extends Cart_Page {
	
	public static void setDriver(WebDriver driver) {
		PageFactory.initElements(driver, Cart_Page.class);
		Cart_Page.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static boolean Buy() {
		try{
			buyBtn.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public static void remove(int i) {
		products.get(i).click();
	}
	
	public static boolean placeOrder() {
		try {
			driver.switchTo().activeElement();
			PageFactory.initElements(driver, Cart_Page_Action.class);
			placeOrderBtn.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean clickHelloUser() {
		try {
			helloUser.click();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean logOut() {
		try {
			logout.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
