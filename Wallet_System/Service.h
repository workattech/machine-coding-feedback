#ifndef SERVICE_H
#define SERVICE_H
#include<bits/stdc++.h>
#include "personalstatement.h"
#include "wallet.h"
#include "person.h"

using namespace std;

class Service
{
    public:
        Service();
        unordered_map<string, person> getcustomers();
        void setcustomers(unordered_map<string, person> );

        void createaccount(string, double);
        void offer2();
        void transfermoney(string, string, double);
        void viewstatement(string);
        void overview();



    protected:

    private:

        unordered_map<string, person> customers;

};

#endif // SERVICE_H
