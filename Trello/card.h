#ifndef CARD_H
#define CARD_H
#include<bits/stdc++.h>
#include<string>
using namespace std;

class card
{
    public:
        static int cnt;
        card();
        card(string, string, int);

        static int getcount()
        {
            return cnt;
        }

        int getid();
        string getname();
        string getdescription();
        int getassign_id();

        //void setid(int);
        void setname(string);
        void setdescription(string);
        void setassign_id(int);
        void unassign();


        void show();
    protected:

    private:

        int id;
        string name;
        string description;
        int assigned_id;

};

#endif // CARD_H
