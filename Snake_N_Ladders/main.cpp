#include<bits/stdc++.h>
using namespace std;

class Board {
    private: 
    int cells, snakesCount, laddersCount;
    
    unordered_map<int, int> snakes;
    unordered_map<int, int> ladders;
    void setSnakesValues (vector<pair<int, int>> &snakes) {
        this->snakesCount = snakes.size();
        for (auto each : snakes)
        this->snakes[each.first] = each.second;
    }

    void setLaddersValues (vector<pair<int, int>> &ladders) {
        this->laddersCount = ladders.size();
        for (auto each : ladders)
        this->ladders[each.first] = each.second;
    }

    public:
    Board (vector<pair<int, int>> &snakes, vector<pair<int, int>> &ladders) {
        setSnakesValues(snakes);
        setLaddersValues(ladders);
        this->cells = 100;
    }

    Board (vector<pair<int, int>> &snakes, vector<pair<int, int>> &ladders, int cells) {
        setSnakesValues(snakes);
        setLaddersValues(ladders);
        this->cells = cells;
    }

    int isSnakeSting (int cellNumber) {
        if (snakes[cellNumber]) {
            return snakes[cellNumber];
        }
        else {
            return -1;
        }
    }

    int isLadderRewarded (int cellNumber) {
        if (ladders[cellNumber]) {
            return ladders[cellNumber];
        }
        else {
            return -1;
        }
    }
};


class DiceRoller {
    private:
    int diceCount;
    
    public:
    DiceRoller () {
        this->diceCount = 1;
    }

    DiceRoller (int n) {
        this->diceCount = n;
    }

    int RollTheDice () {
        mt19937 generator(std::chrono::system_clock::now().time_since_epoch().count());
        uniform_int_distribution<int> distribution(1, 6);
        int sum = distribution(generator);
        if (sum == 6) {
            int secondChance = distribution(generator);
            if (sum + secondChance == 12) {
                int thirdChance = distribution(generator);
                if (sum + secondChance + thirdChance == 18) {
                    return 0;
                } else {
                    return sum + secondChance + thirdChance;
                }
            } else {
                return sum + secondChance;
            }
        } else {
            return sum;
        }
    }
};

class Player {
    private:
    string name;
    int cellPosition;

    public: 
    Player (string name) {
        this->name = name;
        cellPosition = 0;
    }

    string getName() {
        return this->name;
    }

    int getCellNumber () {
        return this->cellPosition;
    }

    void updateCellPosition (int newCellPosition) {
        this->cellPosition = newCellPosition;
    }
};

class Game {
    public:
    Game () {

    }
    void play () {
        int numberOfSnakes;
        cin>>numberOfSnakes;
        int from , to;
        vector<pair<int, int> > snakes(numberOfSnakes);
        for (int i =0 ; i < numberOfSnakes; ++i) {
            cin>>from>>to;
            snakes[i] = { from, to };
        }
        int numberOfLadders;
        cin>>numberOfLadders;
        vector<pair<int, int> > ladders(numberOfLadders);
        for (int i =0; i < numberOfLadders; ++i) {
            cin>>from>>to;
            ladders[i] = { from, to };
        }
        Board * board = new Board(snakes, ladders);
        int numberOfPlayers;
        cin>>numberOfPlayers;
        string name;
        vector<Player *> players(numberOfPlayers);
        for (int i =0; i < numberOfPlayers; ++i) {
            cin>>name;
            players[i] = new Player(name);
        }

        DiceRoller * dice = new DiceRoller();
        int playerReached = -1;
        while(true) {
            for (int i = 0; i < numberOfPlayers; ++i) {
                int num = dice->RollTheDice();
                int initialPosition = players[i]->getCellNumber();
                int newPosition = num + initialPosition;
                int snakePosition = board->isSnakeSting(newPosition);
                int ladderPosition = board->isLadderRewarded(newPosition);
                if (snakePosition != -1) {
                    newPosition = snakePosition;
                } else if (ladderPosition != -1) {
                    newPosition = ladderPosition;
                }
                if (newPosition > 100) {
                    newPosition = initialPosition;
                    cout<<players[i]->getName()<<" rolled a "<<num<<" which is not valid from "<<initialPosition<<endl;
                } else {
                    players[i]->updateCellPosition(newPosition);
                    cout<<players[i]->getName()<<" rolled a "<<num<<" and moved from "<<initialPosition<<" to "<<newPosition<<endl;

                }
                if (newPosition == 100) {
                    playerReached = i;
                    break;
                }
            }
            if (playerReached != -1) {
                cout<<players[playerReached]->getName()<<" wins the game";
                break;
            }
        }
    }
};

int main () {

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    Game * game = new Game();
    game->play();
    return 0;
}