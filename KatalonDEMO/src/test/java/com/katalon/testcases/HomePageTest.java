package com.katalon.testcases;

import com.katalon.base.TestBase;
import com.katalon.pages.CartPage;
import com.katalon.pages.HomePage;
import com.katalon.pages.ProductKatalonPage;
import com.katalon.pages.ProductWordPressPage;
import com.katalon.util.TestUtil;
import com.qa.ExtentReportListener.ExtentReportHelpers;
import com.qa.ExtentReportListener.ExtentReportListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

@Listeners(ExtentReportListener.class)
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
		cartPage = new CartPage();
	}
	
	
	@Test(priority=1)
	public void addToCartAndRemove() throws IOException {
		int counter = 0;
		int listCounter = 0;
		ArrayList<Integer> lists = homePage.generateRandomList();
		ExtentReportHelpers.PassStep("Generated random list");
		while (counter < 4)
		{
			while(true) {
				//homePage = new HomePage();
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
			ExtentReportHelpers.PassStep("Product added to the cart %s", String.valueOf(counter+1));
			counter++;
		}
		//homePage = new HomePage();
		cartPage = new CartPage();
		ExtentReportHelpers.InfoStep("Navigate to cart");
		homePage.goToCart();
		ExtentReportHelpers.PassStep("Navigate to Cart");
		ExtentReportHelpers.InfoStep("No of products in cart %s", cartPage.noOfProducts());
		Assert.assertTrue(cartPage.countProducts(4));
		ExtentReportHelpers.PassStep("4 products in cart");
		ExtentReportHelpers.InfoStep("Get all prices");
		cartPage.getPrices();
		ExtentReportHelpers.PassStep("All price read");
		cartPage.getLowestPrice();
		ExtentReportHelpers.InfoStep("Remove lowest price");
		cartPage.removeLowestPrice();
		ExtentReportHelpers.PassStep("Removed lowest price");
		ExtentReportHelpers.InfoStep("No of products in cart %s", cartPage.noOfProducts());
		Assert.assertTrue(cartPage.countProducts(3));
		ExtentReportHelpers.PassStep("3 products in cart");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
