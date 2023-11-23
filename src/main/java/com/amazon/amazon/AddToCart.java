package com.amazon.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToCart extends JavaUtilsClass {
	
	WebDriver driver;

	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(id ="nav-search-submit-button")
	WebElement searchIcon;
	
	public AddToCart(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchItem(String productName)
	{
//		WebDriverWait wb = new WebDriverWait(driver,10);
//		wb.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("searchBar")));
		searchBar.sendKeys(productName);
		searchIcon.click();
		captureScreenshot(driver);
	}
}
