#include<string>
#include"List.cpp"
#include<set>
using namespace std;
class Board: public Entity{
    string privacy = "PUBLIC";
    string url;
    set<string> members;
    set<List*> lists; // store list ids

    public:
    Board(string id, string name): Entity(id, name){
        this->url="/board/"+this->getId();
    }


    void addList(List* l){
        lists.insert(l);
    }

    string toString(){
        string res="";
        res+="Board Id: "+this->getId();
        res+=" Name: "+this->getName();
        res+='\n';
        res+="Lists: \n";
        for(List* l:lists){
            res+=l->toString();
        }
        res+='\n';
        return res;
    }
};