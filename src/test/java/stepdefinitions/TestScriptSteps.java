package stepdefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.pages.TestScriptPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestScriptSteps {

	private TestScriptPage testScriptPage = new TestScriptPage(DriverFactory.getDriver());

	@Given("I add four different products to my wish list")
	public void i_add_four_different_products_to_my_wish_list() throws InterruptedException {
		DriverFactory.getDriver().get("https://testscriptdemo.com/");
		String ActualTitle = DriverFactory.getDriver().getTitle();
		String ExpectedTitle = "TESTSCRIPTDEMO – Automation Practice";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		
		testScriptPage.clickOnItems();
		Thread.sleep(2000);
	}

	@When("I view my wishlist table")
	public void i_view_my_wishlist_table() throws InterruptedException {
		testScriptPage.clickOnWishlist();
		Thread.sleep(1000);
	}

	@Then("I find total four selected items in my Wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() throws IOException {
		testScriptPage.viewMyList();
		String ActualTitle = DriverFactory.getDriver().getTitle();
		String ExpectedTitle = "Wishlist – TESTSCRIPTDEMO";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	
	}

	@When("I search for lowest price product")
	public void i_search_for_lowest_price_product() {

		testScriptPage.lowestPriceProduct();
	}

	@When("I am able to add the lowest price item to my cart")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() throws IOException {
		testScriptPage.addItemToCart();
	}

	@Then("I am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_my_cart() {
		String ActualTitle = DriverFactory.getDriver().getTitle();
		String ExpectedTitle = "Cart – TESTSCRIPTDEMO";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		testScriptPage.validateCart();
	}
}
