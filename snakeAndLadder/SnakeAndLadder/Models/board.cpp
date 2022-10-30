#pragma once
#include<bits/stdc++.h>
#include "./dice.cpp"
#include "./ladder.cpp"
#include "./snake.cpp"
#include "./player.cpp"

using namespace std;

class Board{
public:
    int boardSize;
    int numberOfDice;
    vector<Ladder*> ladders;
    vector<Snake*> snakes;

    vector<Object*> board;
    vector<Dice*> dices;
    map<string, Player*> players;

    map<string, int> playerPostion;

    Board( int boardSize, int numberOfDice, vector< Ladder* > &ladders, vector < Snake* > &snakes, vector<Player*> players){
        this->boardSize =  boardSize;
        this->numberOfDice = numberOfDice;

        this->ladders = ladders;
        this->snakes = snakes;
        
        board = vector<Object*>(boardSize, NULL);

        for(auto &ladder : ladders)
            board[ladder->start] = ladder;

        for(auto &snake : snakes)
            board[snake->start] = snake;


        for(auto &player : players){
            playerPostion[player->userId] = 0; 
            this->players[player->userId] = player;
        }

        for(int i = 0 ; i < numberOfDice ; ++i)
            dices.push_back(new Dice());
    }

    bool move(){
        for(auto &playerPos : playerPostion){
            string userId = playerPos.first;
            int curPos = playerPos.second;
            int moves = rollDices();
            int endPos = curPos + moves;

            if(endPos > 100) continue;

            while(board[endPos] != NULL)
                endPos = board[endPos]->end;
            playerPostion[userId] = endPos;
            cout << players[userId]->name << " rolled a " << moves << " from " <<  curPos << " to " << endPos << "\n"; 
            
            if(endPos == 100){
                cout << players[userId]->name << " wins the game\n";
                return false;
            }
        }
        return true;
    }

    int rollDices(){
        int ans = 0;
        for(auto &dice : dices)
            ans += dice->roll();
        return ans;
    }
};
