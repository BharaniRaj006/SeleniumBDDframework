package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestScriptPage {

	private WebDriver driver;

	// 1. By Locators: OR
	
	private By firstitem = By.xpath("(//i[contains(@class,'yith-wcwl-icon fa fa-heart-o')])[1]");	
	private By seconditem = By.xpath("(//i[contains(@class,'yith-wcwl-icon fa fa-heart-o')])[2]");
	private By thirditem = By.xpath("(//i[contains(@class,'yith-wcwl-icon fa fa-heart-o')])[4]");
	private By fourthitem = By.xpath("(//i[contains(@class,'yith-wcwl-icon fa fa-heart-o')])[5]");
	private By wishlist = By.xpath("(//i[@class='lar la-heart'])[1]");
	private By container = By.cssSelector(".main-content-page.single-content");
	private By acceptall = By.linkText("Accept all");
	private By lowestprice = By.xpath("(//td[@class='product-price'])[2]");
	private By addtocart = By.xpath("(//td[@class='product-add-to-cart'])[2]");
	private By shoppingbag =By.xpath("(//i[@class='la la-shopping-bag'])[1]");
	private By carttotal = By.cssSelector(".cart_totals");
	private By home = By.xpath("//a[.='Home']"); 
	
	
	
	// 2. Constructor of the page class:
		public TestScriptPage(WebDriver driver) {
			this.driver = driver;
		}
	
	
	// 3. Actions :
		
		public void clickOnItems()
		{
			
			driver.findElement(acceptall).click();
			driver.findElement(firstitem).click();
			driver.navigate().refresh();
			driver.findElement(seconditem).click();
			driver.navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			driver.findElement(thirditem).click();
			driver.findElement(fourthitem).click();
			driver.navigate().refresh();
			
		}
		
		public void clickOnWishlist()
		{
			driver.findElement(wishlist).click();
		}
		
		
		public void viewMyList() throws IOException
		{		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("./Screenshots/Wishlist.png"));
			String item = driver.findElement(container).getText();
			System.out.println("** THE PRODUCTS ARE ** = " + item);	
		}
		
		
		public void lowestPriceProduct()
		
		{List<WebElement> price = driver.findElements(container);
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price)
		{
		    prices.add(e.getText());
		}
		List<String> sortedPrices = new ArrayList<String>(prices);
		// sort the list
		Collections.sort(sortedPrices);
		// true if the prices are sorted
		System.out.println(sortedPrices.equals(prices));	
		String item = driver.findElement(lowestprice).getText();
		System.out.println("** THE LOWEST PRICE PRODUCT IS ** = " + item);
		driver.findElement(addtocart).click();
		driver.findElement(home).click();			
		}
		
		
		public void addItemToCart() throws IOException 
		{		
			driver.findElement(shoppingbag).click();
			TakesScreenshot ts = (TakesScreenshot)driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("./Screenshots/MyCart.png"));
		}
		
		public void validateCart()
		{		
			String item = driver.findElement(carttotal).getText();
			System.out.println("** THE CART TOTAL IS ** = " + item);
		}
		
		
}
