#pragma once
#include <bits/stdc++.h>
#include "./Piece.cpp"
#include "./Constant.cpp"
using namespace std;

class Printer{
public:
    void printBoard(vector<vector<Piece*>> &board){
        for(auto &row : board){
            for(auto &piece : row){
                if(piece == NULL) cout << "--";
                else cout << (piece->color + piece->type);
                cout << " ";
            }
            cout << "\n";
        }
        cout << "\n";
    }
    void invalidMove(){
        cout << "Invalid Move\n";
    }
};
