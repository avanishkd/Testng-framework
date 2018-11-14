package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Seller_SignUp_Page {
	
	protected static WebDriver driver;
	
	@FindBy(xpath = "//label[text()='Seller Name']/..//input")
	@CacheLookup
	protected
	static WebElement firstName;

	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	protected
	static WebElement userName;
	
	@FindBy(xpath = "//label[text()='Password']/..//input")
	@CacheLookup
	protected
	static WebElement password;

	@FindBy(xpath = "//label[text()='Confirm-Password']/..//input")
	@CacheLookup
	protected
	static WebElement confirmPassword;
	
	@FindBy(xpath = "//label[text()='Pan Number']/..//input")
	@CacheLookup
	protected
	static WebElement pan;

	@FindBy(xpath= "//label[text()='GST Number(In Caps)']/..//input")
	@CacheLookup
	protected
	static WebElement gst;
	
	@FindBy(xpath= "//label[text()='Street']/..//input")
	@CacheLookup
	protected
	static WebElement street;
	
	@FindBy(xpath= "//label[text()='City']/..//input")
	@CacheLookup
	protected
	static WebElement city;
	
	@FindBy(xpath= "//label[text()='State']/..//input")
	@CacheLookup
	protected
	static WebElement state;
	
	@FindBy(xpath= "//label[text()='Pincode']/..//input")
	@CacheLookup
	protected
	static WebElement pinCode;
	
	@FindBy(xpath= "//span[text()='Sign Up']/..")
	@CacheLookup
	protected
	static WebElement signUp;
	
	

}
