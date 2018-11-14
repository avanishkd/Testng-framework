package com.mindtree.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageObjects.Landing_Page;

public class Landing_Page_Action extends Landing_Page {

	public static void setDriver(WebDriver driver) {
		PageFactory.initElements(driver, Landing_Page.class);
		Landing_Page.driver = driver;

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static boolean setSerchValue(String s) {
		try {
			searchBar.sendKeys(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean clickSearch() {
		try {
			searchBtn.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean clickLoginSignUp() {
		try {
			login_SignUp_Btn.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean rotateRightCarousel() {
		try {
			carRotateRightBtn.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean rotateLeftCarousel() {
		try {
			carRotateLeftBtn.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean clickFromCarousel() {
		try {
			carousalItem.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean clickAllProducts() {
		try {
			allProductsDrpDwnBtn.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean clickRegister() {
		try {
			open.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean goToCategory(String category) {
		try {
			for (WebElement cat : allProducts) {
				if (category.equalsIgnoreCase(cat.getText())) {
					cat.click();
					return true;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean clickAdminLoginBtn() {
		try {
			adminLoginBtn.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean clickUserLoginBtn() {
		try {
			userLoginBtn.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String getUserFName() {

		return userBtn.getText().substring(6);

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
