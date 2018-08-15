package appium.android.parallel.testcases;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MSiteChromeTest {
	public AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void testMethod() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("browserName", "chrome");

		try {
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
			driver.get("https://www.google.com/");
			WebElement element = driver.findElement(By.name("q"));
			element.sendKeys("AppiumConf");
			element.submit();

			driver.findElement(By.id("ires")).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testApp() {
		WebDriverWait wdw = new WebDriverWait(driver, 30);
//		wdw.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("io.appium.android.apis:id/two_buttons")))
//				.click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
