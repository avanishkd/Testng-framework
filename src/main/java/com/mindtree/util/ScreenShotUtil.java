package com.mindtree.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {
	
	private static String path;
	
	public static void screenShot(String path, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File srcFile = ss.getScreenshotAs(OutputType.FILE);

		System.out.println(path + ".png");

		File destFile = new File(path + ".png");
		FileUtils.copyFile(srcFile, destFile);
		
		ScreenShotUtil.path = destFile.getPath();
		System.out.println(ScreenShotUtil.path);
	}
	
	public static String getPath() {
		return path;
	}
	
	public static String getSnapName() {
		return path.substring(5);
	}

}
