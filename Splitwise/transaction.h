#ifndef TRANSACTION_H
#define TRANSACTION_H
#include<bits/stdc++.h>
#include<string>
#include "User.h"
using namespace std;

class transaction
{
    public:
        transaction();
        transaction(int nuser);

        unordered_map<int, unordered_map<int, double> > gettransuser();
        int gettotaluser();

        void settransuser(unordered_map<int, unordered_map<int, double> >);
        void settotaluser(int nuser);

        void equal_add(int, double, int, vector<int>);
        void exact_add(int, double, int, vector<int>, vector<double>);
        void percent_add(int, double, int, vector<int>, vector<double>);

        void show();
        void show(int);

    protected:

    private:
        int totaluser;
        unordered_map<int, unordered_map<int, double> > usertransaction;
};

#endif // TRANSACTION_H
