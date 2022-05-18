package models;

import java.util.UUID;

public class User {

    private UUID id;

    private String name;

    public User(final String name){
        this.name = name;
        id = UUID.randomUUID();
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
