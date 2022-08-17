package com.machinecode.snakeandladder;

public class Player {
    private String name;
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    void play(final SnakeAndLadder snakeAndLadder) {
        int value = snakeAndLadder.getDice().roll();

        int previousPosition = this.position;
        int nextPosition = previousPosition + value;
        if (nextPosition > SnakeAndLadder.BOARD_END) {
            return;
        }
        this.position = nextPosition;

        while (true) {
            if (!snakeAndLadder.getSnakes().containsKey(this.position) && !snakeAndLadder.getLadders().containsKey(this.position)) {
                break;
            }

            if (snakeAndLadder.getSnakes().containsKey(position)) {
                this.position = snakeAndLadder.getSnakes().get(position);
            } else if (snakeAndLadder.getLadders().containsKey(position)) {
                this.position = snakeAndLadder.getLadders().get(position);
            }
        }

        System.out.println(this.name + " rolled a " + value + " and moved from " + previousPosition + " to " + this.position);

        if (this.position == SnakeAndLadder.BOARD_END) {
            System.out.println(this.name + " wins the game");
            System.exit(0);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
