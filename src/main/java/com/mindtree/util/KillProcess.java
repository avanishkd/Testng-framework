package com.mindtree.util;

import java.io.IOException;

public class KillProcess {
	
	/**
	 *Kills the processes in task manager
	 * @throws IOException
	 */
	public static void killAll() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		Runtime.getRuntime().exec("taskkill /F /IM EXCEL.EXE");
		Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
	}

}
