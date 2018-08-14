package appium.android.parallel.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import appium.android.parallel.AndroidTestBase.AndroidTestBase;

public class MSiteAndroidBrowserTest extends AndroidTestBase {

	@Test
	public void visitMyPersonalPage() {

		driver.get("https://buttomo1989.github.io/");

		driver.findElement(By.linkText("About")).click();
		driver.findElement(By.xpath("/html/body/div/div/p[2]")).isDisplayed();
		driver.findElement(By.linkText("Home")).isDisplayed();

	}

}
