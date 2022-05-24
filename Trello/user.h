#ifndef USER_H
#define USER_H
#include<bits/stdc++.h>
using namespace std;

class user
{
    public:
        user();
        user(int, string, string);

        int getuserid();
        string getusername();
        string getusermail();

        void setuserid(int);
        void setusername(string);
        void setusermail(string);

        void show();

    protected:

    private:
        int userid;
        string username;
        string usermail;

};

#endif // USER_H
