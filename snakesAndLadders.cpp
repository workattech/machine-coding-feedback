#include <iostream>
#include <vector>
#include <cstdlib>
#include <unordered_map>
#include <algorithm>

using namespace std;

class OutOfRangeError {};

class InvalidLadderError {};

class InvalidSnakeError {};

class GameComponent {
public:
    virtual void setTerminals(int, int) = 0;

protected:
    int head;
    int tail;
    unordered_map<int, int> terminals;
};

class Snake : public GameComponent {
public:
    void setTerminals(int head, int tail) override {
        this->head = head;
        this->tail = tail;
    }

    friend class Snakes;
};

class Ladder : public GameComponent {
public:
    void setTerminals(int start, int end) override {
        this->head = start;
        this->tail = end;
    }

    friend class Ladders;
};

class Player {
public:
    Player() {
        currPos = 0;
    }

    void setName(string name) {
        this->name = name;
    }

    void moveBy(int moves) {
        if(currPos + moves > MAX_POS) {
            return;
        }
        currPos += moves;
    }

    void moveTo(int finalPos) {
        currPos = finalPos;
    }

    int getCurrPos() {
        return currPos;
    }

    string getName() {
        return name;
    }

private:
    string name;
    int currPos;
    static constexpr int MAX_POS = 100;
};

class Game;

class ComponentsGroup {
public:
    virtual void setup(int) = 0;
};

class Snakes : public ComponentsGroup {
public:
    void setup(int noOfSnakes) override {
        int head, tail;
        for(int i = 0; i < noOfSnakes; ++i) {
            Snake* snake = new Snake();
            try {
                cin >> head >> tail;
                if(head > 100 || head < 0 || tail > 100 || tail < 0) {
                    throw OutOfRangeError();
                } else if(tail > head) {
                    throw InvalidSnakeError();
                }
                listOfSnakes[head] = tail;
                snake->setTerminals(head, tail);
            }
            catch(OutOfRangeError &E) {
                cout << "Out of range error. Try again." << endl;
                --i;
            }
            catch(InvalidSnakeError &E) {
                cout << "Tail must be less than Head. Try again." << endl;
                --i;
            }
        }
    }

    friend class Game;

private:
    unordered_map<int,int> listOfSnakes;
};

class Ladders : public ComponentsGroup {
public:
    void setup(int noOfLadders) override {
        int start, end;
        for(int i = 0; i < noOfLadders; ++i) {
            Ladder *ladder = new Ladder;
            try {
                cin >> start >> end;
                if(start < 0 || end > 100 || start > 100 || end < 0) {
                    throw OutOfRangeError();
                } else if(start > end) {
                    throw InvalidLadderError();
                }
                listOfLadders[start] = end;
                ladder->setTerminals(start, end);
            }
            catch(OutOfRangeError &E) {
                cout << "Out of range error. Try again." << endl;
                --i;
            }
            catch(InvalidLadderError &E) {
                cout << "Start must be greater than End. Try again." << endl;
                --i;
            }
        }
    }

    friend class Game;

private:
    unordered_map<int, int> listOfLadders;
};

class Players {
public:
    void setup(int noOfPlayers) {
        for(int i = 0; i < noOfPlayers; ++i) {
            Player *player = new Player();
            string name; cin >> name;
            player->setName(name);
            listOfPlayers.push_back(player);
        }
    }

    vector<Player*> getListOfPlayers() {
        return listOfPlayers;
    }

    friend class Game;

private:
    vector<Player*> listOfPlayers;
};

class Dice {
public:
    static void rollDice() {
        face = 1 + (rand() % MAX_FACE_VALUE);
    }

    static int getFace() {
        return face;
    }

private:
    static constexpr int MAX_FACE_VALUE = 6;
    static int face;
};

int Dice::face = 1;

class Game {
public:
    Game() {
        turn = 0;
    }

    Game* setup();
    
    void play();

    void updateTurn() {
        turn = (turn + 1) % noOfPlayers;
    }

    bool isBittenBySnake(Player *&player) const {
        return snakes->listOfSnakes.find(player->getCurrPos()) != snakes->listOfSnakes.end();
    }

    bool hasFoundALadder(Player *&player) const {
        return ladders->listOfLadders.find(player->getCurrPos()) != ladders->listOfLadders.end();
    }

    int getTurn() {
        return turn;
    }

    int getFinalPos(unordered_map<int, int> posMatrix) {
        return posMatrix[(players->listOfPlayers)[getTurn()]->getCurrPos()];
    }

private:
    Snakes *snakes;
    Ladders *ladders;
    Players* players;
    int turn;
    int noOfSnakes;
    int noOfLadders;
    int noOfPlayers;
};

Game* Game::setup() {
    cout << "Enter number of snakes: ";
    cin >> noOfSnakes;
    snakes = new Snakes();
    snakes->setup(noOfSnakes);

    cout << "Enter number of ladders: ";
    cin >> noOfLadders;
    ladders = new Ladders();
    ladders->setup(noOfLadders);

    cout << "Enter number of players: ";
    cin >> noOfPlayers;
    players = new Players();
    players->setup(noOfPlayers);

    return this;
}

void Game::play() {
    Player *currPlayer;
    while(true) {
        currPlayer = players->listOfPlayers[getTurn()];
        int initPos = currPlayer->getCurrPos();

        Dice::rollDice();
        currPlayer->moveBy(Dice::getFace());

        while(isBittenBySnake(currPlayer) || hasFoundALadder(currPlayer)) {
            if(isBittenBySnake(currPlayer)) {
                currPlayer->moveTo(getFinalPos(snakes->listOfSnakes));
            } else {
                currPlayer->moveTo(getFinalPos(ladders->listOfLadders));
            }
        }

        cout << currPlayer->getName() << " rolled a " << Dice::getFace() << " and moved from " << initPos << " to " << currPlayer->getCurrPos() << endl;

        if(currPlayer->getCurrPos() == 100) {
            cout << currPlayer->getName() << " wins the game." << endl;
            break;
        }

        updateTurn();
    }
    delete currPlayer;
    currPlayer = nullptr;
}

int main() {
    Game *newGame = new Game();
    newGame->setup();
    newGame->play();    
    return 0;
}