#pragma once
#include <bits/stdc++.h>


using namespace std;

class Printer{

    string resGenerator(string lenderName, string receiverName, int amount){
        return (receiverName + " owes " + lenderName + ": " +  to_string(amount) + "\n");
    }

public:
    void printExpenses(ExpenseTable *expenseTable, UserIdAndUserMap *userIdAndUserMap ){
        bool noEntry = true;
        for(auto &i : expenseTable->table){
            string lenderName = userIdAndUserMap->getUser(i.first)->name;
            for(auto &j : i.second){
                string receiverId = j.first;
                string receiverName = userIdAndUserMap->getUser(receiverId)->name; 
                int receivedAmount = j.second;
                if(receivedAmount > 0){
                    cout << resGenerator(lenderName, receiverName, receivedAmount);
                    noEntry = false;
                }
            }
        }
        if(noEntry)
            cout << "No balance\n";
    }
    void printExpenses(ExpenseTable *expenseTable, UserIdAndUserMap *userIdAndUserMap, User *user){
        bool noEntry = true;
        string lenderName = user->name;
        string lenderId = user->userId;
        for(auto &j :expenseTable->table[lenderId]){
            string receiverId = j.first;
            int receivedAmount = j.second;
            string receiverName = userIdAndUserMap->getUser(receiverId)->name;
            if(receivedAmount > 0)
                cout << resGenerator(lenderName, receiverName, receivedAmount);
            else if(receivedAmount < 0 )
                cout << resGenerator(receiverName, lenderName, -receivedAmount);
            if(receivedAmount != 0)
                noEntry = false;
        }
        if(noEntry)
            cout << "No balance\n";
    }
};