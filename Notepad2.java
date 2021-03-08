package notepad;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class Notepad2 {

	public static WindowsDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platformName","Windows");
		cap.setCapability("deviceName","WindowsPC");
		
		try {
			driver = new WindowsDriver(new URL("http:\\127.0.01:4723"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void sendTextTest() {
		driver.findElementByName("Text Editor").sendKeys("03.08.2021");
		driver.findElementByName("Text Editor").clear();
		
	}
	
	@Test(priority=2)
	public void EnterTimeAndDateTest() {
		driver.findElementByName("Edit").click();
		driver.findElementByAccessibilityId("15").click();
		String value = driver.findElementByName("Text Editor").getAttribute("Value.Value");
	    System.out.println(value);
	    Assert.assertTrue(value.contains("08.03.2021"));
	}
	
	
}
