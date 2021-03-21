#include<bits/stdc++.h>

using namespace std;

class ConfRoom
{

    int id;
    bool *slots;

public:

    ConfRoom()
    {

        slots = new bool[24];

        for(int i=0; i<24; i++)
            slots[i] = false;

    }

    ConfRoom(int ID)
    {
        id = ID;
        slots = new bool(24);

        for(int i=0; i<24; i++)
            slots[i] = false;
    }

    int getID()
    {
        return id;
    }

    bool bookSlot(string slot)
    {
        int starttime = slot[0] - '0';
        int endtime = slot[2] - '0';

        for(int i=starttime; i<endtime; i++)
        {
            if(slots[i])
            {
                cout<<"Slots not available"<<endl;
                return false;
            }
        }


        for(int i=starttime; i<endtime; i++)
        {
            slots[i] = 1;
        }

        return true;

    }

    bool cancelSlot(string slot)
    {
        int starttime = slot[0] - '0';
        int endtime = slot[2] - '0';

        for(int i=starttime; i<endtime; i++)
        {
            slots[i] = 0;
        }

        return true;
    }

    bool availableBooking(string slot)
    {

        int starttime = slot[0] - '0';
        int endtime = slot[2] - '0';

        for(int i=starttime; i<endtime; i++)
        {
            if(slots[i])
            {
                return false;
            }
        }

        return true;

    }

};

class Floor
{

    unordered_map<int, ConfRoom> ConfRooms;
    string name;
    unordered_map<int, vector<string> > bookings;

public:

    Floor()
    {

    }

    Floor(string Name)
    {
        name = Name;
    }

    void addConfRoom(int ID)
    {
        ConfRoom newConfRoom(ID);
        ConfRooms[ID] = newConfRoom;
    }

    bool bookSlot(string slot, int ConfRoomID)
    {
        if(ConfRooms.count(ConfRoomID)==0)
        {
            cout<<"Conference Room not found"<<endl;
            return false;
        }

        ConfRoom confroom  = ConfRooms[ConfRoomID];
        bool flag = confroom.bookSlot(slot);
        ConfRooms[ConfRoomID] = confroom;
        if(flag)
        {
            bookings[ConfRoomID].push_back(slot);
        }
        return flag;
    }

    bool cancelSlot(string slot, int ConfRoomID)
    {
        if(ConfRooms.count(ConfRoomID)==0)
        {
            cout<<"Conference Room not found"<<endl;
            return false;
        }

        ConfRoom confroom  = ConfRooms[ConfRoomID];
        bool flag = confroom.cancelSlot(slot);
        ConfRooms[ConfRoomID] = confroom;
        if(flag)
        {
            vector<string> bookingvector = bookings[ConfRoomID];
            bookingvector.erase(find(bookingvector.begin(), bookingvector.end(), slot));
            bookings[ConfRoomID] = bookingvector;
        }
        return flag;
    }


    unordered_map<int, vector<string> > listBooking()
    {

        return bookings;

    }


    vector<int> searchAvailability(string slot)
    {
        bool flag=0;
        vector<int> rooms;
        for(auto x:ConfRooms)
        {
            int id = x.first;
            ConfRoom confroom = x.second;

            if(confroom.availableBooking(slot))
            {
                flag = 1;
                rooms.push_back(id);
            }

        }

        if(flag==0)
        {
            cout<<"No Rooms available "<<endl;
            return rooms;
        }
        else
            return rooms;

    }


};

class Building
{
    string name;
    unordered_map<string, Floor> Floors;

public:

    Building()
    {

    }

    Building(string Name)
    {
        name = Name;
    }

    void addFloor(string FloorName)
    {
        Floor newfloor(FloorName);
        Floors[FloorName] = newfloor;
    }

    bool addConfRoom(string FloorName, int ConfRoomID)
    {
        if(Floors.count(FloorName)==0)
        {
            cout<<"Floor not found"<<endl;
            return false;
        }

        Floor floor = Floors[FloorName];
        floor.addConfRoom(ConfRoomID);
        Floors[FloorName] = floor;
        return true;
    }

    bool bookSlot(string slot, string FloorName, int ConfRoomID)
    {
        if(Floors.count(FloorName)==0)
        {
            cout<<"Floor not found"<<endl;
            return false;
        }

        Floor floor = Floors[FloorName];
        bool flag = floor.bookSlot(slot, ConfRoomID);
        Floors[FloorName] = floor;
        return flag;
    }

    bool cancelSlot(string slot, string FloorName, int ConfRoomID)
    {
        if(Floors.count(FloorName)==0)
        {
            cout<<"Floor not found"<<endl;
            return false;
        }

        Floor floor = Floors[FloorName];
        bool flag = floor.cancelSlot(slot, ConfRoomID);
        Floors[FloorName] = floor;
        return flag;
    }


    unordered_map<int, vector<string> > listBooking(string FloorName)
    {
        if(Floors.count(FloorName)==0)
        {
            cout<<"Floor not found"<<endl;
            return unordered_map<int, vector<string> > ();
        }

         Floor floor = Floors[FloorName];
         return floor.listBooking();
    }


    vector<int> searchAvailability(string slot, string FloorName)
    {
        if(Floors.count(FloorName)==0)
        {
            cout<<"Floor not found"<<endl;
            return vector<int> ();
        }

        Floor floor = Floors[FloorName];
        return floor.searchAvailability(slot);
    }
};

class Service
{
    unordered_map<string, Building> Buildings;
    //vector<string> listBooking;

public:

    Service()
    {

    }

