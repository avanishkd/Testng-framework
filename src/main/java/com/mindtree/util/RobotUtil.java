package com.mindtree.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class RobotUtil {
	
	public static void clickElement(WebElement e) throws AWTException {
		Point coordinates = e.getLocation();
		Robot robot = new Robot();
		robot.mouseMove(coordinates.getX()+15, coordinates.getY()+125);
		
		int mask = InputEvent.BUTTON1_DOWN_MASK;
		
		robot.mousePress(mask);
		robot.mouseRelease(mask);
	}

}
