#include "wallet.h"

wallet::wallet()
{
    //ctor
}

wallet::wallet(double Balance)
{
    balance = Balance;
}

double wallet::getbalance()
{
    return balance;
}
vector<personalstatement> wallet::getdetails()
{
    return details;
}

void wallet::setbalance(double Balance)
{
    balance = Balance;
}

void wallet::setdetails(vector<personalstatement> Details)
{
    details = Details;
}

void wallet::decreasebalance(double Amount, string Name)
{
    balance -= Amount;
    personalstatement PersonalStatement(Name, debit, Amount);
    details.push_back(PersonalStatement);
}
void wallet::increasebalance(double Amount, string Name)
{
    balance += Amount;
    personalstatement PersonalStatement(Name, credit, Amount);
    details.push_back(PersonalStatement);
}

void wallet::offer1()
{
    balance += 10;
    personalstatement PersonalStatement("offer1", credit, 10);
    details.push_back(PersonalStatement);
}

void wallet::offer2(enum offerstate position)
{
    if(position==first)
    {
        balance += 10;
        personalstatement PersonalStatement("offer2", credit, 10);
        details.push_back(PersonalStatement);
    }
    else if(position==second)
    {
        balance += 5;
        personalstatement PersonalStatement("offer2", credit, 5);
        details.push_back(PersonalStatement);
    }
    else if(position==third)
    {
        balance += 2;
        personalstatement PersonalStatement("offer2", credit, 2);
        details.push_back(PersonalStatement);
    }
}

int wallet::numberoftransaction()
{
    return details.size();
}

void wallet::showbalance()
{
    cout<<balance<<endl;
}

void wallet::showstatement()
{
    for(int i=0; i<details.size(); i++)
    {
        details[i].showpersonalstatement();
    }
}
