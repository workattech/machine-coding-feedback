#pragma once
#include <bits/stdc++.h>
#include "./Constant.cpp"

using namespace std;


class Piece{

    bool pawnMove(vector<vector<Piece*>> &board, pair<int,int> &curCell, pair<int,int> &nextCell){
        int curRow = curCell.first, curCol = curCell.second;
        int nextRow = nextCell.first, nextCol = nextCell.second;
        if(this->color == WHITE){
            // starting step
            if(curRow == 6){
                // single step
                if( curCol == nextCol and
                    curRow - nextRow == 1 and 
                    board[curRow - 1][curCol] == NULL
                ){
                    board[nextRow][nextCol] = board[curRow][curCol];
                    board[curRow][curCol] = NULL;
                    return true;
                }
                // double step 
                if( curCol == nextCol and
                    curRow - nextRow == 2 and
                    board[curRow - 1][curCol] == NULL and
                    board[curRow - 2][curCol] == NULL
                ){
                    board[nextRow][nextCol] = board[curRow][curCol];
                    board[curRow][curCol] = NULL;
                    return true;
                } 
            }
            // takedown
            if( curRow - nextRow == 1 and
                abs(curCol - nextCol) == 1 and
                board[nextRow][nextCol] != NULL and 
                board[nextRow][nextCol]->color != this->color
            ){
                board[nextRow][nextCol] = board[curRow][curCol];
                board[curRow][curCol] = NULL;
                return true;
            } 
        }
        else{
            // starting step
            if(curRow == 1){
                // single step
                if( curCol == nextCol and
                    nextRow - curRow == 1 and 
                    board[curRow + 1][curCol] == NULL
                ){
                    board[nextRow][nextCol] = board[curRow][curCol];
                    board[curRow][curCol] = NULL;
                    return true;
                }
                // double step 
                if( curCol == nextCol and
                    nextRow - curRow == 2 and
                    board[curRow + 1][curCol] == NULL and
                    board[curRow + 2][curCol] == NULL
                ){
                    board[nextRow][nextCol] = board[curRow][curCol];
                    board[curRow][curCol] = NULL;
                    return true;
                }
            }
            // takedown
            if( nextRow - curRow == 1 and
                abs(curCol - nextCol) == 1 and
                board[nextRow][nextCol] != NULL and
                board[nextRow][nextCol]->color != this->color
            ){
                board[nextRow][nextCol] = board[curRow][curCol];
                board[curRow][curCol] = NULL;
                return true;
            } 
        }
        return false;
    }

    bool knightMove(vector<vector<Piece*>> &board, pair<int,int> &curCell, pair<int,int> &nextCell){
        int curRow = curCell.first, curCol = curCell.second;
        int nextRow = nextCell.first, nextCol = nextCell.second;
        int rows[] = {-2,-1,+1,+2,+2,+1,-1,-2};
        int cols[] = {+1,+2,+2,+1,-1,-2,-2,-1};
        for(int i = 0 ; i < 8 ; ++i)
            if( curRow + rows[i] == nextRow and curCol + cols[i] == nextCol ){
                if(board[nextRow][nextCol] == NULL || board[nextRow][nextCol]->color != this->color ){
                    board[nextRow][nextCol] = board[curRow][curCol];
                    board[curRow][curCol] = NULL;
                    return true;
                }
                return false;
            }
        return false;
    }
   
    bool rookMove(vector<vector<Piece*>> &board, pair<int,int> &curCell, pair<int,int> &nextCell){
        int curRow = curCell.first, curCol = curCell.second;
        int nextRow = nextCell.first, nextCol = nextCell.second;

        if(curRow != nextRow and curCol != nextCol)
            return false;

        if(curRow == nextRow)
            for(int i = 1; i < abs(curCol - nextCol) - 1; i++ )
                if(board[curRow][curCol+( curCol < nextCol ? +i : -i )] != NULL)
                    return false;
        else if(curCol == nextCol)
            for(int i = 1; i < abs(curRow - nextRow) - 1; i++ )
                if(board[curRow +( curRow < nextRow ? +i : -i )][curCol] != NULL)
                    return false;

        if(board[nextRow][nextCol] == NULL || board[nextRow][nextCol]->color != this->color){
            board[nextRow][nextCol] = board[curRow][curCol];
            board[curRow][curCol] = NULL;
            return true;
        }
        return false;
    }

    bool bishopMove(vector<vector<Piece*>> &board, pair<int,int> &curCell, pair<int,int> &nextCell){
        int curRow = curCell.first, curCol = curCell.second;
        int nextRow = nextCell.first, nextCol = nextCell.second;
        if(abs(curRow - nextRow) != abs(curCol - nextCol))
            return false;
        int dis = abs(curRow - nextRow);
        int rowMul = (curRow < nextRow ? +1 : -1);
        int colMul = (curCol < nextCol ? +1 : -1);
        for(int i = 1 ; i < dis - 1 ; ++i)
            if(board[curRow + rowMul*i][curCol + colMul*i ] != NULL)
                return false;
        if(board[nextRow][nextCol] == NULL || board[nextRow][nextCol]->color != this->color){
            board[nextRow][nextCol] = board[curRow][curCol];
            board[curRow][curCol] = NULL;
            return true;
        } 
        return false;
    }
    
    bool queenMove(vector<vector<Piece*>> &board, pair<int,int> &curCell, pair<int,int> &nextCell){
        return rookMove(board, curCell, nextCell) || bishopMove(board, curCell, nextCell);
    }
    
    bool kingMove(vector<vector<Piece*>> board, pair<int,int> &curCell, pair<int,int> &nextCell){
        int curRow = curCell.first, curCol = curCell.second;
        int nextRow = nextCell.first, nextCol = nextCell.second;
        if(abs(curRow - nextRow) <= 1 and abs(curCol - nextCol) <= 1){
            if(board[nextRow][nextCol] == NULL || board[nextRow][nextCol]->color != this->color){
                board[nextRow][nextCol] = board[curRow][curCol];
                board[curRow][curCol] = NULL;
                return true;
            }
        }
        return false;
    }

public:
    string color;
    string type;
    Piece(string color, string type){
        this->color = color;
        this->type = type;
    }

    bool move(vector<vector<Piece*>> &board, pair<int,int> &curCell, pair<int,int> &nextCell){
        if(this->type == P) return pawnMove(board, curCell, nextCell);
        if(this->type == R) return rookMove(board, curCell, nextCell);
        if(this->type == N) return knightMove(board, curCell, nextCell);
        if(this->type == B) return bishopMove(board, curCell, nextCell);
        if(this->type == Q) return queenMove(board, curCell, nextCell);
        if(this->type == K) return kingMove(board, curCell, nextCell);
        return false;
    }
};