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
public class Snake {
    private final int head;
    private final int tail;
    
    Snake (int head, int tail){
        this.head = head;
        this.tail = tail;
    }
    
    public int getHead(){
        return this.head;
    }
    
    public int getTail(){
        return this.tail;
    }
}
