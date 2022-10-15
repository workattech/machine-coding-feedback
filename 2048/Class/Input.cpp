#pragma once
#include <bits/stdc++.h>

using namespace std;


class Input{
public:
    int input(){
        int move;
        cout << "Enter move left right top down:- ";
        cin >> move;
        return move;
    }
};