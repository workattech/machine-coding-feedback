#include "User.h"

User::User()
{

}

User::User(int uID, string nm, string ml, string mnumber)
{
            id = uID;
            name = nm;
            mail = ml;
            mno = mnumber;
}

int User::getid()
{
    return id;
}

string User::getname()
{
    return name;
}

string User::getmail()
{
    return mail;
}

string User::getmobileno()
{
    return mno;
}

void User::setid(int uID)
{
    id = uID;
}

void User::setname(string nam)
{
    name = nam;
}

void User::setmail(string ml)
{
    mail = ml;
}

void User::setmobileno(string mnumber)
{
    mno = mnumber;
}
