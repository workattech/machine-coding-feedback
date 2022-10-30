#pragma once
#include<bits/stdc++.h>

using namespace std;


class Dice{
public:
    int roll(){
        return rand() % 6 + 1;
    }
};