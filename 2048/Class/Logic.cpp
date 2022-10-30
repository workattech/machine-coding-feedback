#pragma once
#include <bits/stdc++.h>
using namespace std;


class Logic{
    //  common function to move down
    // rotations and flips are used to use this method as a base logic
    void move(vector<vector<int>> &grid){
        for(int col = 0 ; col < grid.size() ; ++col){
            queue<int> q;
            for(int row = grid.size() - 1 ; row >= 0 ; --row)
                if(grid[row][col] != 0)
                    q.push(grid[row][col]);
            for(int row = grid.size() - 1 ; row >= 0 ; --row)
                if(q.empty())
                    grid[row][col] = 0;
                else{
                    int value = q.front(); q.pop();
                    if(q.empty() == false and q.front() == value){
                        value *= 2;
                        q.pop();
                    }
                    grid[row][col] = value;
                }
        }
    }
    

    void flipTopToBottom(vector<vector<int>> &grid){
        for(int col = 0 ; col < grid.size() ; ++col){
            int rowStart = 0, rowEnd = grid.size() - 1;
            while(rowStart < rowEnd)
                swap(grid[rowStart++][col], grid[rowEnd--][col]);
        }
    }

    void rotateAntiClockWise(vector<vector<int>> &grid){
        int n = grid.size();
        vector<vector<int>> temp(n, vector<int>(n, 0));
        for(int row = 0 ; row < n ; ++row)
            for(int col = 0 ; col < n ; ++col)
                temp[n-1-col][row] = grid[row][col];
        grid = temp;
    }

    void rotateClockWise(vector<vector<int>> &grid){
        int n = grid.size();
        vector<vector<int>> temp(n, vector<int>(n, 0));
        for(int row = 0 ; row < n ; ++row)
            for(int col = 0 ; col < n ; ++col)
                temp[col][n-1-row] = grid[row][col];
        grid = temp;
    }

public:
    void moveDown(vector<vector<int>> &grid){
        move(grid);
    }

    void moveTop(vector<vector<int>> &grid){
        flipTopToBottom(grid);
        move(grid);
        flipTopToBottom(grid);
    }

    void moveLeft(vector<vector<int>> &grid){
        rotateAntiClockWise(grid);
        move(grid);
        rotateClockWise(grid);
    }

    void moveRight(vector<vector<int>> &grid){
        rotateClockWise(grid);
        move(grid);
        rotateAntiClockWise(grid);
    }
};