package com.mindtree.pageActions;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageObjects.SignUp_Page;
import com.mindtree.util.RobotUtil;

public class SignUp_Page_Action extends SignUp_Page {

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		SignUp_Page_Action.driver = driver;
		PageFactory.initElements(driver, SignUp_Page_Action.class);
	}

	public static boolean setFirstName(String fname) throws AWTException {
		try {
			RobotUtil.clickElement(firstName);
			firstName.sendKeys(fname);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean setLastName(String lname) {
		try {
			lastname.sendKeys(lname);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setEmailId(String usname) {
		try {
			userName.sendKeys(usname);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setPassword(String pwd) {
		try {
			password.sendKeys(pwd);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setcPassword(String pwd) {
		try {
			confirmPassword.sendKeys(pwd);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setPhone(String pnum) {
		try {
			phone.sendKeys(pnum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setDate(String DOB) {
		try {
			date.sendKeys(DOB);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setGenderMale() {
		try {
			genderMale.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setGenderFemale() {
		try {
			genderFemale.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setAddress(String str) {
		try {
			street.sendKeys(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setCityName(String ct) {
		try {
			city.sendKeys(ct);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setStateName(String st) {
		try {
			state.sendKeys(st);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean setPincode(String pcode) {
		try {
			postalCode.sendKeys(pcode);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean signUp() {
		try {
			register.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
