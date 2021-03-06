#include<bits/stdc++.h>
#include "User.h"
#include "transaction.h"
#include "ServiceApp.h"

using namespace std;

int main()
{
    int n=3;
    vector<User> vecuser;

    User u1(1, "Soham", "sg@icloud.com", "8785723878");
    User u2(2, "Rembrandt", "rd@icloud.com", "7865675759");
    User u3(3, "Mclean", "mcl@icloud.com", "3984579875");

    vecuser.push_back(u1);
    vecuser.push_back(u2);
    vecuser.push_back(u3);

    ServiceApp service(n);
    service.setuserdetails(vecuser);

    vector<string> commands(5);

    commands[0] = "EXPENSE 1 900 3 1 2 3 EQUAL";
    commands[1] = "EXPENSE 2 1500 2 1 3 EXACT 600 900";
    commands[2] = "EXPENSE 3 1000 3 2 1 3 PERCENT 50 30 20";
    commands[3] = "SHOW";
    commands[4] = "SHOW 2";

    service.transact(commands);

}
