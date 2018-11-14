package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.mindtree.commonElements.CommonElements;

public class Admin_Users_Tab extends CommonElements{
	
	protected static WebDriver driver;
	
	@FindBy(xpath = "//div[@class  = 'jss41 jss80 jss102']/div")
	@CacheLookup
	protected static List<WebElement> users;

}
