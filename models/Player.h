#ifndef PLAYER_H
#define PLAYER_H

#include <string>

class Player {
public:
    std::string name;
    int currPos;

    Player();
    Player(std::string str);
};

Player :: Player() {
    this->name = "Default";
}

Player :: Player(std::string str) {
    this->name = str;
}

#endif // PLAYER_H
