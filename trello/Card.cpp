#include<string>
#include"Entity.cpp"
using namespace std;

class Card: public Entity{
    string description;
    string user;

    public:
    Card(string id, string name): Entity(id, name){
    }

    string toString(){
        string res="";
        res+="Card Id: "+this->getId();
        res+=" Name: "+this->getName();
        res+='\n';
        return res;
    }
};