package com.machine.coding.projects.service;

public class GameServiceFactory {

    public static GameService getGame(String game) {
        switch (game) {
            case "SnakeAndLadder":
                return new SnakeAndLadder();
            default:
                System.out.println("Please select a valid game.");
        }
        return null;
    }

}
