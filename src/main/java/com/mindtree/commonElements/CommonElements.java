package com.mindtree.commonElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CommonElements {
	
	@FindBy(xpath = "//button[text()='Login']")
	@CacheLookup
	protected static WebElement login_SignUp_Btn;
	
	@FindBy(xpath = "//i[text() = 'furnique']/../..")
	@CacheLookup
	protected static WebElement furnique;

}
