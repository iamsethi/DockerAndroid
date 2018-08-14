package appium.android.parallel.AndroidTestBase;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidTestBase {

	public AndroidDriver<AndroidElement> driver;

	@BeforeTest
	@Parameters({ "platformVersion", "browserName", "deviceName" })
	public void testMethod(String platformVersion, String browserName, String deviceName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		try {
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
