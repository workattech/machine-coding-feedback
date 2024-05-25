#include<string>

using namespace std;

class Entity{
    string id;
    string name;

    public:

    Entity(string id, string name){
        this->id=id;
        this->name=name;
    }

    string getId(){
        return this->id;
    }

    string getName(){
        return this->name;
    }
};