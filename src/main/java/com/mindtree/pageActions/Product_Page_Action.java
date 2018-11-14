package com.mindtree.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mindtree.pageObjects.Product_Page;

public class Product_Page_Action extends Product_Page {
	public static void setDriver(WebDriver driver) {
		PageFactory.initElements(driver, Product_Page.class);
		Product_Page.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static boolean addToCart() {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(addBtn));

			new Actions(driver).moveToElement(addBtn);
			addBtn.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
