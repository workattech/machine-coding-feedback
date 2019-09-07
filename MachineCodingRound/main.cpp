#include <iostream>
#include<bits/stdc++.h>

using namespace std;


class snake
{
public:
    int head;
    int tail;

    snake(int headOfSnakes, int tailOfSnakes)
    {
        head = headOfSnakes;
        tail = tailOfSnakes;
    }

};

class ladder
{
public:
    int start_positions;
    int end_positions;
    ladder(int start,int end)
    {
        start_positions = start;
        end_positions = end;
    }
};

class player
{
public:
    string playerName;
    int curPositions;
    player(string name)
    {
        playerName = name;
        curPositions =0;
    }
};

class Dice {
    public:
        Dice(){
             srand(time(NULL));
        }
    int roolDice(){

        return rand()%6+1;
    }
};
class snakeAndLadderGame
{   public:
    int numberOfSnakes;
    int numberOfladders;
    int numberOfPlayers;
    vector<snake> snakes;
    vector<ladder> ladders;
    vector<player> players;
    bool isGameRunning ;
    Dice dice ;
    void input()
    {
        cin>>numberOfSnakes;
        int headOfSnake, tailOfSnake;
        for(int i=0; i<numberOfSnakes; i++)
        {
            cin>>headOfSnake>>tailOfSnake;
            snake inputSnake =  snake(headOfSnake,tailOfSnake);
            snakes.push_back(inputSnake);
        }
        cin>>numberOfladders;
        int startPositions,endPositions;
        for(int i=0; i<numberOfladders; i++)
        {
            cin>>startPositions>>endPositions;
            ladder inputLadder  =  ladder(startPositions, endPositions);
            ladders.push_back(inputLadder);
        }

        cin>>numberOfPlayers;
        string name ;
        for(int i=0; i<numberOfPlayers; i++)
        {
            cin>>name;
            player p = player(name);
            players.push_back(p);

        }
        isGameRunning = true;
        dice = Dice();
    }
    void startGame(){
        while(isGameRunning){
            for(int i=0;i<players.size();i++){
                    player p = players[i];
                int diceOutcome = dice.roolDice();
                int curPositions = p.curPositions+diceOutcome;

                if(curPositions ==100){
                    cout<<p.playerName + " wins the game";
                    isGameRunning =false;
                    return ;
                }
                else if(curPositions > 100){
                    continue;
                }
                else{
                    for(int j=0;j<ladders.size();j++){
                        if(curPositions == ladders[j].start_positions)
                            curPositions = ladders[j].end_positions;
                    }
                    for(int j=0;j<snakes.size();j++){
                        if(curPositions == snakes[j].head)
                            curPositions = snakes[j].tail;
                    }
                    cout<<p.playerName + "rolled a "<<diceOutcome <<" and moved from "<<curPositions <<" to "<< curPositions<<endl;
                    players[i].curPositions = curPositions;

                }

            }
        }
    }
};
int main()
{
    snakeAndLadderGame game  = snakeAndLadderGame();
    game.input();
    game.startGame();
   // cout << "Hello world! "  << "x"<< endl;
    return 0;
}
