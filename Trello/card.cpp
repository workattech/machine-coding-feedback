#include "card.h"
int card::cnt = 0;
card::card()
{
    id = cnt;
    cnt++;
    assigned_id = -1;
}

card::card(string Name, string desc, int a_id=-1)
{
        id = cnt;
        name = Name;
        description = desc;
        assigned_id = a_id;
        cnt++;
}

int card::getid()
{
    return id;
}
string card::getname()
{
    return name;
}
string card::getdescription()
{
    return description;
}
int card::getassign_id()
{
    return assigned_id;
}

//void card::setid(int ID)
//{
//    id = ID;
//}
void card::setname(string Name)
{
    name = Name;
}
void card::setdescription(string desc)
{
    description = desc;
}
void card::setassign_id(int a_id=-1)
{
    assigned_id = a_id;
}

void card::unassign()
{
    assigned_id = -1;
}

void card::show()
{
    cout<<"CARD ID - "<<id<<" CARD NAME - "<<name<<" DESCRIPTION - "<<description<<"ASSIGN ID - ";
    if(assigned_id<0)
        cout<<"UNASSIGNED"<<endl;
    else
        cout<<assigned_id<<endl;
}
