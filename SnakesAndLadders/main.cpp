#include <bits/stdc++.h>
using namespace std;

class Snake {
  int head, tail;

public:
  Snake(int head, int tail) : head(head), tail(tail) {}
  void setHead(int head) { this->head = head; }
  void setTail(int tail) { this->tail = tail; }
  int getHead() { return head; }
  int getTail() { return tail; }
};

class Ladder {
  int start, end;

public:
  Ladder(int start, int end) : start(start), end(end) {}
  void setStart(int start) { this->start = start; }
  void setEnd(int end) { this->end = end; }
  int getStart() { return start; }
  int getEnd() { return end; }
};

const int SZ = 100;
class Game {
  vector<Snake> snakes;
  vector<Ladder> ladders;
  int players;
  vector<string> playerNames;
  int board[SZ +
            1]; // board[i] = i if ith position doesn't have any snake or ladder
  // else it is equal to the position where the player will eventually land

  vector<int> positions;

public:
  Game(vector<Snake> snakes, vector<Ladder> ladders, int players,
       vector<string> playerNames)
      : snakes(snakes), ladders(ladders), players(players),
        playerNames(playerNames) {}

  void init() {
    for (int i = 1; i <= 100; i++) {
      board[i] = i;
    }
    for (Snake &snake : snakes) {
      board[snake.getHead()] = snake.getTail();
    }
    for (Ladder &ladder : ladders) {
      board[ladder.getStart()] = ladder.getEnd();
    }
    positions.assign(players, 0);
  }

  void displayMove(int playerNo, int diceValue, int initialPos, int finalPos) {
    cout << playerNames[playerNo] + " rolled a " << diceValue
         << " and moved from " << initialPos << " to " << finalPos << endl;
  }

  void displayWin(int playerNo) {
    cout << playerNames[playerNo] + " wins the game" << endl;
  }

  int throwDice() { return rand() % 6 + 1; }

  bool validMove(int pos) { return pos <= 100; }

  void performMove(int playerNo) {
    int diceValue = throwDice();

    int oldPosition = positions[playerNo];
    int newPosition = oldPosition + diceValue;
    if (!validMove(newPosition)) {
      displayMove(playerNo, diceValue, oldPosition, oldPosition);
      return;
    }

    newPosition =
        board[newPosition]; // climb up the ladder or get bit by snake if any
    positions[playerNo] = newPosition;
    displayMove(playerNo, diceValue, oldPosition, newPosition);
  }

  bool finished(int playerNo) { return positions[playerNo] == 100; }

  void play() {
    int playerNo = -1;
    do {
      playerNo = (playerNo + 1) % players;
      performMove(playerNo);
    } while (!finished(playerNo));
    displayWin(playerNo);
  }
};

class Main {

public:
  void main() {
    int s;
    cin >> s;

    vector<Snake> snakes;
    for (int i = 0; i < s; i++) {
      int head, tail;
      cin >> head >> tail;
      snakes.emplace_back(head, tail);
    }

    int l;
    cin >> l;
    vector<Ladder> ladders;
    for (int i = 0; i < l; i++) {
      int start, end;
      cin >> start >> end;
      ladders.emplace_back(start, end);
    }

    int players;
    cin >> players;
    vector<string> playerNames;
    for (int i = 0; i < players; i++) {
      string name;
      cin >> name;
      playerNames.emplace_back(name);
    }

    Game game(snakes, ladders, players, playerNames);
    game.init();
    game.play();
  }
};

int main() {

  Main obj;
  obj.main();
  return 0;
}