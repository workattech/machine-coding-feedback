package com.app.models;

import java.util.Deque;
import java.util.List;

public class Game
{
    private Board board;
    private Die die;
    private Deque<Player> players;

    public Game(int boardSize, List<Jump> snakes, List<Jump> ladders, int numberOfDies, Deque<Player> players) {
        this.board = new Board(boardSize, snakes, ladders);
        this.die = new Die(0, 6, numberOfDies);
        this.players = players;
    }




    public void startGame()
    {
        int rank = 0;
        System.out.println("Start");
        while (true) {
            while (players.size()>1) {
                Player player =  players.poll();

                int movements = player.makeMove(die);
                int newPosition = board.updatePlayerPosition(player.getCurrentPosition(), movements);
                if (newPosition !=  player.getCurrentPosition())
                {
                    System.out.println(player.getName()+" moved from "+player.getCurrentPosition()+" to "+newPosition);
                }
                else
                {
                    System.out.println(player.getName()+" didn't move from "+player.getCurrentPosition());
                }

                player.setCurrentPosition(newPosition);
                if (checkWinner(player))
                {
                    rank++;
                    System.out.println(player.getName()+" wins  the Game! with rank "+rank);
                }
                else
                {
                    players.add(player);
                }
            }

            if (players.size()==1)
            {
                Player lastPlayer = players.poll();
                System.out.println(lastPlayer.getName()+" Loses!!");
                System.out.println("END");
                break;
            }
        }
    }

    private boolean checkWinner(Player player)
    {
        return (player.getCurrentPosition() == board.getSize());
    }

}
