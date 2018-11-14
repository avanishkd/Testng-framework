package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.mindtree.commonElements.CommonElements;

public class Product_Page extends CommonElements{

	protected static WebDriver driver;
	
	@FindBy(xpath = "//span[text() = 'ADD TO CART']/..")
	@CacheLookup
	protected static WebElement addBtn;
	
	
}
