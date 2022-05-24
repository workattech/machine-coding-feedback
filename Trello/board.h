#ifndef BOARD_H
#define BOARD_H
#include<bits/stdc++.h>
#include "user.h"
#include "card.h"
#include "listt.h"
using namespace std;

enum state{PRIVATE = 0, PUBLIC = 1};

class board
{
    public:
        static int cnt;
        board();
        board(string, enum state);
        static int getcount()
        {
            return cnt;
        }

        string inttostring(int);

        int getid();
        string getname();
        enum state getprivacy();
        string geturl();
        vector<user *> getmembers();
        vector<listt *> getlists();

        void setname(string Name);
        void setprivacy(enum state Privacy);

        //void seturl(string URL);
        void setmembers(vector<user *>);
        void setlists(vector<listt *>);

        void show();
        void showlist(listt*);
        void showcard(listt *List, card* Card);

        void cardassign(card*, listt*, int);
        void cardunassign(card*, listt*);

        void addmember(user*);
        void deletemember(user*);

        void addlist(listt*);
        void deletelist(listt*);

        void addcard(listt*, card*);
        void deletecard(listt*, card*);

        void movecard(card*, listt*, listt*);
        ~board();

    protected:

    private:
        int boardid;
        string boardname;
        enum state privacy;
        string url;
        vector<user *> members;
        vector<listt *> lists;


};

#endif // BOARD_H
