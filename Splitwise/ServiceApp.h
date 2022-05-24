#ifndef SERVICEAPP_H
#define SERVICEAPP_H
#include<bits/stdc++.h>
#include<string>
#include "User.h"
#include "transaction.h"
using namespace std;


class ServiceApp
{
    public:
        ServiceApp();
        ServiceApp(int nuser);

        void setuserdetails(vector<User> vuser);
        unordered_map<int, User> getuserdetails();

        void setnouser(int nuser);
        int getnouser();

        void transact(vector<string>);
        int stringtoint(string);
    protected:

    private:
        transaction appt;
        int nouser;
        unordered_map<int, User> userdetails;
};

#endif // SERVICEAPP_H
