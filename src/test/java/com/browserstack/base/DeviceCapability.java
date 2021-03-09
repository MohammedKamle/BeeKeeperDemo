package com.browserstack.base;

public class DeviceCapability {

    private String platform;
    private String osVersion;
    private String device;
    private String app;
    private String server;
    private String iosOsVersion;
    private String androidOsVersion;
    private String iosApp;
    private String androidApp;

    public String getIosOsVersion() {
        return iosOsVersion;
    }

    public void setIosOsVersion(String iosOsVersion) {
        this.iosOsVersion = iosOsVersion;
    }

    public String getAndroidOsVersion() {
        return androidOsVersion;
    }

    public void setAndroidOsVersion(String androidOsVersion) {
        this.androidOsVersion = androidOsVersion;
    }

    public String getIosApp() {
        return iosApp;
    }

    public void setIosApp(String iosApp) {
        this.iosApp = iosApp;
    }

    public String getAndroidApp() {
        return androidApp;
    }

    public void setAndroidApp(String androidApp) {
        this.androidApp = androidApp;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAcessKey() {
        return acessKey;
    }

    public void setAcessKey(String acessKey) {
        this.acessKey = acessKey;
    }

    private String userName;
    private String acessKey;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
}
