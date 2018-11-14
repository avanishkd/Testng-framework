package com.mindtree.test;

import java.io.IOException;
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
import com.mindtree.pageActions.Landing_Page_Action;
import com.mindtree.pageActions.SignIn_Page_Action;
import com.mindtree.util.DriverUtil;
import com.mindtree.util.LogUtil;
import com.mindtree.util.ProgressBar;
import com.mindtree.util.RandomString;
import com.mindtree.util.ScreenShotUtil;
import com.mindtree.util.TimeStamp;
import com.mindtree.util.XLutil;

public class AdminTest {

	private static WebDriver driver;
	private static Logger log;
	private static JProgressBar bar;

	@Test(dataProvider = "dp")
	public void adminTest(Map<String, String> data) throws InterruptedException, IOException {

		bar = new ProgressBar(data.get("TC")).getBar();

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

		while (true) {
			Admin_Page_Action.setDriver(SignIn_Page_Action.getDriver());
			if (Admin_Page_Action.goToProductsTab()) {
				break;
			}
			log.info("Loading page");
		}
		
		Admin_Products_Action.setDriver(Admin_Page_Action.getDriver());
		while (!Admin_Products_Action.addProduct()) {
			log.info("loading");
		}

		try {
			String title = RandomString.string();
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
		
		Assert.assertTrue(Admin_Page_Action.logout(),"Logout not clicked");

		bar.setValue(100);

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = DriverUtil.openInChrome(URL.QA_URL);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(!result.isSuccess()) {
			ScreenShotUtil.screenShot(Path.SCREEN_SHOT_FOLDER + TimeStamp.getTimeStamp(),driver);
		}
		log.info(result);
		driver.close();
	}

	@DataProvider
	public Object[][] dp() throws EncryptedDocumentException, InvalidFormatException, IOException {
		XLutil excel = new XLutil();
		return excel.getInputsAsMap(Path.RESOURCES_FOLDER + "AddProductTestData.xlsx");
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		// KillProcess.killAll();
		log = LogUtil.getLogger(AdminTest.class, Path.LOG4J_PROPERTIES_FILE);
	}


}
