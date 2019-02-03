package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class DriverManager {

    private static final int TIMEOUT = 10;
    public static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            try {
                driver = new AndroidDriver<MobileElement>(new URL(get("remoteAddress")), setup());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        }
        return driver;
    }

    private static DesiredCapabilities setup() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", get("deviceName"));
        caps.setCapability("udid", get("udid"));
        caps.setCapability("platformName", get("platformName"));
        caps.setCapability("platformVersion", get("platformVersion"));
        caps.setCapability("skipUnlock", get("skipUnlock"));
        caps.setCapability("appPackage", get("appPackage"));
        caps.setCapability("appActivity", get("appActivity"));
        caps.setCapability("noReset", get("noReset"));
        return caps;
    }

    private static String get(final String key) {
        return PropertyLoader.loadProperty(key);
    }
}
