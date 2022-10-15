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
        string typeOfLending = cmd[4 + numOfOwner];
        Expenses expenses;
        if(typeOfLending == EQUAL)
            expenses.equalExpenses(userIdAndUserMap, cmd);
        else if(typeOfLending == EXACT)
            expenses.exactExpenses(userIdAndUserMap, cmd);
        else if(typeOfLending == PERCENT)
            expenses.percentExpenses(userIdAndUserMap, cmd);
        expenseTable.addExpenses(&expenses);
    }

    void processCommand(string s){
        vector<string> cmd = command.process(s);
        const string typeOfCommand = cmd[0];
        if(typeOfCommand == SHOW){
            if(cmd.size() == 1) this->showExpenses();
            else this->showExpenses(cmd[1]);
            cout << "\n";
        }
        else if(typeOfCommand == EXPENSE)
            this->addExpenses(cmd);
    }
};