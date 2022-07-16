package Designs.parkinglot.command;

import java.util.Map;

public class ParkingLotCommandEvaluator {
    private final Map<Action, Command> actionCommandMap;

    public ParkingLotCommandEvaluator(Map<Action, Command> actionCommandMap) {
        this.actionCommandMap = actionCommandMap;
    }

    public Command commandBy(Action action) {
        return actionCommandMap.get(action);
    }
}
