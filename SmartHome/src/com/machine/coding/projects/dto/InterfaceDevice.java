package com.machine.coding.projects.dto;

public abstract class InterfaceDevice  {

    protected String name;

    protected String location;

    protected String sound;

    public InterfaceDevice(String name, String location, String sound) {
        this.name = name;
        this.location = location;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getSound() {
        return sound;
    }
}
