package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;

public class Search {
	WebDriver driver;

	@Given("User already logged in")
	public void user_already_logged_in() {
		driver = DriverFactory.getDriver();

	}

	@When("User search for valid product {string}")
	public void user_search_for_valid_product(String string) {
		driver.findElement(By.name("search")).sendKeys(string);
	}

	@When("User click on search button")
	public void user_click_on_search_button() {
		driver.findElement(By.cssSelector(".btn.btn.btn-default.btn-lg")).click();
	}

	@Then("User should get product displayed")
	public void user_should_get_product_displayed() {
		Assert.assertTrue(driver.findElement(By.partialLinkText("HP")).isDisplayed());
	}

	@When("User search for invalid product {string}")
	public void user_search_for_invalid_product(String string) {
		driver.findElement(By.name("search")).sendKeys(string);
	}

	@When("User search without any product name")
	public void user_search_without_any_product_name() {

	}

	@Then("User should get error message for product search")
	public void user_should_get_error_message_for_product_search() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText()
				.contains("There is no product that matches the search criteria."));
	}
}
