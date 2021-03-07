#ifndef WALLET_H
#define WALLET_H
#include<bits/stdc++.h>
#include "personalstatement.h"
using namespace std;

enum offerstate{first=10, second=5, third=2};
class wallet
{
    public:
        wallet();
        wallet(double);

        double getbalance();
        vector<personalstatement> getdetails();

        void setbalance(double);
        void setdetails(vector<personalstatement>);

        void decreasebalance(double Amount, string Name);
        void increasebalance(double Amount, string Name);

        void offer1();
        void offer2(enum offerstate);

        int numberoftransaction();
        void showbalance();
        void showstatement();

    protected:

    private:

        double balance;
        vector<personalstatement> details;

};

#endif // WALLET_H
