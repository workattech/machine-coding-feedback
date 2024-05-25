#include<string>
#include"Card.cpp"
#include<set>
using namespace std;

class List: public Entity{
    set<Card*> cards; // ids

    public:
    List(string id, string name): Entity(id, name){
    }

    void addCard(Card* c){
        cards.insert(c);
    }

    string toString(){
        string res="";
        res+="List Id: "+this->getId();
        res+=" Name: "+this->getName();
        res+='\n';
        res+="Cards: \n";
        for(Card* c:cards){
            res+=c->toString();
        }
        res+='\n';
        return res;
    }
};