#ifndef FUNCTORPERSON_H
#define FUNCTORPERSON_H
#include<bits/stdc++.h>
#include "personalstatement.h"
#include "wallet.h"
#include "person.h"
using namespace std;

class functorperson
{
    public:
        functorperson();
        bool operator()(person a, person b);

    protected:

    private:
};

#endif // FUNCTORPERSON_H
