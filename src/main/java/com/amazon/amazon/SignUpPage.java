package com.amazon.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class SignUpPage extends JavaUtilsClass{

	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Hello, sign in']")
	WebElement signin;
	
	@FindBy(xpath = "//a[text()='Start here.']")
	WebElement startHere;
	
	@FindBy(id ="ap_customer_name")
	WebElement nameField;
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="ap_password_check")
	WebElement reenterPassword;
	
	@FindBy(xpath = "//a[contains(@href,'signin')]")
	WebElement signIn;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement submitBtn;
	
	@FindBy(xpath = "//div[@class='a-alert-content']")
	WebElement errorMessage;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void veriyUserAlreadySignUpMessage(String name, String em)
	{
		try {
		Actions action = new Actions(driver);
		action.moveToElement(signin).build().perform();
		startHere.click();
		captureScreenshot(driver);
		nameField.isDisplayed();
		nameField.sendKeys(name);
		email.sendKeys(em);
		password.sendKeys("passwrd");
		reenterPassword.sendKeys("passwrd");
		submitBtn.click();
		Thread.sleep(5000);
		errorMessage.isDisplayed();
		
		} catch (InterruptedException e) {
			
		}
		
		
	}
	
	public void signInToAmazon()
	{
		signIn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		email.isDisplayed();
		submitBtn.isDisplayed();
		
	}
	
}
