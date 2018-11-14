package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.mindtree.commonElements.CommonElements;

public class Admin_Products_Tab extends CommonElements{

	protected static WebDriver driver;

	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	@CacheLookup
	protected static List<WebElement> products;

	@FindBy(xpath = "//button[@aria-label = 'Add']")
	@CacheLookup
	protected static WebElement addProduct;

	/**
	 * 
	 * @author m1046875
	 *
	 */
	public static class Add_Product_Form {

		public static WebDriver driver;

		@FindBy(xpath = "//input[@id = 'Title']")
		@CacheLookup
		public static WebElement titleTxtBx;

		@FindBy(xpath = "//textarea[@type = 'textarea']")
		@CacheLookup
		public static WebElement descriptionTxtBx;

		@FindBy(xpath = "//input[@id = 'product price']")
		@CacheLookup
		public static WebElement ammontTxtBx;

		@FindBy(xpath = "//label[contains(text(),'Colour')]/..//input")
		@CacheLookup
		public static WebElement colourTxtBx;

		@FindBy(xpath = "//label[contains(text(),'Material')]/..//input")
		@CacheLookup
		public static WebElement materialTxtBx;

		@FindBy(xpath = "//label[contains(text(),'Weight')]/..//input")
		@CacheLookup
		public static WebElement weightTxtBx;

		@FindBy(xpath = "//label[contains(text(),'Length')]/..//input")
		@CacheLookup
		public static WebElement lengthTxtBx;

		@FindBy(xpath = "//label[contains(text(),'Breadth')]/..//input")
		@CacheLookup
		public static WebElement breadthTxtbx;

		@FindBy(xpath = "//label[contains(text(),'Height')]/..//input")
		@CacheLookup
		public static WebElement heightTxtBx;

		@FindBy(xpath = "//div[@role = 'radiogroup']//input[@type = 'radio']")
		@CacheLookup
		public static List<WebElement> categoryRadioBtn;
		
		@FindBy(xpath = "//span[text() = 'Add']/..")
		@CacheLookup
		public static WebElement add;
		
		@FindBy(xpath = "//em[text()='Select Colour *']")
		@CacheLookup
		public static WebElement colorsDrpDwn;
		
		@FindBy(xpath = "//label[text()='Quantity (Max 2 characters) *']/..//input")
		@CacheLookup 
		public static WebElement quantityTxtBx;
	}

}
