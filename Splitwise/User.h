#ifndef USER_H
#define USER_H
#include<bits/stdc++.h>
#include<string>
using namespace std;

class User
{
    public:
        User();
        User(int uID, string nm, string ml, string mnumber);

        int getid();
        string getname();
        string getmail();
        string getmobileno();

        void setid(int);
        void setname(string);
        void setmail(string);
        void setmobileno(string);

    protected:

    private:
        int id;
        string name;
        string mail;
        string mno;
};

#endif // USER_H
