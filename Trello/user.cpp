#include "user.h"

user::user()
{

}

user::user(int uid, string uname, string umail)
{
    userid = uid;
    username = uname;
    usermail = umail;
}

int user::getuserid()
{
    return userid;
}

string user::getusername()
{
    return username;
}

string user::getusermail()
{
    return usermail;
}

void user::setuserid(int uid)
{
    userid = uid;
}

void user::setusername(string uname)
{
    username = uname;
}

void user::setusermail(string umail)
{
    usermail = umail;
}

void user::show()
{
    cout<<"USER ID - "<<userid<<" USER NAME - "<<username<<" USER MAIL ID - "<<usermail<<endl;
}
