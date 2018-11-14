package com.mindtree.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtil {
	
	/**
	 * 
	 * @param c - class for which logger is to be initialized
	 * @param path - path of the log4j properties file
	 * @return - returns a Logger object
	 */
	public static Logger getLogger(Class<?> c, String path) {

		PropertyConfigurator.configure(path);

		return Logger.getLogger(c);
	}

}
