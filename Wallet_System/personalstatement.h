#ifndef PERSONALSTATEMENT_H
#define PERSONALSTATEMENT_H
#include<bits/stdc++.h>
using namespace std;

enum state{credit=1, debit=0};

class personalstatement
{
    public:
        personalstatement();
        personalstatement(string, enum state, double);

        string getname();
        enum state gettransactionstatus();
        double getamount();

        void setname(string);
        void settransactionstatus(enum state);
        void setamount(double);

        void showpersonalstatement();


    protected:

    private:
        string name;
        enum state transactionstatus;
        double amount;
};

#endif // PERSONALSTATEMENT_H
