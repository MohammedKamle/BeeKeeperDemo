package com.browserstack.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class AppFactory {

    private static AppiumDriver<MobileElement> driver;
    private static DesiredCapabilities capabilities;

    public static void launchApp(String deviceNAme) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("config.yml");
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        DeviceConfiguration deviceConfiguration = om.readValue(is,DeviceConfiguration.class);
        List<DeviceCapability> devices  = deviceConfiguration.getDevices();
        for (DeviceCapability device : devices){
            if(deviceNAme.equalsIgnoreCase(device.getName())){
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName",device.getPlatform());
                capabilities.setCapability("os_version",device.getOsVersion() );
                capabilities.setCapability("device", device.getDevice());
                capabilities.setCapability("app",device.getApp() );
                switch (device.getPlatform()) {
                    case "android":
                        System.out.println("Test launching on "+ device.getDevice());
                        driver = new AndroidDriver<MobileElement>(
                                new URL("http://"+deviceConfiguration.getUserName()+":"+deviceConfiguration.getAcessKey()+"@"+deviceConfiguration.getServer()+"/wd/hub"), capabilities
                        );
                        break;
                    case "ios":
                        System.out.println("Test launching on "+device.getDevice());
                        driver = new IOSDriver(
                                new URL("http://"+deviceConfiguration.getUserName()+":"+deviceConfiguration.getAcessKey()+"@"+deviceConfiguration.getServer()+"/wd/hub"), capabilities
                        );
                        break;
                    default:
                        throw new Error("Unsupported Device Platform :: " + device.getPlatform());
                }
                AppDriver.setDriver(driver);

            }
        }
    }

    public static void closeApp(){
       AppDriver.getDriver().quit();
    }

}
