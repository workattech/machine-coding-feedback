package Designs.parkinglot;

import Designs.parkinglot.command.*;
import Designs.parkinglot.model.ParkingLot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws IOException {
        Map<Action, Command> actionCommandMap = Map.of(Action.CREATE_PARKING_LOT, new CreateParkingLotCommand(),
                Action.PARK_VEHICLE, new ParkVehicleCommand(),
                Action.UNPARK_VEHICLE, new UnparkVehicleCommand(),
                Action.DISPLAY, new DisplayCommand());
        ParkingLotCommandEvaluator parkingLotCommandEvaluator = new ParkingLotCommandEvaluator(actionCommandMap);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens;
        // right now supports 1 parking lot
        ParkingLot[] parkingLot = new ParkingLot[1];
        while (true) {
            String input = br.readLine();
            tokens = input.split(" ");
            if (tokens[0].equalsIgnoreCase("exit")) break;
            Command command = parkingLotCommandEvaluator.commandBy(Action.valueOf(tokens[0].toUpperCase()));
            command.execute(parkingLot, tokens);
        }
    }
}
