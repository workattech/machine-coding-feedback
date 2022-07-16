package com.machine.coding.projects.dto.smarthomedevice;

import java.util.List;
import java.util.Scanner;

import com.machine.coding.projects.dto.Color;
import com.machine.coding.projects.dto.InterfaceDevice;
import com.machine.coding.projects.service.InterfaceDeviceFactory;
import com.machine.coding.projects.dto.SmartHomeDevice;
import com.machine.coding.projects.dto.Switch;

public class Light extends SmartHomeDevice {

    private static final int minbrigentness = 0;

    private static final int maxbrigntness = 10;

    private Color color;

    public Light(String location, List<InterfaceDevice> connectedInterfaceDevices) {
        super(Switch.OFF, "Light", location, connectedInterfaceDevices);
        this.color = Color.WHITE;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = Color.valueOf(color);
    }

    public boolean validateBrightness(int brightness) {
        return brightness >= 0 & brightness <= 10;
    }

}
