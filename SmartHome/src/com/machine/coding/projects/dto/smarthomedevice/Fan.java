package com.machine.coding.projects.dto.smarthomedevice;

import java.util.List;
import java.util.Scanner;

import com.machine.coding.projects.dto.InterfaceDevice;
import com.machine.coding.projects.service.InterfaceDeviceFactory;
import com.machine.coding.projects.dto.SmartHomeDevice;
import com.machine.coding.projects.dto.Switch;

public class Fan extends SmartHomeDevice {

    private static final int min_range = 0;

    private static final int max_range = 5;

    private int speed;

    public Fan(String location, List<InterfaceDevice> connectedInterfaceDevices) {
        super(Switch.OFF, "Fan", location, connectedInterfaceDevices);
    }

    public boolean validateSpeed(int speed) {
        boolean f = speed >= min_range & speed <= max_range;
        if (f) this.speed = speed;
        return f;
    }

}
