package com.amazon.tests;

import java.util.concurrent.TimeUnit;

//import org.apache.commons.csv.CSVParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.amazon.JavaUtilsClass;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.amazon.amazon.*;
import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.ArrayList;


public class TestClass extends JavaUtilsClass {
	WebDriver driver;
	String projectDir = System.getProperty("user.dir");
	
//	@BeforeClass
////	public void readCSVData()
//	{
//		String filePath = projectDir+"/Data.csv";
//		List<String[]> data = new ArrayList<>();
//		// Java code to illustrate 
//		// Reading CSV File with different separator 
//			try { 
//				// Create an object of file reader class with CSV file as a parameter. 
//				FileReader filereader = new FileReader(filePath); 
//
//				// create csvParser object with 
//				// custom separator semi-colon 
//				CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); 
//
//				// create csvReader object with parameter 
//				// filereader and parser 
//				CSVReader csvReader = new CSVReaderBuilder(filereader) 
//										.withCSVParser(parser) 
//										.build(); 
//
//				// Read all data at once 
//				List<String[]> allData = csvReader.readAll(); 
//
//				// Print Data. 
//				for (String[] row : allData) { 
//					for (String cell : row) { 
//						System.out.print(cell + "\t"); 
//					} 
//					System.out.println(); 
//				} 
//			} 
//			catch (Exception e) { 
//				e.printStackTrace(); 
//			} 
//		} 
	
	@BeforeMethod
	public void browserSetUp()
	{
		System.out.println("Test method");
		System.setProperty("webdriver.chrome.driver", projectDir+"/Browsers/chromedriver.exe");
		driver = new ChromeDriver();
		
		// In this method we initialize the browser driver and launch application using webdriver methods and assert on title
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		captureScreenshot(driver);
		String expectedTitle = driver.getTitle();
		Assert.assertEquals("Amazon.com. Spend less. Smile more.", expectedTitle);
	}

	@Test(priority=1)
	public void signUpAndLoginPage()
	{
		
		System.out.println("Write code to Signup and Login Page");
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.veriyUserAlreadySignUpMessage("Amara", "shanrocks555@gmail.com");
		captureScreenshot(driver);
		signUpPage.signInToAmazon();
		captureScreenshot(driver);
		driver.navigate().back();
		driver.navigate().back();
	}
	
	@Test(priority=2)
	public void searchItemAndAddToCart()
	{
		//Need to write code to search item and add it to cart
		AddToCart addToCart = new AddToCart(driver);
		addToCart.searchItem("iphone 15 pro");
//		addToCart.clickOnProductAndAddToCart("");
		
	}
	@AfterMethod
	public void tearDown()
	{
		System.out.println("After Method");
		driver.quit();
	}
}
