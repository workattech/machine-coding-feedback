#pragma once
#include <bits/stdc++.h>

using namespace std;

class Command{
    vector<string> splitOn(string s, char on){
        s += on;
        vector<string> ans;
        string temp = "";
        for(char c: s )
            if(c == on){
                if(temp.size())
                    ans.push_back(temp);
                temp = "";
            }
            else   
                temp += c;
        return ans;
    }
public:
    vector<string> process(string s){
        return splitOn(s, ' ');
    }
};