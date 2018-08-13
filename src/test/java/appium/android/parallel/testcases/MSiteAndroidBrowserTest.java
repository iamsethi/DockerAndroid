package appium.android.parallel.testcases;

import org.testng.annotations.Test;

import appium.android.parallel.AndroidTestBase.AndroidTestBase;
import junit.framework.Assert;

public class MSiteAndroidBrowserTest extends AndroidTestBase {

	@Test
	public void visitMyPersonalPage() {

		driver.findElementById("android.widget.Button").isDisplayed();

		driver.findElementById("first_input").sendKeys(Integer.toString(3));
		driver.findElementById("second_input").sendKeys(Integer.toString(7));
		driver.findElementById("btn_calculate").click();

		Assert.assertEquals(driver.findElementById("result").getText(), "10");

	}

}
