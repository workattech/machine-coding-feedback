#include<bits/stdc++.h>
#include "./Class/Splitwise.cpp"


int main(){
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);

    Splitwise splitwise;

    for(int i = 1 ; i <= 4 ; ++i){
        User *user = new User();
        user->userId = "u" + to_string(i);
        user->name = "User" + to_string(i);
        splitwise.addUser(user);
    }

    string str;
    while(getline(cin, str))
        splitwise.processCommand(str);

    return 0;
}