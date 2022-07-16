package com.machine.coding.projects.dto.smarthomedevice;

import java.util.List;
import java.util.Scanner;

import com.machine.coding.projects.dto.InterfaceDevice;
import com.machine.coding.projects.service.InterfaceDeviceFactory;
import com.machine.coding.projects.dto.SmartHomeDevice;
import com.machine.coding.projects.dto.Switch;

public class SmartCharger extends SmartHomeDevice {

    public SmartCharger(String location,
                        List<InterfaceDevice> connectedInterfaceDevices) {
        super(Switch.OFF, "Smart Charger", location, connectedInterfaceDevices);
    }
}
