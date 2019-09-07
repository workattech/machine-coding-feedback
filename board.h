#pragma once
#include <string>
#include <vector>
#include <fstream>

// abstract parent class for both snakes and ladders
// they just modify the positions differently, that's why I have used virtual function for it
class Snake_Ladder
{
protected:
    int low, high;

public:
    Snake_Ladder(int l, int h) : low(l), high(h) {}
    virtual int modifyPosition(int pos) = 0;
};

class Snake : public Snake_Ladder
{
public:
    Snake(int l, int h) : Snake_Ladder(l, h) {}
    int modifyPosition(int pos) override
    {
        return (pos == high) ? low : pos;
    }
};

class Ladder : public Snake_Ladder
{
public:
    Ladder(int l, int h) : Snake_Ladder(l, h) {}
    int modifyPosition(int pos) override
    {
        return (pos == low) ? high : pos;
    }
};

class GamePlayer
{
    std::string name;
    int curr_position;
    bool isActive;

public:
    GamePlayer(std::string s) : name(s), curr_position(0), isActive(true) {}
    std::string getName()
    {
        return name;
    }
    int getCurrPosition()
    {
        return curr_position;
    }
    void updatePosition(int p)
    {
        curr_position = p;
    }
    bool getActiveStatus()
    {
        return isActive;
    }
    void setActiveStatus(bool status)
    {
        isActive = status;
    }
    int rollDice();
};

class Board
{
    std::vector<Snake_Ladder *> components;
    std::vector<GamePlayer *> players;
    std::ifstream in_path;
    std::ofstream out_path;
    int size;

    void initiateBoardGame();

public:
    Board(std::string inputFilePath, std::string outputFilePath);
    void restartGame();
    void startGame();
};