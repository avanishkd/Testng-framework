package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.mindtree.commonElements.CommonElements;

public class Landing_Page extends CommonElements{

	@FindBy(xpath = "//input[@id = 'search']")
	@CacheLookup
	protected
	static WebElement searchBar;

	@FindBy(xpath = "//div[@class = 'input-group-append']")
	@CacheLookup
	protected static WebElement searchBtn;

	@FindBy(xpath = "//div[@class = 'jss9 jss13 jss10']//a[@class = 'carousel-control-next']")
	@CacheLookup
	protected static WebElement carRotateRightBtn;

	@FindBy(xpath = "//div[@class = 'jss9 jss13 jss10']//a[@class = 'carousel-control-prev']")
	@CacheLookup
	protected static WebElement carRotateLeftBtn;

	@FindBy(xpath = "//div[@class = 'carousel-item active']/div")
	@CacheLookup
	protected static WebElement carousalItem;

	@FindBy(xpath = "//button[@class = 'btn btn-primary dropdown-toggle']")
	@CacheLookup
	protected static WebElement allProductsDrpDwnBtn;

	@FindBy(xpath = "//a[@class = 'dropdown-item']")
	@CacheLookup
	protected static List<WebElement> allProducts;

	@FindBy(xpath = "//a[@href = '/cart']")
	@CacheLookup
	protected static WebElement cartBtn;

	@FindBy(xpath = "//td[@class='mouseOut'][2]")
	@CacheLookup
	protected static WebElement open;

	@FindBy(xpath = "//a[text()='Seller']")
	@CacheLookup
	protected static WebElement adminLoginBtn;
	
	@FindBy(xpath = "//a[text()='User']")
	@CacheLookup
	protected static WebElement userLoginBtn;
	
	@FindBy(xpath = "//span[@style='margin-left: 4px;']")
	@CacheLookup
	protected static WebElement userBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Hello')]/../..")
	@CacheLookup
	protected static WebElement helloUser;
	
	@FindBy(xpath = "//a[text() = 'Logout']")
	@CacheLookup
	protected static WebElement logout;

	protected static WebDriver driver;

}
