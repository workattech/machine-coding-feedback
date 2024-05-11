package model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int ladders;
    private int snakes;
    private int users;
    private List<List<Integer>> laddersList;
    private List<List<Integer>> snakesList;
    private List<User> usersList;

    public Board(int ladders, int snakes, int users) {
        this.ladders = ladders;
        this.snakes = snakes;
        this.users = users;
        laddersList = new ArrayList<>();
        snakesList = new ArrayList<>();
        usersList = new ArrayList<>();
    }

    public int getLadders() {
        return ladders;
    }

    public void setLadders(int ladders) {
        this.ladders = ladders;
    }

    public int getSnakes() {
        return snakes;
    }

    public void setSnakes(int snakes) {
        this.snakes = snakes;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public List<List<Integer>> getLaddersList() {
        return new ArrayList<>(laddersList);
    }

    public void setLaddersList(List<List<Integer>> laddersList) {
        this.laddersList = new ArrayList<>(laddersList);
    }

    public List<List<Integer>> getSnakesList() {
        return new ArrayList<>(snakesList);
    }

    public void setSnakesList(List<List<Integer>> snakesList) {
        this.snakesList = new ArrayList<>(snakesList);
    }

    public List<User> getUsersList() {
        return new ArrayList<>(usersList);
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = new ArrayList<>(usersList);
    }
}
