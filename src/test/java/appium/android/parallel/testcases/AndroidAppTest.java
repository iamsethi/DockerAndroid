package appium.android.parallel.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class AndroidAppTest {
	public AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, "android");

		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"com.example.android.apis.app.AlertDialogSamples");

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);

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
