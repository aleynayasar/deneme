package KryptosDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class KryptosDemo1 {
	private static WindowsDriver calcession = null;
	private WebElement calcresult =null;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Kryptos açılıyor");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "C:\\Program Files\\Kryptos\\WDE\\KryptosWDE.exe");
		try {
			calcession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		calcession.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Kryptos açıldı");
		calcession.quit();
	}
	
	@Test 
	 public void LoginApp() {
		calcession.findElementByName("Token").sendKeys("aleyna.60yasar");
		calcession.findElementByName("Giriş").click();
	}
	
	@Test 
	public void Createagroup() {
		calcession.findElementByName("Paylaşım").click();
		calcession.findElementByName("Gruplar").click();
		calcession.findElementByName("Yeni Grup").click();
		calcession.findElementByName("İsim").sendKeys("Ctech");
		calcession.findElementByName("Kaydet").click();
	}
}
