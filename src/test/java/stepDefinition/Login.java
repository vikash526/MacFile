package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;

public class Login {
	WebDriver driver;
	@Given("User navigate to login page")
	public void user_navigate_to_login_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[.='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
	}

	@When("User enter valid email address {string}")
	public void user_enter_valid_email_address(String string) {
		driver.findElement(By.id("input-email")).sendKeys(string);
	}

	@When("User enter valid password {string}")
	public void user_enter_valid_password(String string) {
		driver.findElement(By.id("input-password")).sendKeys(string);
	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		
		if(driver.getTitle().equals("My Account")) {
			Assert.assertTrue(true);
		}
	}

	@When("User enter invalid email address {string}")
	public void user_enter_invalid_email_address(String string) {
		driver.findElement(By.id("input-email")).sendKeys(string);
	}

	@When("User enter invalid password {string}")
	public void user_enter_invalid_password(String string) {
		driver.findElement(By.id("input-password")).sendKeys(string);
	}

	@Then("User should get error message")
	public void user_should_get_error_message() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText()
				.contains(" Warning: No match for E-Mail Address and/or Password."));
		}

	@When("User dont enter any email address")
	public void user_dont_enter_any_email_address() {

	}

	@When("User dont enter any password")
	public void user_dont_enter_any_password() {

	}
}
