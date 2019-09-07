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
public class Ladder {
    private final int start;
    private final int end;
    
    Ladder (int start, int end){
        this.start = start;
        this.end = end;
    }
    
    public int getStart(){
        return this.start;
    }
    
    public int getEnd(){
        return this.end;
    }
}
