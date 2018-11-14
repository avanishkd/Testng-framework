package com.mindtree.pageActions;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageObjects.Admin_Products_Tab;

public class Admin_Products_Action extends Admin_Products_Tab {

	/**
	 * 
	 * @param driver
	 *            - WebDriver is passed to set driver of this class PageFactory is
	 *            used to initialize WebElements
	 */
	public static void setDriver(WebDriver driver) {
		Admin_Products_Action.driver = driver;
		PageFactory.initElements(driver, Admin_Products_Action.class);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * 
	 * @param i
	 *            - 'i'th product is deleted
	 */
	public static boolean deleteProduct(int i) {
		try {
			products.get(i).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * this method is invoked for clicking on the add products button on click a
	 * form is displayed
	 */
	public static boolean addProduct() {
		try {
			addProduct.click();
			driver.switchTo().activeElement();
			PageFactory.initElements(driver, Add_Product_Form.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param title
	 *            - title string is passed
	 */
	public static boolean setTitle(String title) {
		try {
			Add_Product_Form.titleTxtBx.sendKeys(title);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param desc
	 *            - description string is passed
	 */
	public static void setDescription(String desc) {
		Add_Product_Form.descriptionTxtBx.sendKeys(desc);
	}

	/**
	 * 
	 * @param ammt
	 *            - amount string
	 */
	public static void setAmmount(String ammt) {
		Add_Product_Form.ammontTxtBx.sendKeys(ammt);
	}

	/**
	 * 
	 * @param clr
	 *            - color string is passed
	 * @throws AWTException
	 */
	public static boolean setColour(String clr) throws AWTException {

		try {
			Add_Product_Form.colorsDrpDwn.click();

			// RobotUtil.clickElement(driver.findElement(By.xpath("//li[text() =
			// '"+clr+"']/span")));

			driver.findElement(By.xpath("//li[text() = '" + clr + "']")).click();

			// Add_Product_Form.driver.switchTo().activeElement().findElement(By.xpath("//li[text()
			// = '"+clr+"']/span")).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param mtrl
	 *            - Material string is passed
	 * @throws AWTException
	 */
	public static void setMaterial(String mtrl) throws AWTException {

		Add_Product_Form.materialTxtBx.sendKeys(mtrl);
	}

	/**
	 * 
	 * @param wt
	 *            - Weight string is passed
	 * @throws AWTException
	 */
	public static void setWeight(String wt) throws AWTException {

		Add_Product_Form.weightTxtBx.sendKeys(wt);
	}

	/**
	 * 
	 * @param l
	 *            - Length string is passed
	 * @throws AWTException
	 */
	public static void setLength(String l) throws AWTException {

		Add_Product_Form.lengthTxtBx.sendKeys(l);
	}

	/**
	 * 
	 * @param h
	 *            - Height string is passed
	 * @throws AWTException
	 */
	public static void setHeight(String h) throws AWTException {

		Add_Product_Form.heightTxtBx.sendKeys(h);
	}

	/**
	 * 
	 * @param b
	 *            - Breadth string is passed
	 * @throws AWTException
	 */
	public static void setBreadth(String b) throws AWTException {

		Add_Product_Form.breadthTxtbx.sendKeys(b);
	}

	/**
	 * 
	 * @param ctgry
	 *            - Category string is passed
	 */
	public static void setCategory(String ctgry) {
		for (WebElement e : Add_Product_Form.categoryRadioBtn) {
			if (e.getAttribute("value").equalsIgnoreCase(ctgry)) {
				new Actions(driver).moveToElement(e);
				e.click();
			}
		}
	}

	public static void add() throws AWTException, InterruptedException {

		Thread.sleep(2000);
		Add_Product_Form.add.click();

	}

	public static void setQuantity(String q) {
		Add_Product_Form.quantityTxtBx.sendKeys(Math.round(Double.parseDouble(q)) + "");
	}

}
