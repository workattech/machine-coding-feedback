#pragma once
#include <bits/stdc++.h>
#include "./User.cpp"
#include "./UserIdAndUserMap.cpp"


using namespace std;


class Expenses{
public:
    User *owesTo;
    vector<pair<User*, int>> owerAndAmount;

    void equalExpenses(UserIdAndUserMap &userIdAndUserMap, vector<string> &cmd){
        string payerId = cmd[1];
        int totalAmount = stoi(cmd[2]);
        int numberOfOwes = stoi(cmd[3]);
        this->owesTo = userIdAndUserMap.getUser(payerId);
        int amountPerPerson = totalAmount / numberOfOwes;
        vector<string> userIds;
        vector<int> amounts;
        for(int i = 0 ; i < numberOfOwes ; ++i ){
            userIds.push_back(cmd[4+i]);
            amounts.push_back(amountPerPerson);
        }
        for(int i = 0 ; i < numberOfOwes ; ++i)
            owerAndAmount.push_back({userIdAndUserMap.getUser(userIds[i]),amounts[i]});
    }
    void exactExpenses(UserIdAndUserMap &userIdAndUserMap, vector<string> &cmd){
        string payerId = cmd[1];
        this->owesTo = userIdAndUserMap.getUser(payerId);
        int numberOfOwes = stoi(cmd[3]);
        vector<string> userIds;
        vector<int> amounts;
        for(int i = 0 ; i < numberOfOwes ; ++i ){
            userIds.push_back(cmd[4+i]);
            amounts.push_back(stoi(cmd[5 + numberOfOwes + i]));
        }
        for(int i = 0 ; i < numberOfOwes ; ++i)
            owerAndAmount.push_back({userIdAndUserMap.getUser(userIds[i]),amounts[i]});
    }
    void percentExpenses(UserIdAndUserMap &userIdAndUserMap, vector<string> &cmd){
        string payerId = cmd[1];
        this->owesTo = userIdAndUserMap.getUser(payerId);
        int totalAmount = stoi(cmd[2]);
        int numberOfOwes = stoi(cmd[3]);
        vector<string> userIds;
        vector<int> amounts;
        for(int i = 0 ; i < numberOfOwes ; ++i ){
            int percent = stoi(cmd[5 + numberOfOwes + i]);
            int payable = (totalAmount * percent) / 100;
            userIds.push_back(cmd[4+i]);
            amounts.push_back(payable);
        }
        for(int i = 0 ; i < numberOfOwes ; ++i)
            owerAndAmount.push_back({userIdAndUserMap.getUser(userIds[i]),amounts[i]});
    }
};