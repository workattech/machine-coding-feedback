package org.main;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
class PlayerMove {
    private Integer initialPosition;
    private Integer finalPosition;
    private MovementCause cause;

    public PlayerMove(Integer initialPosition, Integer finalPosition, MovementCause cause) {
        this.initialPosition = initialPosition;
        this.finalPosition = finalPosition;
        this.cause = cause;
    }
}

@Getter
@Setter
@ToString
public class Player {
    private String name;
    private Integer curPosition;
    private PlayerStatus playerStatus;
    private ArrayList<PlayerMove> moves;

    public Player(String name) {
        this.name = name;
        this.curPosition = 0;
        this.playerStatus = PlayerStatus.IDLE;
        this.moves = new ArrayList<>();
    }

    public boolean won() {
        if (this.playerStatus == PlayerStatus.WON) {
            return true;
        }
        return false;
    }
}
