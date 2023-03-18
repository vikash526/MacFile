package stepDefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;

public class Register {
	WebDriver driver;

	@Given("User navigates to Register account page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[.='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@When("User enter details in below fields")
	public void user_enter_details_in_below_fields(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));

	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		driver.findElement(By.name("agree")).click();
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("User account should be created successfully")
	public void user_account_should_be_created_successfully() {
		Assert.assertTrue(driver.getTitle().contains("Your Account Has Been Created!"));
	}

	@When("User selects newsletter option")
	public void user_selects_newsletter_option() {
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
	}

	@When("User dont enter any details")
	public void user_dont_enter_any_details() {

	}
	
	@Then("User should get error message for duplicate email")
	public void user_should_get_error_message_for_duplicate_email() {
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText()
	    		.contains(" Warning: E-Mail Address is already registered!"));
	}

	@Then("User should get error message for blank value")
	public void user_should_get_error_message_for_blank_value() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText()
	    		.contains(" Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='text-danger'])[1]")).getText(), "First Name must be between 1 and 32 characters!");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='text-danger'])[2]")).getText(), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='text-danger'])[3]")).getText(), "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='text-danger'])[4]")).getText(), "Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='text-danger'])[5]")).getText(), "Password must be between 4 and 20 characters!");
	}
}
