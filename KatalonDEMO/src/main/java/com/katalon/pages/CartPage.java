package com.katalon.pages;

import com.katalon.base.TestBase;
import com.qa.ExtentReportListener.ExtentReportHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends TestBase {

	Float item1Price,  item2Price,  item3Price,  item4Price, lowest;

	@FindAll({
			@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/main[1]/article[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]"),
			@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/main[1]/article[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[4]/span[1]"),
	})
	@CacheLookup
	public List<WebElement> items1;

	@FindAll({
			@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/main[1]/article[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/a[1]"),
			@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/main[1]/article[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[4]/span[1]")
	})
	@CacheLookup
	public List<WebElement> items2;

	@FindAll({
			@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/main[1]/article[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[3]/td[1]/a[1]"),
			@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/main[1]/article[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[3]/td[4]/span[1]")
	})
	@CacheLookup
	public List<WebElement> items3;

	@FindAll({
			@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/main[1]/article[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[4]/td[1]/a[1]"),
			@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/main[1]/article[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[4]/td[4]/span[1]")
	})
	@CacheLookup
	public List<WebElement> items4;


	@FindBy(css = ".woocommerce-cart-form__cart-item.cart_item")
	public List<WebElement> elementRows;

	// Initializing the Page Objects:
	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public void getPrices()
	{
		String item1Text = items1.get(1).getText();
		item1Price = Float.valueOf(item1Text.replace("$", ""));

		String item2Text = items2.get(1).getText();
		item2Price = Float.valueOf(item2Text.replace("$", ""));

		String item3Text = items3.get(1).getText();
		item3Price = Float.valueOf(item3Text.replace("$", ""));

		String item4Text = items4.get(1).getText();
		item4Price = Float.valueOf(item4Text.replace("$", ""));
	}

	public void getLowestPrice()
	{
		ExtentReportHelpers.InfoStep("Lowest price %s", String.valueOf(lowest));

		lowest = item1Price;
		if(item2Price < lowest)
		{
			lowest = item2Price;
		}
		if(item3Price < lowest)
		{
			lowest = item3Price;
		}
		if(item4Price < lowest)
		{
			lowest = item4Price;
		}
	}

	public void removeLowestPrice()
	{
		if(item1Price == lowest)
		{
			items1.get(0).click();
		}
		else {
			if (item2Price == lowest) {
				items2.get(0).click();
			} else {
				if (item3Price == lowest) {
					items3.get(0).click();
				} else {

					if (item4Price == lowest) {
						items4.get(0).click();
					}
				}
			}
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public int noOfProducts()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		return elementRows.size();
	}


	public boolean countProducts(int neededProducts)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		if(elementRows.size() == neededProducts)
			return true;
		else return false;
	}


}
