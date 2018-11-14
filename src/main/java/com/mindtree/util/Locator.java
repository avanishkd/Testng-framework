package com.mindtree.util;

import org.openqa.selenium.By;

public class Locator {

	public static By getLocator(String locator, String value) {

		if (("xpath").equalsIgnoreCase(locator)) {
			return By.xpath(value);
		} else if (("id").equalsIgnoreCase(locator)) {
			return By.id(value);
		} else if (("className").equalsIgnoreCase(locator)) {
			return By.className(value);
		} else if (("cssSelector").equalsIgnoreCase(locator)) {
			return By.cssSelector(value);
		} else if (("linkText").equalsIgnoreCase(locator)) {
			return By.linkText(value);
		} else if (("partialLinkText").equalsIgnoreCase(locator)) {
			return By.partialLinkText(value);
		} else if (("name").equalsIgnoreCase(locator)) {
			return By.name(value);
		} else {
			return By.tagName(value);
		}
	}

}
