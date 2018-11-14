package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignIn_Page {

	@FindBy(xpath = "//input[@id = 'name']")
	@CacheLookup
	protected static WebElement usrNm;

	@FindBy(xpath = "//input[@id = 'password']")
	@CacheLookup
	protected static WebElement password;

	@FindBy(xpath = "//span[text() = 'Login']/..")
	@CacheLookup
	protected static WebElement loginBtn;

	@FindBy(xpath = "//span[text() = 'New to Furnique? Sign Up']/..")
	@CacheLookup
	protected static WebElement signUp;
	
	@FindBy(xpath = "//a[@href='/sellersignup']")
	@CacheLookup
	protected static WebElement sellerSignUp;

	protected static WebDriver driver;

}
