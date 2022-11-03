package com.katalon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

import com.katalon.base.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HomePage extends TestBase {

	@FindAll({
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[1]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[2]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[3]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[4]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[5]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[6]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[7]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[8]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[9]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[10]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[11]"),
			@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[12]")
	})
	@CacheLookup
	List<WebElement> item;


	@FindBy(xpath = "//a[normalize-space()='Cart']")
	@CacheLookup
	WebElement cart;

	ArrayList<Integer> list = new ArrayList<Integer>();

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ArrayList<Integer> generateRandomList(){
		for (int i=1; i<11; i++) list.add(i);
		Collections.shuffle(list);
		return list;
	}

	public void goToCart()
	{
		cart.click();
	}
	public void goToProduct(Integer count)
	{
		item.get(count).click();
	}
	
	
	
	
	
	
	

}
