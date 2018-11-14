package com.mindtree.util;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mindtree.constants.Path;
import com.mindtree.constants.URL;

public class DriverUtil {

	public static WebDriver openInChrome(String url) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", Path.CHROME_DRIVER);
		WebDriver driver = new ChromeDriver(options);

		driver.get(url);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public static WebDriver openInIE(String url) {

		System.setProperty("webdriver.ie.driver", Path.IE_DRIVER);
		WebDriver driver = new InternetExplorerDriver();

		driver.get(url);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public static WebDriver openInRemoteChrome(String url) throws MalformedURLException {
		String hub = "http://172.17.124.134:4444/wd/hub";
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		WebDriver driver = new RemoteWebDriver(new java.net.URL(hub), dc);
		driver.get(URL.QA_URL);
		return driver;
	}
}
