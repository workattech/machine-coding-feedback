package org.hsharan;

import org.hsharan.components.Game;
import org.hsharan.components.Ladder;
import org.hsharan.components.Player;
import org.hsharan.components.Snake;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        Integer snakeNumber = Integer.parseInt(bfr.readLine());
        for(int i=0;i<snakeNumber;i++){
            Integer [] num = Arrays.stream(bfr.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            new Snake(num[0],num[1]);
        }
        Integer ladderNumber = Integer.parseInt(bfr.readLine());
        for (int i=0;i<ladderNumber;i++){
            Integer[] num = Arrays.stream(bfr.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            new Ladder(num[0],num[1]);
        }
        Integer playerCount = Integer.parseInt(bfr.readLine());
        for(int i=0;i<playerCount;i++){
            new Player(bfr.readLine());
        }
        System.out.println("Winner Is :"+ Game.playGame().getName());
    }
}