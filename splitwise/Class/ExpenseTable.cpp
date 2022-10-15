#pragma once
#include <bits/stdc++.h>
#include "./Expenses.cpp"

using namespace std;

class ExpenseTable{
public:
    map<string, map<string, int>> table;
    void  addExpenses(Expenses *expenses){
        string from = expenses->owesTo->userId;
        for(auto i : expenses->owerAndAmount){
            string to = i.first->userId;
            int curAmount = i.second;
            int amount  = curAmount + table[from][to];
            if(from == to) continue;
            table[from][to] = amount;
            table[to][from] = -amount;
        }
    }
};

