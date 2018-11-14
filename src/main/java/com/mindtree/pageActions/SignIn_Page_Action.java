package com.mindtree.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageObjects.SignIn_Page;

public class SignIn_Page_Action extends SignIn_Page {

	public static void setDriver(WebDriver driver) {
		driver.switchTo().activeElement();
		SignIn_Page.driver = driver;
		PageFactory.initElements(driver, SignIn_Page.class);

	}

	public static WebDriver getDriver() {
		driver.switchTo().activeElement();
		return driver;
	}

	public static boolean setUserName(Object object) {
		try {
			usrNm.sendKeys((String) object);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setPassword(Object pwd) {
		try {
			password.sendKeys((String) pwd);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean logIn() {
		try {
			loginBtn.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean signUp() {
		try {
			signUp.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean sellerSignUp() {
		try {
			sellerSignUp.click();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
