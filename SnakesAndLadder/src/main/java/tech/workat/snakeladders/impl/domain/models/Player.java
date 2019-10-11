package tech.workat.snakeladders.impl.domain.models;

import java.util.UUID;

public class Player {

    private String name;

    private UUID id;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
