package com.machine.coding.projects.dto;

public class Person {

    private String name;

    private int position;

    public Person(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPositions(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String toPrint(int val, int finalpos) {
        return String.format("%s rolled a %s and moved from %s to %s", name, val, position, finalpos);
    }
}
