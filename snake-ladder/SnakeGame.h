//
// Created by ACTECH on 9/27/2020.
//
#include <bits/stdc++.h>
using namespace std;

#ifndef SNAKE_LADDER_SNAKEGAME_H
#define SNAKE_LADDER_SNAKEGAME_H


class SnakeGame{
private:
    int boardSize;
    map<int, int> snakes, ladders;
    map<string, int> playerPosition;
public:
    SnakeGame(int boardSize){
        cout<<"got board size "<<boardSize<<endl;
        this->boardSize = boardSize;
        cout<<"Welcome to Snake Ladder Game!!\n";
    }
    void setSnakes( const vector<pair<int, int>>& snakesPositions){
        cout<<"Setting snakes\n";
        for(auto snake:snakesPositions){
            snakes[snake.first] = snake.second;
        }
    }
    void setLadders( const vector<pair<int, int>>& laddersPositions){
        cout<<"Setting ladders\n";
        for(auto ladder:laddersPositions){
            ladders[ladder.first] = ladder.second;
        }
    }
    void setPlayers(const vector<string>& players){
        cout<<"Setting up for players!\n";
        for(const auto& player:players){
            playerPosition[player] = 0;
        }
    }

    int play(const string& player, int move){
        int currPos = playerPosition[player];
        int movedPos = currPos+move;
        cout<<player<<" rolled a "<<move<<" and moved from "<<currPos<<" to "<<(movedPos<=boardSize?movedPos:currPos)<<endl;
        if(movedPos>boardSize)
            return 0;
        if(snakes.find(movedPos)!=snakes.end()) {
            cout<<"Oh no1 Snake Gobbled "<<player<<endl;
            movedPos = snakes[movedPos];
        }
        if(ladders.find(movedPos)!=ladders.end()) {
            cout<<"YESS! Got a ladder "<<player<<endl;
            movedPos = ladders[movedPos];
        }
        playerPosition[player] = movedPos;
        if(movedPos==boardSize){
            cout<<"Yay! We have a winner in "<<player<<endl;
            return 1;
        }
        else{
            return 0;
        }
    }
};


#endif //SNAKE_LADDER_SNAKEGAME_H
