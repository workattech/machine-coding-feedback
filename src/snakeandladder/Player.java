/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

/**
 *
 * @author rails
 */
public class Player {
    private final String name;
    private int position;
    
    Player(String name){
        this.name = name;
        this.position = 0;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getPosition(){
        return this.position;
    }
    
    public void setPosition(int position){
        this.position = position;
    }
}
