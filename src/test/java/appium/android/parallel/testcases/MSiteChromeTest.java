package appium.android.parallel.testcases;

import java.net.MalformedURLException;
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
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class MSiteChromeTest {
	public AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// #######EMULATOR MOBILE WEB#################################
//		capabilities.setCapability("platformVersion", "8.1");
//		capabilities.setCapability("deviceName", "samsung_galaxy_s6_8.1");
//		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");

		// #######REAL DEVICE MOBILE WEB#################################
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("deviceName", "464b5c510204");
		capabilities.setCapability("browserName", "chrome");

		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");

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
