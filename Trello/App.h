#ifndef APP_H
#define APP_H
#include<bits/stdc++.h>
#include<string>
#include "card.h"
#include "user.h"
#include "listt.h"
#include "board.h"
using namespace std;

class App
{
    public:
        App();
        App(int);

        vector<board *> getboards();
        int getnumberofboards();

        void setboards(vector<board *> Boards);

        board* createboard(string name, vector<user *> Members, vector<listt *> Lists);
        void addboard(board* Board);
        void removeboard(board* Board);

        listt* createlist(string name, vector<card*> cards);
        void addlist(board* Board, listt *List);
        void removelist(board* Board, listt* List);

        card* createcard(string name, string description, int assign_id);
        void addcard(board *Board, listt *List, card* Card);
        void removecard(board* Board, listt* List, card* Card);
        void cardassign(board*, listt*, card*, int id);
        void cardunassign(board*, listt*, card*);

        user* createmember(int, string, string);
        void addmember(board* Board, user* member);
        void removemember(board* Board, user* member);

        void movecard(board*, listt*, listt*, card*);
        void show();
        void showboard(board*);
        void showlist(board*, listt*);
        void showcard(board*, listt*, card*);

    protected:

    private:
        vector<board *> boards;
        int numberofboards;
};

#endif // APP_H
