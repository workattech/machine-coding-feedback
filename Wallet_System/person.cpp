#include "person.h"

int person::date=0;
person::person()
{
    createdate = date;
    ++date;
}
person::person(string Name, double Amount)
{
    name = Name;
    mywallet = wallet(Amount);
    createdate = date;
    date++;
}

string person::getname()
{
    return name;
}
wallet person::getwallet()
{
    return mywallet;
}

int person::getcreatedate()
{
    return createdate;
}

void person::setname(string Name)
{
    name = Name;
}

void person::setwallet(wallet MyWallet)
{
    mywallet = MyWallet;
}

double person::getbalance()
{
    return mywallet.getbalance();
}

int person::numberoftransaction()
{
    return mywallet.numberoftransaction();

}

void person::addamount(double Amount, string Name)
{
    mywallet.increasebalance(Amount, Name);

}
void person::decreaseamount(double Amount, string Name)
{
    mywallet.decreasebalance(Amount, Name);

}

void person::displaystatement()
{
    mywallet.showstatement();
}
void person::displayoverview()
{
    mywallet.showbalance();
}

void person::offer1()
{
    mywallet.offer1();
}

void person::offer2(enum offerstate position)
{
    mywallet.offer2(position);
}


