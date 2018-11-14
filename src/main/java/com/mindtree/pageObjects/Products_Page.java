package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.mindtree.commonElements.CommonElements;

public class Products_Page extends CommonElements{
	
	protected static WebDriver driver;
	
	@FindBy(xpath = "//span[text() = 'View Product']/..")
	@CacheLookup
	protected static List<WebElement> products;
	
	@FindBy(xpath = "//a[@title = 'Log In']")
	@CacheLookup
	protected static WebElement login_SignUp_Btn;
	
	@FindBy(xpath = "//a[@href = '/cart']")
	@CacheLookup
	protected static WebElement cartBtn;

}
