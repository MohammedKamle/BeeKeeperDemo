package com.browserstack.base;

import java.util.List;

public class DeviceConfiguration {

    private String userName;
    private String acessKey;
    private String server;
    List<DeviceCapability> devices;

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

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public List<DeviceCapability> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceCapability> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "DeviceConfiguration{" +
                "userName='" + userName + '\'' +
                ", acessKey='" + acessKey + '\'' +
                ", server='" + server + '\'' +
                ", devices=" + devices +
                '}';
    }
}
