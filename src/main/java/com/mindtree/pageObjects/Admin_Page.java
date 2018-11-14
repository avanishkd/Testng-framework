package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.mindtree.commonElements.CommonElements;

public class Admin_Page extends CommonElements{
	
	protected static WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'User')]/../../..")
	@CacheLookup
	protected static WebElement usersTab;
	
	@FindBy(xpath = "//span[text()='Products']/../../..")
	@CacheLookup
	protected static WebElement productsTab;
	
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]/../../..")
	@CacheLookup
	protected static WebElement dashBoard;
	
	@FindBy(xpath = "//span[text() = 'Logout']/..")
	@CacheLookup
	protected static WebElement logoutBtn;

}
