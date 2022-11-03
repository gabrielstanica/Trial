package com.katalon.testcases;

import com.katalon.pages.CartPage;
import com.katalon.pages.HomePage;
import com.katalon.pages.ProductKatalonPage;
import com.katalon.pages.ProductWordPressPage;
import com.katalon.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.katalon.base.TestBase;

import java.util.ArrayList;

public class HomePageTest extends TestBase {
	HomePage homePage;
	ProductKatalonPage productKatalonPage;
	ProductWordPressPage productWordPressPagePage;
	TestUtil testUtil;
	CartPage cartPage;
	String url;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		url = prop.getProperty("url");
		homePage = new HomePage();
		productWordPressPagePage = new ProductWordPressPage(url);
		productKatalonPage = new ProductKatalonPage(url);
		CartPage cartPage = new CartPage();
	}
	
	
	@Test(priority=1)
	public void addToCartAndRemove(){
		int counter = 0;
		int listCounter = 0;
		ArrayList<Integer> lists = homePage.generateRandomList();
		while (counter < 4)
		{
			while(true) {
				homePage = new HomePage();
				homePage.goToProduct(lists.get(listCounter));
				productWordPressPagePage = new ProductWordPressPage(url);
				if(productWordPressPagePage.checkIfCanBeAdded()) {
					listCounter++;
					break;
				}
				listCounter++;
			}
			productKatalonPage = new ProductKatalonPage(url);
			productKatalonPage.addRandomToCart(url);
			counter++;
		}
		//homePage = new HomePage();
		cartPage = new CartPage();
		homePage.goToCart();
		cartPage.getPrices();
		cartPage.getLowestPrice();
		cartPage.removeLowestPrice();
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
