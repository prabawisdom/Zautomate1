package zautomate.zadoqa.config;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import zautomate.zadoqa.utils.Directory;

public class AndroidSetup {
	public static AndroidDriver adriver;
	public static AndroidDriver getDriver() {
//		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(Directory.MOBILE_APPPATH);
		File app = new File(appDir, Directory.MOBILEAPP_APK_NAME);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName",Directory.MOBILE_DEVICE_NAME);
		capabilities.setCapability("platformVersion", Directory.MOBILE_DEVICE_VERSION);
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", Directory.MOBILE_APK_APPPACKAGE);
//		capabilities.setCapability("app-activity", ".Freecharge");	
		try {
			adriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return adriver;
	}
}
