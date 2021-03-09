package com.browserstack.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class AppFactory {
    private static AppiumDriver<MobileElement> driver;
    private static DesiredCapabilities capabilities;
    private static final String BROWSERSTACK_USERNAME = "";
    private static final String BROWSERSTACK_ACCESSKEY = "";
    private static final String SERVER = "hub-cloud.browserstack.com";

    public static void launchApp(String deviceShortName) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("config.yml");
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        DeviceCapability deviceCapability = om.readValue(is,DeviceCapability.class);
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName",deviceCapability.getPlatform());
        capabilities.setCapability("os_version",deviceCapability.getOsVersion() );
        capabilities.setCapability("device", deviceCapability.getDevice());
        capabilities.setCapability("app",deviceCapability.getApp() );
        WebDriver driver;

        switch (deviceCapability.getPlatform()) {
            case "android":
                System.out.println("Test launching on android");
                driver = new AndroidDriver<MobileElement>(
                  new URL("http://"+BROWSERSTACK_USERNAME+":"+BROWSERSTACK_ACCESSKEY+"@"+SERVER+"/wd/hub"), capabilities
                );
                break;
            case "ios":
                System.out.println("Test launching on iOS");
                driver = new IOSDriver(
                  new URL("http://"+BROWSERSTACK_USERNAME+":"+BROWSERSTACK_ACCESSKEY+"@"+SERVER+"/wd/hub"), capabilities
                );
                break;
            default:
                throw new Error("Unsupported Device Platform :: " + deviceCapability.getPlatform());
        }
        AppDriver.setDriver(driver);
    }

    public static void closeApp(){
        AppDriver.getDriver().quit();
    }

}
