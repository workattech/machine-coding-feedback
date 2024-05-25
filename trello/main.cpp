using namespace std;
#include<iostream>
#include"Factory.cpp"

int main(){
    Factory *factory = new Factory();
    Board *board = factory->createBoard("First board");
    List* list1=factory->createList("List1", board->getId());
    List* list2=factory->createList("List2", board->getId());
    Card* card1=factory->createCard("Card1", list1->getId());
    Card* card2=factory->createCard("Card2", list1->getId());
    Card* card3=factory->createCard("Card3", list2->getId());

    cout<<board->toString()<<endl;

    return 0;
}