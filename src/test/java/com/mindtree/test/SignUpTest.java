package com.mindtree.test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.constants.Path;
import com.mindtree.constants.URL;
import com.mindtree.pageActions.Cart_Page_Action;
import com.mindtree.pageActions.Landing_Page_Action;
import com.mindtree.pageActions.Product_Page_Action;
import com.mindtree.pageActions.Products_Page_Action;
import com.mindtree.pageActions.SignIn_Page_Action;
import com.mindtree.pageActions.SignUp_Page_Action;
import com.mindtree.util.DriverUtil;
import com.mindtree.util.LogUtil;
import com.mindtree.util.RandomString;
import com.mindtree.util.ScreenShotUtil;
import com.mindtree.util.TimeStamp;
import com.mindtree.util.XLutil;

public class SignUpTest {

	static WebDriver driver;
	static Logger log;

	@DataProvider(name = "data")
	public static Object[][] dataProvider() throws EncryptedDocumentException, InvalidFormatException, IOException {
		XLutil ex = new XLutil();
		Object[][] ob = new Object[1][1];
		try {
			ob = ex.getInputsAsMap(Path.RESOURCES_FOLDER + "SignUpTest.xlsx");
		} catch (EncryptedDocumentException e) {
			log.fatal("Test data could not be read");
		} catch (InvalidFormatException e) {
			log.fatal("Test data could not be read");
		} catch (IOException e) {
			log.fatal("Test data could not be read");
		}
		return ob;
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			ScreenShotUtil.screenShot(Path.SCREEN_SHOT_FOLDER + TimeStamp.getTimeStamp(), driver);
		}
		log.info(result);
		driver.close();
	}

	@BeforeClass
	public static void beforeClass() {
		log = LogUtil.getLogger(SignUpTest.class, Path.LOG4J_PROPERTIES_FILE);
	}

	@BeforeMethod
	public static void beforeMethod() {
		driver = DriverUtil.openInChrome(URL.QA_URL);

	}

	@Test(dataProvider = "data")
	public void signUpTest(Map<String, String> data) throws InterruptedException, AWTException {
		try {
			Landing_Page_Action.setDriver(driver);
			Landing_Page_Action.clickLoginSignUp();
			Thread.sleep(2000);

			Landing_Page_Action.clickUserLoginBtn();

			Thread.sleep(2000);
			SignIn_Page_Action.setDriver(Landing_Page_Action.getDriver());
			SignIn_Page_Action.signUp();

			SignUp_Page_Action.setDriver(SignIn_Page_Action.getDriver());

			SignUp_Page_Action.setFirstName(data.get("fname"));
			log.info("First Name Entered: " + data.get("fname"));

			SignUp_Page_Action.setLastName(data.get("lname"));
			log.info("Last Name Entered: " + data.get("lname"));

			SignUp_Page_Action.setEmailId(RandomString.email());
			log.info("Email ID Entered: " + data.get("usname"));

			SignUp_Page_Action.setPassword(data.get("pwd"));
			log.info("Password Entered: " + data.get("pwd"));

			SignUp_Page_Action.setcPassword(data.get("pwd1"));
			log.info("Password reentered: " + data.get("pwd1"));

			SignUp_Page_Action.setPhone(data.get("pnum"));
			log.info("Phone number Entered: " + data.get("pnum"));

			SignUp_Page_Action.setDate(data.get("DOB"));
			log.info("DOB Entered: " + data.get("DOB"));

			if (data.get("gender").equals("M")) {
				SignUp_Page_Action.setGenderMale();
				log.info("Gender Entered: " + data.get("gender"));
			} else {
				SignUp_Page_Action.setGenderFemale();
				log.info("Gender Entered: " + data.get("gender"));
			}

			SignUp_Page_Action.setAddress(data.get("str"));
			log.info("Address Entered: " + data.get("str"));

			SignUp_Page_Action.setCityName(data.get("ct"));
			log.info("City Name Entered: " + data.get("ct"));

			SignUp_Page_Action.setStateName(data.get("st"));
			log.info("State name Entered: " + data.get("st"));

			SignUp_Page_Action.setPincode(data.get("pcode"));
//			SignUp_Page_Action.setPincode("abc");
			log.info("Pin code Entered: " + data.get("pcode"));

			SignUp_Page_Action.signUp();
			log.info("Sign up button clicked");

			Landing_Page_Action.setDriver(SignUp_Page_Action.getDriver());

			String expected = "";
			int i = 5;
			while (i-- > 0) {
				try {
					expected = Landing_Page_Action.getUserFName();
					break;
				} catch (Exception e) {
					log.info("loading page");
				}
			}
			Assert.assertEquals(expected, data.get("fname"));
			log.info("user logged in");

			Assert.assertTrue(Landing_Page_Action.clickAllProducts());

			Assert.assertTrue(Landing_Page_Action.goToCategory(data.get("Category")));

			Products_Page_Action.setDriver(Landing_Page_Action.getDriver());
			Products_Page_Action.clickProduct(2);

			Thread.sleep(2000);
			Product_Page_Action.setDriver(Products_Page_Action.getDriver());
			Product_Page_Action.addToCart();

			Cart_Page_Action.setDriver(Product_Page_Action.getDriver());
			Cart_Page_Action.Buy();

			Thread.sleep(3000);
		} catch (NullPointerException e) {
			log.fatal(e.getStackTrace());
			Assert.assertTrue(false);
		} catch (NoSuchElementException e) {
			log.fatal("The webelement could not be found");
			Assert.assertTrue(false);
		}
	}

}
