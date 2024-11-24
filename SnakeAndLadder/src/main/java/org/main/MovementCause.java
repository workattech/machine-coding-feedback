package org.main;

import lombok.Getter;

@Getter
public enum MovementCause {
    SNAKE_BITE("Snake bite"),
    GOT_LADDER("Got Ladder"),
    DICE("Dice");

    MovementCause(String description) {
        this.description = description;
    }

    private String description;
}
