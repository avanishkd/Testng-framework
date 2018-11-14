package com.mindtree.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
	
	public static String email() {
		return "a"+RandomStringUtils.randomAlphanumeric(3,6)+"@gmail.com";
	}
	
	public static String string() {
		return RandomStringUtils.randomAlphanumeric(3,6);
	}
}
