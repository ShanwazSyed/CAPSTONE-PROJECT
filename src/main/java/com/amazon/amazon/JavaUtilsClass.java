package com.amazon.amazon;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

public class JavaUtilsClass {
	String projectDir = System.getProperty("user.dir");
	
	public void captureScreenshot(WebDriver driver)
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		long timestamp = System.currentTimeMillis();
		String destFilePath = projectDir +"/Reports/Screenshots"+timestamp+".png";
		File destFile = new File(destFilePath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

}
