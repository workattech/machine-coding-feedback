//
//  main.cpp
//  Snake Ladder Mock
//
//  Created by Sandip Kumar Yadav on 29/10/20.
//  Copyright © 2020 Sandip Kumar Yadav. All rights reserved.
//

#include <iostream>
#include <map>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

int findNextPosition(int currPosition, int stepsToTravel, map<int, int> snakes, map<int, int> ladder){
    // greater than 100
    if(currPosition + stepsToTravel > 100){
        return currPosition;
    }
    // is 100
    if(currPosition + stepsToTravel == 100){
        return 100;
    }
    int nextPos = currPosition + stepsToTravel;
    // is snakes head while
    if(snakes.find(nextPos) != snakes.end()){
        nextPos = snakes[nextPos];
        return findNextPosition(nextPos, 0, snakes, ladder);
    }
    // is ladder head while
    if(ladder.find(nextPos) != ladder.end()){
        nextPos = ladder[nextPos];
        return findNextPosition(nextPos, 0, snakes, ladder);
    }
    return nextPos;
}

int getNextTurn(){
    int randomNumber = (rand() % 6) + 1;
    if(randomNumber == 6){
        randomNumber = randomNumber + ((rand() % 6) + 1);
        if(randomNumber == 12){
            randomNumber = randomNumber + ((rand() % 6) + 1);
            if(randomNumber == 18){
                return getNextTurn();
            }
        }
    }
    return randomNumber;
}

int getNextPlayerTurn(int playerTurn, bool *isInGame, int noOfPlayers){
    int nextPlayer = (playerTurn + 1) % noOfPlayers;
    if(isInGame[nextPlayer]){
        return nextPlayer;
    }
    else{
        return getNextPlayerTurn(nextPlayer, isInGame, noOfPlayers);
    }
}

int main(int argc, const char * argv[]) {
    int noSnakes, noLadder, start, end;
    map<int, int> snakes, ladder;
    cin >> noSnakes ;
    while(noSnakes--){
        cin >> start >> end;
        snakes[start] = end;
    }
    cin >> noLadder ;
    while(noLadder--){
        cin >> start >> end;
        ladder[start] = end;
    }
    int noOfPlayers;
    cin >> noOfPlayers;
    string *player = new string[noOfPlayers];
    int *pos = new int[noOfPlayers];
    bool *isInGame = new bool[noOfPlayers];
    for(int i = 0; i < noOfPlayers; i++){
        cin >> player[i];
        pos[i] = 0;
        isInGame[i] = true;
    }
    int randomNo, playerTurn = 0;
    int playersRemaining = noOfPlayers;
    while(playersRemaining != 0){
        randomNo = getNextTurn();
        cout << player[playerTurn] << " rolled a " << randomNo << " and moved from " << pos[playerTurn] <<" to ";
        pos[playerTurn] = findNextPosition(pos[playerTurn], randomNo, snakes, ladder);
        cout << pos[playerTurn] << "\n";
        if(pos[playerTurn] == 100){
            cout << player[playerTurn] << " wins the game\n";
            isInGame[playerTurn] = false;
            playersRemaining--;
        }
        if(playersRemaining != 0){
            playerTurn = getNextPlayerTurn(playerTurn, isInGame, noOfPlayers);
        }
    }
    return 0;
}










