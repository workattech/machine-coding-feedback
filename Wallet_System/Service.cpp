#include "Service.h"

Service::Service()
{
    //ctor
}

unordered_map<string, person> Service::getcustomers()
{
    return customers;
}
void Service::setcustomers(unordered_map<string, person> Customers)
{
    customers = Customers;
}

void Service::createaccount(string Name, double Amount)
{
    //if()
    person newcustomer = person(Name, Amount);
    customers[Name] = newcustomer;
}

void Service::offer2()
{
    /*
    priority_queue<person, vector<person>, [](person a, person b)
        {
    if( a.numberoftransaction() != b.numberoftransaction() )
        return ( a.numberoftransaction() < b.numberoftransaction() );
    else
    {
        if( a.getbalance()!=b.getbalance() )
            return ( a.getbalance() < b.getbalance() );
        else
            return ( a.getcreatedate() < b.getcreatedate() );
    }> priorityCustomer;

    for(unordered_map<string, person>::iterator i=customers.begin(); i!=customers.end(); i++)
    {
        person customer = i->second;
        priorityCustomer.push(customer);
    }

    person customer1 = priorityCustomer.top();
    customer1.offer2(first);
    customers[customer1.getname()] = customer1;
    priorityCustomer.pop();

    person customer2 = priorityCustomer.top();
    customer2.offer2(second);
    customers[customer2.getname()] = customer2;
    priorityCustomer.pop();

    person customer3 = priorityCustomer.top();
    customer3.offer2(third);
    customers[customer3.getname()] = customer3;
    priorityCustomer.pop();
    */
}

void Service::transfermoney(string Name1, string Name2, double Amount)
{
    person customer1 = customers[Name1];
    person customer2 = customers[Name2];

    if(customer1.getbalance()>Amount)
    {
        customer1.decreaseamount(Amount, Name2);
        customer2.addamount(Amount, Name1);

        if(customer1.getbalance()==customer2.getbalance())
        {
            customer1.offer1();
            customer2.offer1();
        }

        customers[Name1] = customer1;
        customers[Name2] = customer2;
    }
}
void Service::viewstatement(string Name)
{
    person customer = customers[Name];
    customer.displaystatement();
}

void Service::overview()
{
    for(unordered_map<string, person>::iterator i=customers.begin(); i!=customers.end(); i++)
    {
        person customer = i->second;
        customer.displayoverview();
    }

}
