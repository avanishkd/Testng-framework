package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.mindtree.commonElements.CommonElements;

public class Cart_Page extends CommonElements{
	
	protected static WebDriver driver;
	
	@FindBy(xpath = "//button[text() = 'Buy Now']")
	@CacheLookup
	protected static WebElement buyBtn;
	
	@FindBy(xpath = "//span[text() = 'Remove']")
	@CacheLookup 
	protected static List<WebElement> products;
	
	@FindBy(xpath = "//button[text() = 'PLACE ORDER']")
	@CacheLookup
	protected static WebElement placeOrderBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Hello')]/../..")
	@CacheLookup
	protected static WebElement helloUser;
	
	@FindBy(xpath = "//a[text() = 'Logout']")
	@CacheLookup
	protected static WebElement logout;
	
}
