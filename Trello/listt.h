#ifndef LISTT_H
#define LISTT_H
#include<bits/stdc++.h>
#include "card.h"
using namespace std;

class listt
{
    public:
        static int cnt;
        listt();
        listt(string);

        static int getcount()
        {
            return cnt;
        }

        int getid();
        string getname();
        vector<card *> getcards();

        //void setlistid(int lid);
        void setname(int lname);
        void setcards(vector<card *>);

        void addcard(card*);
        void deletecard(card*);

        void cardassign(card* Card, int assignID);
        void cardunassign(card* Card);

        void show();
        void showcard(card*);

        ~listt();

    protected:

    private:

        int listid;
        string listname;
        vector<card *> cards;
};

#endif // LISTT_H
