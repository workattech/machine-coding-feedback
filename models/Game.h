#ifndef GAME_H
#define GAME_H

#include "Player.h"
#include <vector>
#include <iostream>
#include <random>
#include <string>

class Game {
private:
    std::vector<int> pos;
    std::vector<Player*> players;
    int BOARD_SIZE;

public:
    Game(int customBoardSize = 100);

    int board_size();
    void take_input();
    int roll_dice();
    void reset_players();
    void play();
};

Game::Game(int customBoardSize) {
    BOARD_SIZE = customBoardSize;
    pos.resize(BOARD_SIZE + 1);
    for (int i = 1; i <= BOARD_SIZE; i++)
        pos[i] = i;
}

// Getter for board size
int Game::board_size() {
    return BOARD_SIZE;
}

// Function for taking input for snakes, ladders, and players
void Game::take_input() {
    int snakeCnt, ladderCnt, playerCnt, sPos, ePos;
    std::string name;
    
    std::cout << "Enter the number of snakes: ";
    std::cin >> snakeCnt;
    std::cout << "Enter the positions of snakes (start and end): ";
    for (int i = 0; i < snakeCnt; i++) {
        std::cin >> sPos >> ePos;
        pos[sPos] = ePos;
    }

    std::cout << "Enter the number of ladders: ";
    std::cin >> ladderCnt;
    std::cout << "Enter the positions of ladders (start and end): ";
    for (int i = 0; i < ladderCnt; i++) {
        std::cin >> sPos >> ePos;
        pos[sPos] = ePos;
    }

    std::cout << "Enter the number of players: ";
    std::cin >> playerCnt;
    std::cout << "Enter the names of players: ";
    for (int i = 0; i < playerCnt; i++) {
        std::cin >> name;
        Player* newPlayer = new Player(name);
        newPlayer->currPos = 1;
        players.push_back(newPlayer);
    }

}

// Function for rolling dice
int Game::roll_dice() {
    std::random_device rd;
    std::mt19937 mt(rd());
    std::uniform_int_distribution<int> dist(1, 6);
    return dist(mt);
}

// Function for resetting player positions
void Game::reset_players() {
    for (auto player : players)
        player->currPos = 1;
}

// Function to start playing the game
void Game::play () {
    std::cout << "Playing...\n\n";

    while (1) {
        for (auto player:players) {
            int curr = player->currPos;
            int roll = roll_dice();
            if (curr + roll > 100)  continue;
            int next = pos[curr + roll];

            std::cout << player->name << " rolled a " << roll << " and moved from " << curr << " to " << next << "\n";
            if (next == 100) {
                std::cout << player->name << " wins the game\n";
                reset_players();
                return;
            }
            else {
                player->currPos = next;
            }
        }
    }
}

#endif