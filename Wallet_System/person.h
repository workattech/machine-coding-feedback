#ifndef PERSON_H
#define PERSON_H
#include<bits/stdc++.h>
#include "personalstatement.h"
#include "wallet.h"
using namespace std;

class person
{
    public:
        static int date;
        person();
        person(string, double);
        static int getdate()
        {
            return date;
        }

        string getname();
        wallet getwallet();
        int getcreatedate();

        void setname(string Name);
        void setwallet(wallet MyWallet);

        double getbalance();
        int numberoftransaction();
        void addamount(double Amount, string Name);
        void decreaseamount(double Amount, string Name);

        void displaystatement();
        void displayoverview();

        void offer1();
        void offer2(enum offerstate);

    protected:

    private:
        string name;
        wallet mywallet;
        int createdate;
};

#endif // PERSON_H
