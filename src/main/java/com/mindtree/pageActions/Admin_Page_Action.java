package com.mindtree.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageObjects.Admin_Page;

public class Admin_Page_Action extends Admin_Page {

	public static void setDriver(WebDriver driver) {
		Admin_Page_Action.driver = driver;
		PageFactory.initElements(driver, Admin_Page_Action.class);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static boolean goToUsersTab() {
		try {
			usersTab.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean goToProductsTab() {
		try {
			productsTab.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean goToDashBoard() {
		try {
			dashBoard.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean logout() {
		try {
			Thread.sleep(2000);
			logoutBtn.click();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
