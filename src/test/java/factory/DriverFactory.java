package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	static WebDriver webDriver;

	public static void initializeBrowser(String browserName) {

		if (browserName.equals("chrome")) {
			webDriver = new ChromeDriver();
		} else if (browserName.equals("fireox")) {
			webDriver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			webDriver = new FirefoxDriver();
		} else {
			webDriver = new SafariDriver();
		}
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return webDriver;
	}
}
