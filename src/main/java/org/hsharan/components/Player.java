package org.hsharan.components;

import java.util.*;

public class Player {
    private String name;
    private Integer id;

    private Integer position;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static Map<Integer,Player> players = new LinkedHashMap<>();


    private static Integer idCounter=0;

    public Player(String name) {
        this.name = name;
        idCounter+=1;
        this.id= idCounter;

        players.put(this.id,this);
    }



    public static List<Player> getAllPlayer() {
        return new ArrayList<Player>(players.values());
    }
}
