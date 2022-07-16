package com.machine.coding.projects.service;

import java.util.Scanner;

import com.machine.coding.projects.dto.InterfaceDevice;
import com.machine.coding.projects.dto.interfacedevice.Alexa;
import com.machine.coding.projects.dto.interfacedevice.GoogleHome;

public class InterfaceDeviceFactory {

    public static InterfaceDevice getInterfaceDevice(String deviceName, Scanner sc) {
        switch (deviceName) {
            case "Alexa":
                return new Alexa(sc.next(), sc.next());
            case "Google Home":
                return new GoogleHome(sc.next(), sc.next());
            default:
                throw new RuntimeException(String.format("No device found with given name %s", deviceName));
        }
    }

}
