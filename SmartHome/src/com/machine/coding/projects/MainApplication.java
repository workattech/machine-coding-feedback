package com.machine.coding.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.machine.coding.projects.dto.InterfaceDevice;
import com.machine.coding.projects.dto.SmartHomeDevice;
import com.machine.coding.projects.dto.Switch;
import com.machine.coding.projects.dto.smarthomedevice.Fan;
import com.machine.coding.projects.dto.smarthomedevice.Light;
import com.machine.coding.projects.service.InterfaceDeviceFactory;
import com.machine.coding.projects.service.SmartHomeDeviceFactory;

public class MainApplication {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<InterfaceDevice> interfaceDeviceList = new ArrayList<>();
        List<SmartHomeDevice> smartHomeDevices = new ArrayList<>();
        while(true) {
            Random random = new Random();
            int num = 1 + random.nextInt(6);
            switch (num) {
                case 1:
                    InterfaceDevice interfaceDevice = InterfaceDeviceFactory.getInterfaceDevice(scanner.next(), scanner);
                    interfaceDeviceList.add(interfaceDevice);
                    break;
                case 2:
                    SmartHomeDevice smartHomeDevice = SmartHomeDeviceFactory.getSmartHomeDevice(scanner.next(), scanner);
                    smartHomeDevices.add(smartHomeDevice);
                    break;
                case 3:
                    giveCommand(scanner, interfaceDeviceList, smartHomeDevices);
                    break;
                case 4:

                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    throw new RuntimeException("No such operation found");
            }
        }
    }

    private static void giveCommand(Scanner scanner, List<InterfaceDevice> interfaceDeviceList,
                                    List<SmartHomeDevice> smartHomeDevices) {
        String sound = scanner.next();
        String deviceName = scanner.next();
        String room = scanner.next();
        String operation = scanner.next();
        boolean flag = false;
        for (InterfaceDevice device: interfaceDeviceList) {
            if (device.getLocation().equals(room) && getDeviceBasedOnSound(sound).equals(device.getName())) {
                flag = true;
            }
        }
        if (flag) {
            for (SmartHomeDevice device: smartHomeDevices) {
                if (device.getDeviceName().equals(deviceName)) {
                    if (operation == "ON" || operation == "OFF") {
                        device.setDeviceState(Switch.valueOf(operation));
                    } else {
                        boolean f = false;
                        if (device instanceof Fan) {
                            f = ((Fan) device).validateSpeed(Integer.parseInt(operation));
                        } else if(device instanceof Light) {
                            f = ((Light) device).validateBrightness(Integer.parseInt(operation));
                        } else {
                            System.out.println("Unsupported Operation");
                        }
                    }
                }
            }
        } else {
            System.out.println("Incompatible operation");
        }
    }

    private static String getDeviceBasedOnSound(String sound) {
        switch (sound) {
            case "Alexa":
                return "Alexa";
            case "Ok Google":
                return "GoogleHome";
            default:
                throw new RuntimeException(String.format("Unrecognized sound %s", sound));
        }
    }

}
