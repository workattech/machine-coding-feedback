package model;

public enum DisplayType {
    occupied_slots("occupied_slots"),
    free_count("free_count"),
    free_slots("free_slots");

    private final String type;

    DisplayType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
