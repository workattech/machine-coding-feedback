#pragma once
#include <bits/stdc++.h>
#include "./UserIdAndUserMap.cpp"
#include "./ExpenseTable.cpp"
#include "./Printer.cpp"
#include "./Command.cpp"
#include "./Constants.cpp"

using namespace std;

class Splitwise{
public:
    UserIdAndUserMap userIdAndUserMap;
    ExpenseTable expenseTable;
    Printer printer;
    Command command;

    void addUser(User *user){
        userIdAndUserMap.addUser(user);
    }
    void showExpenses(){
        printer.printExpenses(&expenseTable, &userIdAndUserMap);
    }
    void showExpenses(string userId){
        printer.printExpenses(&expenseTable, &userIdAndUserMap, userIdAndUserMap.getUser(userId));
    }
    
    void addExpenses(vector<string> &cmd){
        int numOfOwner = stoi(cmd[3]);
        string type = cmd[4 + numOfOwner];
        Expenses expenses;
        if(type == EQUAL)
            expenses.equalExpenses(userIdAndUserMap, cmd);
        else if(type == EXACT)
            expenses.exactExpenses(userIdAndUserMap, cmd);
        else if(type == PERCENT)
            expenses.percentExpenses(userIdAndUserMap, cmd);
        expenseTable.addExpenses(&expenses);
    }
    void processCommand(string s){
        vector<string> cmd = command.process(s);
        if(cmd[0] == SHOW){
            if(cmd.size() == 1) this->showExpenses();
            else this->showExpenses(cmd[1]);
            cout << "\n";
        }
        else if(cmd[0] == EXPENSE){
            this->addExpenses(cmd);
        }
    }
};