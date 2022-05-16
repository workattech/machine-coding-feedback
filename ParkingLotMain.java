import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import command.CommandManagement;
import entity.ParkingLot;
import entity.ParkingLotManager;

public class ParkingLotMain {
    public static void main(String[] args) throws IOException {
        CommandManagement commandManager = new CommandManagement();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLotManager parkingLotManager = null;
        File file = new File("/Users/varsha.lalwani/personal/machine-coding-feedback/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String command;
        while ((command = br.readLine()) != null) {
            if (command.equals("exit")) {
                System.exit(0);
            } else {
                Integer commandNum = commandManager.getCommandType(command);
                if(commandNum == 1){
                    ParkingLot parkingLot = commandManager.createParkingLot(command);
                    parkingLotList.add(parkingLot);
                } else if(commandNum == 2) {
                    if (parkingLotManager == null) {
                        parkingLotManager = new ParkingLotManager(parkingLotList);
                    }
                    commandManager.parkVehicle(command, parkingLotManager);
                } else if(commandNum == 3){
                    if (parkingLotManager == null) {
                        parkingLotManager = new ParkingLotManager(parkingLotList);
                    } else {
                        commandManager.unparkVehicle(command, parkingLotManager);
                    }
                } else if(commandNum == 4) {
                    if (parkingLotManager == null) {
                        parkingLotManager = new ParkingLotManager(parkingLotList);
                    }
                    commandManager.display(command, parkingLotManager);
                } else{
                    break;
                }
            }
        }
    }
}
