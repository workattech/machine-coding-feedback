package com.machine.coding.projects.dto;

import java.util.List;

public abstract class SmartHomeDevice {

    protected Switch deviceState;

    protected String deviceName;

    protected String location;

    protected List<InterfaceDevice> connectedInterfaceDevices;

    public SmartHomeDevice(Switch deviceState, String deviceName, String location,
                           List<InterfaceDevice> connectedInterfaceDevices) {
        this.deviceState = deviceState;
        this.deviceName = deviceName;
        this.location = location;
        this.connectedInterfaceDevices = connectedInterfaceDevices;
    }

    public void setDeviceState(Switch deviceState) {
        if (this.deviceState.equals(deviceState)) {
            System.out.println("Device already in required state");
            return;
        }
        this.deviceState = deviceState;
    }

    public Switch getDeviceState() {
        return deviceState;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getLocation() {
        return location;
    }

    public List<InterfaceDevice> getConnectedInterfaceDevice() {
        return connectedInterfaceDevices;
    }

    public void addInterfaceDevice(InterfaceDevice interfaceDevice) {
        connectedInterfaceDevices.add(interfaceDevice);
    }
}
