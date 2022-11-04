package com.katalon.pages;

import com.katalon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductWordPressPage extends TestBase {

	@FindBy(xpath = "//button[normalize-space()='Buy on WordPress Swag Store']")
	@CacheLookup
	List<WebElement> swagStore;

	@FindBy(xpath = "//span[@role='combobox']")
	@CacheLookup
	List<WebElement> dropDownOption;

	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	@CacheLookup
	List<WebElement>  addToCart;

	String url;

	// Initializing the Page Objects:
	public ProductWordPressPage(String url) {
		PageFactory.initElements(driver, this);
		this.url = url;
	}


	boolean isElementPresent(List<WebElement> element) {
		return element != null && element.size()>0 ;
	}


	public boolean checkIfCanBeAdded() {

		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}*/
		Boolean c = isElementPresent(dropDownOption);
		if(c)
		{
			driver.navigate().to(url);
			return false;
		}

		Boolean a = isElementPresent(addToCart);

		if(a)
		{
			return true;
		}
		Boolean b = isElementPresent(swagStore);

		if(b)
		{
			driver.navigate().to(url);
			return false;
		}

		return true;
	}


}
