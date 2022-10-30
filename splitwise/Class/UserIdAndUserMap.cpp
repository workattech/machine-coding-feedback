#pragma once
#include "./User.cpp"


class UserIdAndUserMap{
public:
    std::map<std::string, User*> userIdToUser;

    void addUser(User *user){
        this->userIdToUser[user->userId] = user;
    }
    User* getUser(std::string userId){
        return this->userIdToUser[userId];
    }
};