package com.katalon.pages;

import com.katalon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductKatalonPage extends TestBase {

	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	@CacheLookup
	WebElement addToCart;

	String url;

	// Initializing the Page Objects:
	public ProductKatalonPage(String url) {
		PageFactory.initElements(driver, this);
		this.url = url;
	}

	public void addRandomToCart(String url)
	{
			addToCart.click();
			driver.navigate().to(url);
	}
	
	
	
	
	
	
	

}
