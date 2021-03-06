#include "transaction.h"

transaction::transaction()
{
}

transaction::transaction(int nuser)
{
    totaluser = nuser;
}

unordered_map<int, unordered_map<int, double> > transaction::gettransuser()
{
    return usertransaction;
}

void transaction::settransuser(unordered_map<int, unordered_map<int, double> > tuser)
{
    usertransaction = tuser;
}

int transaction::gettotaluser()
{
    return totaluser;
}

void transaction::settotaluser(int nuser)
{
    totaluser = nuser;
}

void transaction::equal_add(int u_id, double amount, int nuser, vector<int> ids)
{
    unordered_map<int, double> transu_id = usertransaction[u_id];
    double equalmoney = amount/nuser;
    for(int i=0; i<ids.size(); i++)
    {

        if(ids[i]!=u_id)
        {
            transu_id[ids[i]] += amount;

            unordered_map<int, double> trans = usertransaction[ids[i]];
            trans[u_id] -= equalmoney;
            usertransaction[ids[i]] = trans;
        }

    }

    usertransaction[u_id] = transu_id;
}

void transaction::exact_add(int u_id, double amount, int nuser, vector<int> ids, vector<double> exactmoney)
{
    unordered_map<int, double> transu_id = usertransaction[u_id];

    for(int i=0; i<ids.size(); i++)
    {
            double money = exactmoney[i];
            transu_id[ids[i]] += money;

            unordered_map<int, double> trans = usertransaction[ids[i]];
            trans[u_id] -= money;
            usertransaction[ids[i]] = trans;

    }

    usertransaction[u_id] = transu_id;

}

void transaction::percent_add(int u_id, double amount, int nuser, vector<int> ids, vector<double> percent)
{
    unordered_map<int, double> transu_id = usertransaction[u_id];

    for(int i=0; i<ids.size(); i++)
    {
        if(ids[i]!=u_id)
        {
            double money = (percent[i]*amount)/100;
            transu_id[ids[i]] += money;

            unordered_map<int, double> trans = usertransaction[ids[i]];
            trans[u_id] -= money;
            usertransaction[ids[i]] = trans;
        }

    }

    usertransaction[u_id] = transu_id;

}

void transaction::show()
{
    cout<<"Show"<<endl;
    for(unordered_map<int, unordered_map<int, double> >::iterator i = usertransaction.begin(); i!=usertransaction.end(); i++)
    {
        unordered_map<int, double> trans = i->second;
        int u_id = i->first;
        //bool flag=0;
        for(unordered_map<int, double>::iterator j = trans.begin(); j!=trans.end(); j++)
        {
            int v_id = j->first;
            double amt = j->second;

            //if(amt<0)
            //{
                cout<<u_id<<" "<<"owes "<<v_id<<": "<<abs(amt)<<endl;
                //flag=1;
            //}


        }
        //if(!flag)
        //    cout<<"No balances"<<endl;
    }
}


void transaction::show(int u_id)
{
    cout<<"Show ID"<<endl;
    unordered_map<int, double> trans = usertransaction[u_id];
    bool flag=0;
    for(unordered_map<int, double>::iterator j = trans.begin(); j!=trans.end(); j++)
        {
            int v_id = j->first;
            double amt = j->second;

            if(amt<0)
            {
                cout<<u_id<<" "<<"owes "<<v_id<<": "<<abs(amt)<<endl;
                flag=1;
            }
            else if(amt>0)
            {
                cout<<v_id<<" "<<"owes "<<u_id<<": "<<amt<<endl;
                flag=1;
            }
            else
            {
                cout<<u_id<<" "<<"owes "<<v_id<<": "<<abs(amt)<<endl;
            }

        }
        if(!flag)
            cout<<"No balances"<<endl;
}
