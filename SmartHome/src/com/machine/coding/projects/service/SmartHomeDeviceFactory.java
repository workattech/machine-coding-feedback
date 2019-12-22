package com.machine.coding.projects.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.machine.coding.projects.dto.SmartHomeDevice;
import com.machine.coding.projects.dto.smarthomedevice.Fan;
import com.machine.coding.projects.dto.smarthomedevice.Light;
import com.machine.coding.projects.dto.smarthomedevice.SmartCharger;

public class SmartHomeDeviceFactory {

    public static SmartHomeDevice getSmartHomeDevice(String deviceName, Scanner sc) {
        switch (deviceName) {
            case "Light":
                return new Light(sc.next(), new ArrayList<>());
            case "Fan":
                return new Fan(sc.next(), new ArrayList<>());
            case "SmartCharger":
                return new SmartCharger(sc.next(), new ArrayList<>());
            default:
                throw new RuntimeException(String.format("No smart home device fount with the given name %s", deviceName));
        }
    }

}
