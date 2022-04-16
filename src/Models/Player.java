package Models;

import java.util.*;
import Models.PlayerStatus;

public class Player {
    private String name, status;
    private int id, position, rank;

    public Player (String name) {
        this.name = name;
        this.id = (int)(Math.random() * 1000);
        this.position = 0;
        this.status = PlayerStatus.PLAYING;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public String getStatus() {
        return this.status;
    }

    public int getPosition() {
        return this.position;
    }

    public int getRank() {
        return this.rank;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}