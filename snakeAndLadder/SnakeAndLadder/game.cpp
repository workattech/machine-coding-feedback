#pragma once
#include<bits/stdc++.h>
#include "./Models/dice.cpp"
#include "./Models/ladder.cpp"
#include "./Models/snake.cpp"
#include "./Models/player.cpp"
#include "./Models/board.cpp"

using namespace std;

class Game{
    public:
        Board *board;
        bool mainLoop;

    Game(Board *board){
        mainLoop = true;
        this->board = board;
    }

    void start(){
        while(mainLoop)
            mainLoop = board->move();
    }
};