    void addBuilding(string BuildingName)
    {
        Building newBuilding(BuildingName);
        Buildings[BuildingName] = newBuilding;
        cout<<"Added building "<<BuildingName<<" into system."<<endl;
    }

    void addFloor(string BuildingName, string FloorName)
    {
        if(Buildings.count(BuildingName)==0)
        {
            cout<<"Building not found"<<endl;
            return;
        }

        Building building = Buildings[BuildingName];
        Buildings[BuildingName] = building;
        cout<<" Added room "<<FloorName<<" in "<<BuildingName<<endl;

    }

    bool addConfRoom(string BuildingName, string FloorName, int ConfRoomID)
    {
        if(Buildings.count(BuildingName)==0)
        {
            cout<<"Building not found"<<endl;
            return false;
        }
        Building building = Buildings[BuildingName];
        bool flag = building.addConfRoom(FloorName, ConfRoomID);
        //if(!flag)
        //    return false;

        Buildings[BuildingName] = building;
        cout<<" Added conference room "<<ConfRoomID<<" at "<<FloorName<<" in "<<BuildingName<<endl;
        return true;
    }

    bool bookSlot(string slot, string BuildingName, string FloorName, int ConfRoomID)
    {
        if(Buildings.count(BuildingName)==0)
        {
            cout<<"Building not found"<<endl;
            return false;
        }
        Building building = Buildings[BuildingName];
        bool flag = building.bookSlot(slot, FloorName, ConfRoomID);
        Buildings[BuildingName] = building;
        /*
        if(flag)
        {
            string bookingStatement = slot + " " + FloorName + " " + BuildingName + " " + to_string(ConfRoomID);
            listBooking.push_back(bookingStatement);
        }
        */
        return flag;
    }

    bool cancelSlot(string slot, string BuildingName, string FloorName, int ConfRoomID)
    {
        if(Buildings.count(BuildingName)==0)
        {
            cout<<"Building not found"<<endl;
            return false;
        }
        Building building = Buildings[BuildingName];
        bool flag = building.cancelSlot(slot, FloorName, ConfRoomID);
        Buildings[BuildingName] = building;
        /*
        if(flag)
        {
            string bookingStatement = slot + " " + FloorName + " " + BuildingName + " " + to_string(ConfRoomID);

            if(find(listBooking.begin(), listBooking.end(), bookingStatement)!=listBooking.end())
            {
                listBooking.erase(find(listBooking.begin(), listBooking.end(), bookingStatement));
            }

            listBooking.push_back(bookingStatement);
        }
        */

        return flag;
    }

    /*
    void displayListBookingAll()
    {

        if(Buildings.count(BuildingName)==0)
        {
            cout<<"Building not found"<<endl;
            return;
        }
        Building building = Buildings[BuildingName];
        building.listBooking(FloorName);
        Buildings[BuildingName] = building;


       for(unsigned int i=0; i<listBooking.size(); i++)
        cout<<listBooking[i]<<endl;

    }
    */

    void ListBooking(string BuildingName, string FloorName)
    {
        if(Buildings.count(BuildingName)==0)
        {
            cout<<"Building not found"<<endl;
            return;
        }

        Building building = Buildings[BuildingName];
        unordered_map<int, vector<string> > result = building.listBooking(FloorName);

        for(auto x: result)
        {
            int ConferenceRoomID = x.first;
            vector<string> vec = x.second;

            for(unsigned int i=0; i<vec.size(); i++)
            {
                string s = vec[i] + " " + FloorName + " " + BuildingName + " " + to_string(ConferenceRoomID);
                cout<<s<<endl;
            }
        }

    }


    void searchAvailability(string slot, string BuildingName, string FloorName)
    {
        if(Buildings.count(BuildingName)==0)
        {
            cout<<"Building not found"<<endl;
            return;
        }
        Building building = Buildings[BuildingName];
        vector<int> result = building.searchAvailability(slot, FloorName);
        Buildings[BuildingName] = building;

        if(!result.empty())
        {
            cout<<"The following rooms are available in "<<BuildingName<<" and floor "<<FloorName<<" : "<<endl;

            for(unsigned int i=0; i<result.size(); i++)
            {
                cout<<"Conference Room : "<<result[i]<<endl;
            }

        }

    }

};


int main()
{

    Service newService;
    newService.addBuilding("flipkart1");
    newService.addBuilding("flipkart2");

    cout<<"*******************************"<<endl;

    newService.addFloor("flipkart1", "FirstFloor");
    newService.addFloor("flipkart2", "SecondFloor");
    newService.addFloor("flipkart3", "FirstFloor");

    cout<<"*******************************"<<endl;


    newService.addConfRoom("flipkart1", "FirstFloor", 1);
    newService.addConfRoom("flipkart2", "SecondFloor", 1);
    newService.addConfRoom("flipkart1", "SecondFloor", 2);
    //newService.addConfRoom("flipkart3", "FirstFloor", 1);

    cout<<"*******************************"<<endl;

    /*
    newService.bookSlot("1:5", "flipkart1", "FirstFloor", 1);

    newService.bookSlot("6:9", "flipkart1", "FirstFloor", 1);

    newService.cancelSlot("1:5", "flipkart1", "FirstFloor", 1);

    cout<<"*******************************"<<endl;


    newService.searchAvailability("1:5", "flipkart1", "FirstFloor");

    cout<<"*******************************"<<endl;

    newService.ListBooking("flipkart1", "FirstFloor");

    cout<<"*******************************"<<endl;

    */
    return 0;
}
