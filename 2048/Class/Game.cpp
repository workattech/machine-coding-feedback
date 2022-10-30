#pragma once
#include <bits/stdc++.h>
#include "./Constant.cpp"
#include "./Printer.cpp"
#include "./Input.cpp"
#include "./Logic.cpp"

using namespace std;

class Game{
    Input *input;
    Logic *logic;
    Printer *printer;
    int gridSize;
    bool mainLoop;
    vector<vector<int>> grid;
public:
    Game(){
        this->printer = new Printer();
        this->input = new Input();
        this->logic = new Logic();
        this->gridSize = 4;
        this->mainLoop = true;
        this->grid = vector<vector<int>> (this->gridSize, vector<int>(this->gridSize, 0));
    }

    void intializeGame(){
        this->fillRandom();
        this->fillRandom();
    }

    void startGame(){
        while(this->mainLoop){
            this->isGameWin();
            this->isGameOver();
            printer->printGrid(this->grid);
            if(!this->mainLoop) break;
            int moveType = input->input();
            this->move(moveType);
            this->fillRandom();
        }
    }

    void isGameOver(){
        bool isEmpty = true;
        for(int row = 0 ; row < this->gridSize and isEmpty ; ++row)
            for(int col = 0 ; col < this->gridSize and isEmpty ; ++col)
                if(this->grid[row][col] == 0)
                    isEmpty = false;
        if(isEmpty){
            this->mainLoop = false;
            printer->gameOver();
        }
    }

    void isGameWin(){
        for(auto &row : this->grid)
            for(auto &col : row)
                if(col == 2048){
                    this->mainLoop = false;
                    printer->gameWin();
                }
    }

    void fillRandom(){
        vector<pair<int,int>> emptyCells;
        for(int row = 0 ; row < this->gridSize ; ++row)
            for(int col = 0 ; col < this->gridSize ; ++col)
                if(this->grid[row][col] == 0)
                    emptyCells.push_back({row, col});
        if(emptyCells.empty())
            return;
        srand(time(0));
        int emptyCellCount = emptyCells.size();
        int randomCellIdx = rand() % emptyCellCount;
        pair<int, int> cell = emptyCells[randomCellIdx];
        int row = cell.first, col = cell.second;
        this->grid[row][col] = 2;
    }

    void move(int moveType){
        if(moveType == LEFT) logic->moveLeft(grid);
        else if(moveType == RIGHT ) logic->moveRight(grid);
        else if(moveType == TOP ) logic->moveTop(grid);
        else if(moveType == DOWN ) logic->moveDown(grid);
    }
};