#include "board.h"
int board::cnt=0;
board::board()
{
    boardid = cnt;
    cnt++;
    url = "5da1583ec25d2a7e246b03" + inttostring(boardid);
    privacy = PUBLIC;
}

board::board(string Boardname, enum state Privacy=PUBLIC)
{
    boardid = cnt;
    cnt++;
    url = "5da1583ec25d2a7e246b03" + inttostring(boardid);
    boardname = Boardname;
    privacy = Privacy;
}

string board::inttostring(int x)
{
    ostringstream st;
    st<<x;
    string s = st.str();
    return s;
}

        int board::getid()
        {
            return boardid;
        }
        string board::getname()
        {
            return boardname;
        }
        enum state board::getprivacy()
        {
            return privacy;
        }
        string board::geturl()
        {
            return url;
        }
        vector<user *> board::getmembers()
        {
            return members;
        }
        vector<listt *> board::getlists()
        {
            return lists;
        }

        void board::setname(string Name)
        {
            boardname = Name;
        }
        void board::setprivacy(enum state Privacy)
        {
            privacy = Privacy;
        }

        void board::setmembers(vector<user *> users)
        {
            members = users;
        }
        void board::setlists(vector<listt *> listts)
        {
            lists = listts;
        }
        void board::show()
        {
            cout<<"BOARD ID - "<<boardid<<" BOARD NAME - "<<boardname<<" URL - "<<url<<" PRIVACY - ";
            if(privacy==PUBLIC)
                cout<<"PUBLIC ";
            else
                cout<<"PRIVATE ";

            for(size_t i=0; i<members.size(); i++)
            {
                members[i]->show();
            }

            for(size_t i=0; i<lists.size(); i++)
            {
                lists[i]->show();
            }
            cout<<endl;

        }

        void board::showlist(listt *List)
        {
            /*
            for(int i=0; i<lists.size(); i++)
            {
                listt* listpointer = lists[i];
                listpointer->show();
            }
            */

            vector<listt*>::iterator i = find(lists.begin(), lists.end(), List);
            listt* listpointer = *i;
            listpointer->show();
        }

        void board::showcard(listt *List, card* Card)
        {
            vector<listt*>::iterator i = find(lists.begin(), lists.end(), List);
            listt* listpointer = *i;
            listpointer->showcard(Card);
        }

        void board::cardassign(card* Card, listt* List, int ID)
        {
            vector<listt*>::iterator i = find(lists.begin(), lists.end(), List);
            listt* listpointer = *i;
            listpointer->cardassign(Card, ID);
        }

        void board::cardunassign(card* Card, listt* List)
        {
            vector<listt*>::iterator i = find(lists.begin(), lists.end(), List);
            listt* listpointer = *i;
            listpointer->cardunassign(Card);
        }

        void board::addmember(user* member)
        {
            members.push_back(member);
        }

        void board::deletemember(user* member)
        {
            vector<user*>::iterator i = find(members.begin(), members.end(), member);
            user* memberpointer = *i;
            delete memberpointer;

            members.erase(i);
        }

        void board::addlist(listt* List)
        {
            lists.push_back(List);
        }
        void board::deletelist(listt* List)
        {
            vector<listt*>::iterator i = find(lists.begin(), lists.end(), List);
            listt* listpointer = *i;
            delete listpointer;

            lists.erase(i);
        }

        void board::addcard(listt *List, card *Card)
        {
            vector<listt*>::iterator i = find(lists.begin(), lists.end(), List);
            listt* listpointer = *i;
            listpointer->addcard(Card);
        }

        void board::deletecard(listt *List, card *Card)
        {
            vector<listt*>::iterator i = find(lists.begin(), lists.end(), List);
            listt* listpointer = *i;
            listpointer->deletecard(Card);
        }

        void board::movecard(card* Card, listt* listt1, listt* listt2)
        {
            vector<listt *>::iterator it1, it2;
            listt *l1, *l2;
            it1 = find(lists.begin(), lists.end(), listt1);
            l1 = *it1;
            l1->deletecard(Card);
            it2 = find(lists.begin(), lists.end(), listt2);
            l2 = *it2;
            l2->addcard(Card);

        }
board::~board()
{
    for(size_t i=0; i<members.size(); i++)
    {
        delete members[i];
    }

    for(size_t i=0; i<lists.size(); i++)
    {
        delete lists[i];
    }

    delete this;
}
