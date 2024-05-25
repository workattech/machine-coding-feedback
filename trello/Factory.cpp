#include "Board.cpp"
#include <map>
#include <random>
#include <string>
#include<iostream>
using namespace std;

class Factory {
    map<string, Board *> boards;
    map<string, List *> lists;
    map<string, Card *> cards;

    string generateRandomId(size_t length = 20) {
        const string base64_chars =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            "abcdefghijklmnopqrstuvwxyz"
            "0123456789+/";
        random_device rd;
        mt19937 gen(rd());
        uniform_int_distribution<> dis(0, 63);

        string randomBase64Id;
        randomBase64Id.reserve(length);

        for (size_t i = 0; i < length; ++i) {
            randomBase64Id += base64_chars[dis(gen)];
        }

        return randomBase64Id;
    }

   public:
    Board* createBoard(string name) {
        string id = generateRandomId();
        Board *newBoard = new Board(id, name);
        boards[id] = newBoard;
        cout<<"Created board with id: "<<id<<endl;
        return newBoard;
    }

    List* createList(string name, string boardId) {
        string id = generateRandomId();
        List *newList = new List(id, name);
        lists[id] = newList;
        boards[boardId]->addList(newList);
        cout<<"Created list with id: "<<id<<endl;
        return newList;
    }

    Card* createCard(string name, string listId) {
        string id = generateRandomId();
        Card *newCard = new Card(id, name);
        cards[id] = newCard;
        lists[listId]->addCard(newCard);
        cout<<"Created card with id: "<<id<<endl;
        return newCard;
    }

    Board* getBoard(string id){
        if(boards.find(id)==boards.end()) return NULL;
        return boards[id];
    }

    List* getList(string id){
        if(lists.find(id)==lists.end()) return NULL;
        return lists[id];
    }

    Card* getCard(string id){
        if(cards.find(id)==cards.end()) return NULL;
        return cards[id];
    }
};