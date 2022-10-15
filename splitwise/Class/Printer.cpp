#pragma once
#include <bits/stdc++.h>


using namespace std;

class Printer{
public:
    void printExpenses(ExpenseTable *expenseTable, UserIdAndUserMap *userIdAndUserMap ){
        bool noEntry = true;
        for(auto &i : expenseTable->table){
            string userName = userIdAndUserMap->getUser(i.first)->name;
            for(auto &j : i.second){
                string owes = j.first;
                if(j.second > 0){
                    cout << userIdAndUserMap->getUser(owes)->name  << " owes " << userName << ": " <<  j.second << "\n";
                    noEntry = false;
                }
            }
        }
        if(noEntry)
            cout << "No balance\n";
    }

    void printExpenses(ExpenseTable *expenseTable, UserIdAndUserMap *userIdAndUserMap, User *user){
        bool noEntry = true;
        string userName = user->name;
        string userId = user->userId;
        for(auto &j :expenseTable->table[userId]){
            string owes = j.first;
            if(j.second > 0){
                cout << userIdAndUserMap->getUser(j.first)->name << " owes " << userName << ": " << j.second << "\n";
                noEntry = false;
            }
            else if(j.second < 0 ){
                cout << userName  << " owes " <<  userIdAndUserMap->getUser(j.first)->name << ": " << -j.second << "\n";
                noEntry = false;
            }
        }
        if(noEntry)
            cout << "No balance\n";
    }
};