package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.mindtree.commonElements.CommonElements;

public class SignUp_Page extends CommonElements{
	
	protected static WebDriver driver;

	@FindBy(xpath = "//label[text()='First Name']/..//input")
	@CacheLookup
	protected
	static WebElement firstName;

	@FindBy(xpath = "//label[text()='Last Name']/..//input")
	@CacheLookup
	protected
	static WebElement lastname;

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
	
	@FindBy(xpath = "//label[text()='10 digit Mobile Number']/..//input")
	@CacheLookup
	protected
	static WebElement phone;

	@FindBy(xpath="//input[@type='date']")
	@CacheLookup
	protected
	static WebElement date;
	
	@FindBy(xpath="//input[@value='Male']")
	@CacheLookup
	protected
	static WebElement genderMale;
	
	@FindBy(xpath="//input[@value='Female']")
	@CacheLookup
	protected
	static WebElement genderFemale;

	@FindBy(xpath = "//label[text()='Street']/..//input")
	@CacheLookup
	protected
	static WebElement street;
	
	@FindBy(xpath = "//label[text()='City']/..//input")
	@CacheLookup
	protected
	static WebElement city;

	@FindBy(xpath = "//label[text()='State']/..//input")
	@CacheLookup
	protected
	static WebElement state;

	@FindBy(xpath = "//label[text()='Pincode']/..//input")
	@CacheLookup
	protected
	static WebElement postalCode;	

	@FindBy(xpath = "//span[contains(text(),'Sign Up')]")
	@CacheLookup
	protected
	static WebElement register;

}
