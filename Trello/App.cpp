#include "App.h"

App::App()
{
    numberofboards=0;
}
App::App(int totalboards)
{
    numberofboards = totalboards;
}

board* App::createboard(string name, vector<user *> Members, vector<listt *> Lists)
        {
            board *newboard = new board(name, PUBLIC);
            newboard->setmembers(Members);
            newboard->setlists(Lists);
            cout<<newboard->getid()<<endl;
            return newboard;
        }

void App::addboard(board* Board)
{
    boards.push_back(Board);
    ++numberofboards;
}

void App::removeboard(board* Board)
        {
            vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
            board* boardpointer = *i;
            delete boardpointer;

            boards.erase(i);
            --numberofboards;
        }

listt* App::createlist(string name, vector<card*> cards)
        {
            listt *newlist = new listt(name);
            newlist->setcards(cards);
            cout<<newlist->getid()<<endl;
            return newlist;
        }

void App::addlist(board* Board, listt *List)
{
    vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
    board* boardpointer = *i;
    boardpointer->addlist(List);
}

void App::removelist(board* Board, listt* List)
{
            vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
            board* boardpointer = *i;
            boardpointer->deletelist(List);
}

card* App::createcard(string name, string description, int assign_id)
{
            card* newcard = new card(name, description, assign_id);
            cout<<newcard->getid()<<endl;
            return newcard;
}

void App::addcard(board *Board, listt *List, card* Card)
{
    vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
    board* boardpointer = *i;
    boardpointer->addcard(List, Card);
}

void App::removecard(board* Board, listt* List, card* Card)
{
            vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
            board* boardpointer = *i;
            boardpointer->deletecard(List, Card);
}

user* App::createmember(int ID, string name, string mail)
{
    user *newmember = new user(ID, name, mail);
    cout<<newmember->getuserid()<<endl;
    return newmember;
}
void App::addmember(board* Board, user* member)
{
    vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
    board* boardpointer = *i;
    boardpointer->addmember(member);
}

void App::removemember(board* Board, user* member)
{
    vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
    board* boardpointer = *i;
    boardpointer->deletemember(member);
}

void App::cardassign(board* Board, listt* List, card* Card, int id)
{
    vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
    board* boardpointer = *i;
    boardpointer->cardassign(Card, List, id);
}

void App::cardunassign(board* Board, listt* List, card* Card)
{
    vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
    board* boardpointer = *i;
    boardpointer->cardunassign(Card, List);
}

vector<board *> App::getboards()
{
    return boards;
}

int App::getnumberofboards()
{
    return numberofboards;
}

void App::setboards(vector<board *> Boards)
{
    boards = Boards;
}

void App::movecard(board* Board, listt* list1, listt* list2, card* Card)
{
    vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
    board* boardpointer = *i;
    boardpointer->movecard(Card, list1, list2);
}
void App::show()
{
    for(int i=0; i<boards.size(); i++)
    {
        board* boardpointer = boards[i];
        boardpointer->show();
    }
}
void App::showboard(board* Board)
{
    vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
    board* boardpointer = *i;
    boardpointer->show();
}

void App::showlist(board* Board, listt* List)
{
    vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
    board* boardpointer = *i;
    boardpointer->showlist(List);
}
void App::showcard(board* Board, listt* List, card* Card)
{
    vector<board*>::iterator i = find(boards.begin(), boards.end(), Board);
    board* boardpointer = *i;
    boardpointer->showcard(List, Card);
}
