//
// Created by ACTECH on 9/27/2020.
//

#include "SnakeGame.h"
#include<bits/stdc++.h>
using namespace std;

int main() {
    int snakes, ladders;
    cin>>snakes;
    vector<pair<int, int>> snakePos(snakes);
    for(int i=0;i<snakes;i++){
        int x,y;
        cin>>x>>y;
        snakePos[i]={x,y};
    }


    cin>>ladders;
    vector<pair<int, int>> ladderPos(ladders);
    for(int i=0;i<ladders;i++){
        int x,y;
        cin>>x>>y;
        ladderPos[i]={x,y};
    }

    int nums; //no of players
    int winners = 0;
    cin>>nums;
    vector<pair<string, bool>> players(nums); //pair<player_name, winning_status>
    for(int i=0;i<nums;i++){
        string player;
        cin>>player;
        players[i]={player, false};
    }

    int boardSize;
    cin>>boardSize;

    SnakeGame game(boardSize);
    game.setSnakes(snakePos);
    game.setLadders(ladderPos);
    bool gameEnd=false;
    while(!gameEnd){
        srand(time(nullptr));
        for(auto &player: players){
            bool nextPlayerTurn=false;
            int move = rand()%6+1;

            if(move==6){
                srand(time(nullptr));
                for(int m=1;m<=2;m++){
                    move += rand()%6+1;
                    if(move!=12)
                        break;
                }
            }
            if(move==18){ //3 consecutive sixes
                nextPlayerTurn= true;
                move=0;
            }

            if(nextPlayerTurn || player.second)
                continue;

            cout<<"Rolling Dice!!\n";
            if(game.play(player.first, move)){
                player.second=true;
                winners+=1;
            }
            if(winners==nums-1){
                gameEnd=true;
                break;
            }
        }
    }
    cout<<"Drum Rolls!! Our Winners are->\n";
    for(auto &player:players){
        if(player.second)
            cout<<player.first<<endl;
    }
}