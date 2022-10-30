#pragma once
#include <bits/stdc++.h>

using namespace std;


class Printer{
public:
    void printGrid(vector<vector<int>> &grid){
        for(auto &row : grid){
            for(auto &col : row){
                if(col == 0)
                    cout << setw(4) << "-";
                else    
                    cout << setw(4) << col;
                cout << " ";
            }
            cout << "\n";
        }
    }

    void gameWin(){
        cout << "Congratulations\n";
    }

    void gameOver(){
        cout << "Game over\n";
    }

};