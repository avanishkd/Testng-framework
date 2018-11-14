package com.mindtree.test;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import javax.swing.JProgressBar;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import com.mindtree.pageActions.Admin_Page_Action;
import com.mindtree.pageActions.Admin_Products_Action;
import com.mindtree.pageActions.Cart_Page_Action;
import com.mindtree.pageActions.Landing_Page_Action;
import com.mindtree.pageActions.Product_Page_Action;
import com.mindtree.pageActions.Products_Page_Action;
import com.mindtree.pageActions.SignIn_Page_Action;
import com.mindtree.pageActions.SignUp_Page_Action;
import com.mindtree.util.DriverUtil;
import com.mindtree.util.LogUtil;
import com.mindtree.util.ProgressBar;
import com.mindtree.util.RandomString;
import com.mindtree.util.ScreenShotUtil;
import com.mindtree.util.TimeStamp;
import com.mindtree.util.XLutil;

public class EndToEnd {
	private static WebDriver driver;
	private static Logger log;
	private static JProgressBar bar;

	@Test(dataProvider = "dp")
	public void endToEndTest(Map<String, String> data) throws InterruptedException, IOException, AWTException {

		bar = new ProgressBar(data.get("TC")).getBar();

		String title = RandomString.string();

		Landing_Page_Action.setDriver(driver);

		if (!Landing_Page_Action.clickLoginSignUp()) {
			log.error("Login/Sign up button not clicked");
			Assert.assertTrue(false);
		}
		bar.setValue(10);

		if (!Landing_Page_Action.clickAdminLoginBtn()) {
			log.error("Admin log in button not clicked");
			Assert.assertTrue(false);
		}
		bar.setValue(bar.getValue() + 10);
		SignIn_Page_Action.setDriver(Landing_Page_Action.getDriver());

		if (!SignIn_Page_Action.setUserName(data.get("UserName"))) {
			log.error("User name not set");
			Assert.assertTrue(false);
		}
		if (!SignIn_Page_Action.setPassword(data.get("Password"))) {
			log.error("Password not set");
			Assert.assertTrue(false);
		}
		if (!SignIn_Page_Action.logIn()) {
			log.error("Login button not clicked");
			Assert.assertTrue(false);
		}

		int i = 5;
		while (i-- > 0) {
			Admin_Page_Action.setDriver(SignIn_Page_Action.getDriver());
			if (Admin_Page_Action.goToProductsTab()) {
				break;
			}
			log.info("Loading page");
		}
		
		
		i = 200;
		Admin_Products_Action.setDriver(Admin_Page_Action.getDriver());
		while (!Admin_Products_Action.addProduct() && i-- >0) {
			log.info("loading");
		}

		try {
			System.out.println(title);
			Admin_Products_Action.setTitle(title);
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		try {
			Admin_Products_Action.setDescription(data.get("Description"));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		try {
			Admin_Products_Action.setAmmount(data.get("Amount"));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		try {
			Admin_Products_Action.setCategory(data.get("Category"));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}

		try {
			Admin_Products_Action.setQuantity(data.get("Quantity"));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}

		try {
			Admin_Products_Action.setMaterial(data.get("Material"));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		try {
			Admin_Products_Action.setWeight(data.get("Weight"));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		try {
			Admin_Products_Action.setLength(data.get("Length"));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		try {
			Admin_Products_Action.setBreadth(data.get("Breadth"));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		try {
			Admin_Products_Action.setHeight(data.get("Height"));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}

		try {
			Admin_Products_Action.setColour(data.get("Colour"));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		try {
			Admin_Products_Action.add();
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		Assert.assertTrue(Admin_Page_Action.logout(), "Logout not clicked");

		Assert.assertTrue(Landing_Page_Action.clickLoginSignUp(), "Login drop down not clicked");

		Assert.assertTrue(Landing_Page_Action.clickUserLoginBtn(), "user login not clicked");

		SignIn_Page_Action.setDriver(driver);

		Assert.assertTrue(SignIn_Page_Action.signUp(), "Sign up option not clicked");

		SignUp_Page_Action.setDriver(driver);

		Thread.sleep(2000);

		Assert.assertTrue(SignUp_Page_Action.setFirstName(data.get("fname")), "First name not entered");

		Assert.assertTrue(SignUp_Page_Action.setLastName(data.get("lname")), "last name not entered");

		String email = RandomString.email();

		Assert.assertTrue(SignUp_Page_Action.setEmailId(email), "User name not entered");

		Assert.assertTrue(SignUp_Page_Action.setPassword(data.get("pwd")), "Password not entered");

		Assert.assertTrue(SignUp_Page_Action.setcPassword(data.get("pwd1")), "Password not reentered");

		Assert.assertTrue(SignUp_Page_Action.setPhone(data.get("pnum")), "Phone no. not entered");

		Assert.assertTrue(SignUp_Page_Action.setDate(data.get("DOB")), "DOB not entered");

		if (data.get("gender").equals("M")) {
			Assert.assertTrue(SignUp_Page_Action.setGenderMale(), "Gender not entered");
		} else {
			Assert.assertTrue(SignUp_Page_Action.setGenderFemale(), "Gender not entered");
		}

		Assert.assertTrue(SignUp_Page_Action.setAddress(data.get("str")), "Address not entered");

		Assert.assertTrue(SignUp_Page_Action.setCityName(data.get("ct")), "City name not entered");

		Assert.assertTrue(SignUp_Page_Action.setStateName(data.get("st")), "State name not entered");

		Assert.assertTrue(SignUp_Page_Action.setPincode(data.get("pcode")), "pin code not entered");

		Assert.assertTrue(SignUp_Page_Action.signUp(), "Sign up not clicked");

		Landing_Page_Action.setDriver(driver);

		Assert.assertTrue(Landing_Page_Action.clickHelloUser(), "hello user button not clicked");

		Assert.assertTrue(Landing_Page_Action.logOut(), "Log out not clicked");

		Assert.assertTrue(Landing_Page_Action.clickLoginSignUp(), "Login drop down not clicked");

		Assert.assertTrue(Landing_Page_Action.clickUserLoginBtn());

		SignIn_Page_Action.setDriver(driver);

		Assert.assertTrue(SignIn_Page_Action.setUserName(email));

		Assert.assertTrue(SignIn_Page_Action.setPassword(data.get("pwd")));

		Assert.assertTrue(SignIn_Page_Action.logIn());

		i = 10;
		boolean flag = false;
		while (!flag && i-- > 0) {
			flag = Landing_Page_Action.setSerchValue(title);
			Thread.sleep(500);
		}

		Assert.assertTrue(flag, "search value not entered");

		Assert.assertTrue(Landing_Page_Action.clickSearch());

		i = 10;
		flag = false;
		while (!flag && i-- > 0) {
			log.info("Finding element");
			Products_Page_Action.setDriver(driver);
			flag = Products_Page_Action.clickProduct(0);
			Thread.sleep(500);
		}

		Assert.assertTrue(flag, "View product not clicked");

		Product_Page_Action.setDriver(driver);

		i = 10;
		flag = false;
		while (!flag && i-- > 0) {
			log.info("Finding element");
			Product_Page_Action.setDriver(driver);
			flag = Product_Page_Action.addToCart();
			Thread.sleep(500);
		}

		Assert.assertTrue(flag, "Add to cart not clicked");

		i = 10;
		flag = false;
		while (!flag && i-- > 0) {
			log.info("Finding element");
			Cart_Page_Action.setDriver(Product_Page_Action.getDriver());
			flag = Cart_Page_Action.Buy();
			Thread.sleep(500);
		}

		Assert.assertTrue(flag, "Buy not clicked");

		Assert.assertTrue(Cart_Page_Action.placeOrder(), "Place order not clicked");

		Thread.sleep(2000);
		Assert.assertTrue(Cart_Page_Action.clickHelloUser(), "Hello user drop down not clicked");

		Assert.assertTrue(Cart_Page_Action.logOut(), "User not logged out");

		bar.setValue(100);

	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		driver = DriverUtil.openInChrome(URL.QA_URL);

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(!result.isSuccess()) {
			ScreenShotUtil.screenShot(Path.SCREEN_SHOT_FOLDER + TimeStamp.getTimeStamp(), driver);
		}
		log.info(result);
		driver.close();
	}

	@DataProvider
	public Object[][] dp() throws EncryptedDocumentException, InvalidFormatException, IOException {
		XLutil excel = new XLutil();
		return excel.getInputsAsMap(Path.RESOURCES_FOLDER + "EndToEnd.xlsx");
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		// KillProcess.killAll();
		log = LogUtil.getLogger(EndToEnd.class, Path.LOG4J_PROPERTIES_FILE);
	}

}
