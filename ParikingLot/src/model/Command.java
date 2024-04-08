package model;

public enum Command {
    TERMINAL_COMMAND("exit"),
    CREATE_PARKING_LOT("create_parking_lot"),
    PARK_VEHICLE("park_vehicle"),
    UNPARK_VEHICLE("unpark_vehicle"),
    DISPLAY("display");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
