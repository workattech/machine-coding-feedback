#include "listt.h"


int listt::cnt=0;

listt::listt()
{
    listid = cnt;
    cnt++;
}

listt::listt(string lname)
{
    listid = cnt;
    cnt++;
    listname = lname;
}

int listt::getid()
{
    return listid;
}

string listt::getname()
{
    return listname;
}

vector<card *> listt::getcards()
{
    return cards;
}

void listt::setname(int lname)
{
    listname = lname;
}

void listt::setcards(vector<card *> cardvector)
{
    cards = cardvector;
}

void listt::addcard(card* Card)
{
    cards.push_back(Card);
}

void listt::deletecard(card* Card)
{
    vector<card*>::iterator i = find(cards.begin(), cards.end(), Card);
            card* cardpointer = *i;
            delete cardpointer;

            cards.erase(i);
}

void listt::cardassign(card* Card, int assignID)
{
    vector<card*>::iterator i = find(cards.begin(), cards.end(), Card);
    card* cardpointer = *i;
    cardpointer->setassign_id(assignID);
}

void listt::cardunassign(card* Card)
{
    vector<card*>::iterator i = find(cards.begin(), cards.end(), Card);
    card* cardpointer = *i;
    cardpointer->unassign();
}

void listt::show()
{
    cout<<"LIST ID - "<<listid<<" LIST NAME - "<<listname<<endl;
    for(size_t i=0; i<cards.size(); i++)
    {
        cards[i]->show();
    }
}

void listt::showcard(card* Card)
{
    vector<card*>::iterator i = find(cards.begin(), cards.end(), Card);
    card* cardpointer = *i;
    cardpointer->show();
}


listt::~listt()
{
    for(size_t i=0; i<cards.size(); i++)
    {
        delete cards[i];
    }

    delete this;
}
