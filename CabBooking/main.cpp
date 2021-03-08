#include<bits/stdc++.h>
#include<math.h>
using namespace std;

enum status{available=1, unavailable=0};



class Coordinate
{
    int x;
    int y;

public:
    Coordinate()
    {
        x=0;
        y=0;
    }

    Coordinate(int x_ordinate, int y_ordinate)
    {
        x = x_ordinate;
        y = y_ordinate;
    }

    void operator=(Coordinate a)
    {
        this->x = a.x;
        this->y = a.y;

    }

    int getX()
    {
        return x;
    }

    void setX(int x_ordinate)
    {
        x = x_ordinate;
    }

    int getY()
    {
        return y;
    }

    void setY(int y_ordinate)
    {
        y = y_ordinate;
    }

};

int difference(Coordinate a, Coordinate b)
{
        return ceil(pow( (pow((b.getX() - a.getX()), 2) + pow((b.getY() - a.getY()), 2) ), 0.5 ));
}


class User
{
    string username;
    string usercontact;
    Coordinate source;
    Coordinate destination;
    int userBill;
public:

    User()
    {
        userBill=0;
    }

    User(string name, string contact, Coordinate sourcePoint)
    {
        username = name;
        usercontact = contact;
        source = sourcePoint;
        destination = sourcePoint;
        userBill=0;
    }

    string getname()
    {
        return username;
    }

    void setname(string name)
    {
        username = name;
    }

    string getcontact()
    {
        return usercontact;
    }

    void setcontact(string contact)
    {
        usercontact = contact;
    }

    Coordinate getsourcepoint()
    {
        return source;
    }

    void setsourcepoint(Coordinate sourcePoint)
    {
        source = sourcePoint;
    }

    Coordinate getdestinationpoint()
    {
        return destination;
    }

    void setdestinationpoint(Coordinate destinationPoint)
    {
        destination = destinationPoint;
    }

    int getuserBill()
    {
        return userBill;
    }

    void setuserBill(int Userbill)
    {
        userBill = Userbill;
    }
};

class Driver
{
    string driverName;
    string driverContact;
    string vehicleNumber;
    Coordinate driverSource;
    enum status driverStatus;
    int driverEarning;
public:

    Driver()
    {
        driverStatus = available;
        driverEarning = 0;
    }

    Driver(string name, string contact, string Vehiclenumber, Coordinate sourcePoint)
    {
        driverName = name;
        driverContact = contact;
        vehicleNumber = Vehiclenumber;
        driverSource = sourcePoint;
        driverStatus = available;
        driverEarning = 0;
    }

    string getname()
    {
        return driverName;
    }

    void setname(string name)
    {
        driverName = name;
    }

    string getcontact()
    {
        return driverContact;
    }

    void setcontact(string contact)
    {
        driverContact = contact;
    }

    string getVehicleNumber()
    {
        return vehicleNumber;
    }

    void setVehicleNumber(string Vehiclenumber)
    {
        vehicleNumber = Vehiclenumber;
    }

    Coordinate getdriverSource()
    {
        return driverSource;
    }

    void setdriverSource(Coordinate sourcePoint)
    {
        driverSource = sourcePoint;
    }

    enum status getDriverStatus()
    {
        return driverStatus;
    }

    void setDriverStatus(enum status Driverstatus)
    {
        driverStatus = Driverstatus;
    }

    int getdriverEarning()
    {
        return driverEarning;
    }

    void setdriverEarning(int Driverearning)
    {
        driverEarning = Driverearning;
    }
};


class Manager
{
    unordered_map<string, User> users;
    unordered_map<string, Driver> drivers;

public:

    void add_user(string username, string usercontact, Coordinate sourcePoint)
    {
        User newUser(username, usercontact, sourcePoint);
        users[username] = newUser;
    }

    void update_user(string username, string usercontact)
    {
        User oldUser = users[username];
        oldUser.setcontact(usercontact);
        users[username] = oldUser;
    }

    void update_user_location(string username, Coordinate newSource)
    {
        User oldUser = users[username];
        oldUser.setsourcepoint(newSource);
        users[username] = oldUser;
    }

    void add_driver(string driverName, string driverContact, string vehicleNumber, Coordinate sourcePoint)
    {
        Driver newDriver(driverName, driverContact, vehicleNumber, sourcePoint);
        drivers[driverName] = newDriver;

    }

    void update_driver_location(string driverName, Coordinate sourcePoint)
    {
        Driver oldDriver = drivers[driverName];
        oldDriver.setdriverSource(sourcePoint);
        drivers[driverName] = oldDriver;
    }

    void change_driver_status(string driverName)
    {
        Driver oldDriver = drivers[driverName];
        if(oldDriver.getDriverStatus()==available)
        {
            oldDriver.setDriverStatus(unavailable);
        }
        else
        {
            oldDriver.setDriverStatus(available);
        }

        drivers[driverName] = oldDriver;
    }

    vector<Driver> find_ride(string username, Coordinate Usersource, Coordinate Userdestination)
    {
        vector<Driver> nearestDrivers;
        User currentUser = users[username];
        currentUser.setdestinationpoint(Userdestination);

        for(unordered_map<string, Driver>::iterator i = drivers.begin(); i!=drivers.end(); i++)
        {
            Driver currentDriver = i->second;
            Coordinate DriverSource = currentDriver.getdriverSource();
            if( difference(DriverSource,Usersource)<5 )
                {
                    nearestDrivers.push_back(currentDriver);
                }
        }
        if(nearestDrivers.empty())
            cout<<"Not Available"<<endl;
        else
            return nearestDrivers;
    }

    void choose_ride(string username, string drivername)
    {

        Driver chosenDriver = drivers[drivername];
        change_driver_status(drivername);
        int bill = calculate_Bill(username);
        chosenDriver.setdriverEarning(bill);
    }

    int calculate_Bill(string username)
    {
        User currentUser = users[username];
        Coordinate userSource = currentUser.getsourcepoint();
        Coordinate userDestination = currentUser.getdestinationpoint();

        int bill = difference(userDestination, userSource) * 1.5;
        currentUser.setuserBill(bill);

        return bill;
    }

    void find_total_earning()
    {
         for(unordered_map<string, Driver>::iterator i = drivers.begin(); i!=drivers.end(); i++)
         {
             Driver currentDriver = i->second;
            cout<<currentDriver.getname()<<" "<<"earned "<<currentDriver.getdriverEarning()<<endl;
         }
    }


};

int main()
{

    Manager cabBooking;

    Coordinate source1(1,2);
    //Coordinate source2(2,3);
    //Coordinate source3(5,6);
    Coordinate source4(8,9);
    Coordinate source5(6,7);
    Coordinate source6(7,8);
    Coordinate source7(10,11);

    cabBooking.add_user("terry","56757458878", source1);
    //cabBooking.add_user("soni","645674687", source2);
    //cabBooking.add_user("latif","4637786758", source3);

    cabBooking.add_driver("Karan", "3246475367845", "6464564ht56756", source4);
    cabBooking.add_driver("john", "4567586767", "4574573er845", source5);
    cabBooking.add_driver("Polash", "4567347787", "34789745ut68", source6);

    vector<Driver> nearbycab = cabBooking.find_ride("terry", source1, source7);


    for(int i=0; i<nearbycab.size(); i++)
        cout<<nearbycab[i].getname();

    if(!nearbycab.empty())
        cabBooking.choose_ride("terry", nearbycab[0].getname());

    cout<<cabBooking.calculate_Bill("terry")<<endl;

    cabBooking.find_total_earning();

    return 0;
}
