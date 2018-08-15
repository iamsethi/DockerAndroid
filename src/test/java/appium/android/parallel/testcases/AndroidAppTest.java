package appium.android.parallel.testcases;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class AndroidAppTest {
	public AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void testMethod() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("automationName", "UIAutomator2");
		capabilities.setCapability("app", "/root/tmp/sample_apk/sample_apk_debug.apk");
		capabilities.setCapability("browserName", "android");
		capabilities.setCapability("avd", "nexus_5_7.1.1");

		try {
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
			driver.findElementById("android.widget.Button").isDisplayed();

			driver.findElementById("first_input").sendKeys(Integer.toString(3));
			driver.findElementById("second_input").sendKeys(Integer.toString(7));
			driver.findElementById("btn_calculate").click();

			Assert.assertEquals(driver.findElementById("result").getText(), "10");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void searchForAppiumConf() {

	}

}
