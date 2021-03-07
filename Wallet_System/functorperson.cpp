#include "functorperson.h"

functorperson::functorperson()
{
    //ctor
}

bool operator()(person a, person b)
{
    if(a.numberoftransaction() != b.numberoftransaction())
        return (a.numberoftransaction() < b.numberoftransaction());
    else
    {
        if(a.getbalance()!=b.getbalance())
            return (a.getbalance() < b.getbalance());
        else
            return (a.getcreatedate() < b.getcreatedate());
    }

}
