#pragma once
#include <bits/stdc++.h>
#include "./Piece.cpp"
#include "./Constant.cpp"
#include "./Printer.cpp"

using namespace std;


class Game{
    vector<vector<Piece*>> board;
    bool mainLoop;
    pair<int,int> curCell, nextCell;
    string curPlayer;
    Printer *printer;
    string inputStr;
public:
    Game(){
        curPlayer = WHITE;
        mainLoop = true;
        board = vector<vector<Piece*>>(8, vector<Piece*>(8, NULL));
        printer = new Printer;
    }

    void startGame(){
        fillBoard();
        printer->printBoard(this->board);
        eventLoop();
    }

    void fillBoard(){
        // Black
        for(int i = 0 ; i < 8 ; ++i)
            this->board[1][i] = new Piece(BLACK, P);
        this->board[0][0] = new Piece(BLACK, R);
        this->board[0][7] = new Piece(BLACK, R);
        this->board[0][1] = new Piece(BLACK, N);
        this->board[0][6] = new Piece(BLACK, N);
        this->board[0][2] = new Piece(BLACK, B);
        this->board[0][5] = new Piece(BLACK, B);
        this->board[0][3] = new Piece(BLACK, Q);
        this->board[0][4] = new Piece(BLACK, K);

        // White
        for(int i = 0 ; i < 8 ; ++i)
            this->board[6][i] = new Piece(WHITE, P);
        this->board[7][0] = new Piece(WHITE, R);
        this->board[7][7] = new Piece(WHITE, R);
        this->board[7][1] = new Piece(WHITE, N);
        this->board[7][6] = new Piece(WHITE, N);
        this->board[7][2] = new Piece(WHITE, B);
        this->board[7][5] = new Piece(WHITE, B);
        this->board[7][3] = new Piece(WHITE, Q);
        this->board[7][4] = new Piece(WHITE, K);
    }

    void eventLoop(){
        while(mainLoop){
            input();
            if(mainLoop == false)
                break;
            if(isValidAndMove()){
                this->curPlayer = (this->curPlayer == WHITE ? BLACK : WHITE);
                printer->printBoard(this->board);
            }
            else
                printer->invalidMove();
        }
    }

    pair<int,int> moveConverter(string s){
        int col = int(s[0] - 'a');
        int row = 7 - (s[1] - '1');
        return make_pair(row, col);
    }
    void input(){
        getline(cin, inputStr);
        if(inputStr.size() == 4){
            this->mainLoop = false;
            return;
        }
        string curCell = inputStr.substr(0, 2);
        string nextCell = inputStr.substr(3, 2);
        this->curCell = moveConverter(curCell);
        this->nextCell = moveConverter(nextCell);
    }

    bool isValidAndMove(){
        int curRow = this->curCell.first, curCol = this->curCell.second;
        int nextRow = this->nextCell.first, nextCol = this->nextCell.second;
        Piece *curPiece = this->board[curRow][curCol];
        if(curPiece == NULL || curPiece->color != this->curPlayer)
            return false;
        if(board[nextRow][nextCol] != NULL and board[nextRow][nextCol]->color == curPiece->color)
            return false;
        return curPiece->move(this->board, this->curCell, this->nextCell);
    }
};