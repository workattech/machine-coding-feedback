#include "personalstatement.h"

personalstatement::personalstatement()
{
    //ctor
}

personalstatement::personalstatement(string Name, enum state TransactionStatus, double Amount)
{
    name = Name;
    transactionstatus = TransactionStatus;
    amount = Amount;
}

string personalstatement::getname()
{
    return name;
}
enum state personalstatement::gettransactionstatus()
{
    return transactionstatus;
}
double personalstatement::getamount()
{
    return amount;
}

void personalstatement::setname(string Name)
{
    name = Name;
}
void personalstatement::settransactionstatus(enum state TransactionStatus)
{
    transactionstatus = TransactionStatus;
}
void personalstatement::setamount(double Amount)
{
    amount = Amount;
}

void personalstatement::showpersonalstatement()
{
    cout<<name<<" ";
    if(transactionstatus==credit)
        cout<<"credit";
    else if(transactionstatus==debit)
        cout<<"debit";
    cout<<" "<<amount<<endl;
}
