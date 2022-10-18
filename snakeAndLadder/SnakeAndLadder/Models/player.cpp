#pragma once
#include<bits/stdc++.h>

using namespace std;

class Player{

public:
    string userId;
    string name;
    Player(string userId, string name){
        this->userId = userId;
        this->name = name;
    }
};