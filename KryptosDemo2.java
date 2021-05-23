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

public class KryptosDemo2 {

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
			
			e.printStackTrace();   }
		calcession.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  }
	@AfterClass
	public static void tearDown() {
		System.out.println("Kryptos açıldı");
		calcession.quit();  }
	@Test
	public void loginApp() {
		calcession.findElementByName("Token").sendKeys("parola");
		calcession.findElementByName("Giriş").click();   }

	@Test 
	public void fileEncrypt() {
		calcession.findElementByName("Kryptos").click();
		calcession.findElementByName("Encrypt").click();
		calcession.findElementByName("Masaüstü").click();
		calcession.findElementByName("Şifreleme").click();
		calcession.findElementByName("Klasör seç").click();
		calcession.findElementByName("Kendim için").click();
		calcession.findElementByName("Hayır").click();
	}
	@Test
	public void filePasswordCracking() {
		calcession.findElementByName("Kryptos").click();
		calcession.findElementByName("Decrypt").click();
		calcession.findElementByName("Masaüstü").click();
		calcession.findElementByName("Şifreleme").click();
		calcession.findElementByName("Dosyayı değitir.").click();
		calcession.findElementByName("Evet").click();
	}
	
}
	
	
