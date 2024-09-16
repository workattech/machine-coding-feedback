
// Snake and ladder Game Implementation

#include <bits/stdc++.h>
using namespace std;

class Players {
public:
  string name;
  int initial_pos;
  int final_pos;
  Players(string name) {
    this->name = name;
    initial_pos = 0;
    final_pos = 0;
  }
};

class Snake {
public:
  vector<pair<int, int> > SnakePos;
  Snake(vector<pair<int, int> > SnakePos) { this->SnakePos = SnakePos; }
};

class Ladder {
public:
  vector<pair<int, int> > LadderPos;
  Ladder(vector<pair<int, int> > LadderPos) { this->LadderPos = LadderPos; }
};

class Game {
public:
  vector<Players> players;
  Snake snake;
  Ladder ladder;
  int total_players;
  Game(vector<Players> players, Snake snake, Ladder ladder)
      : players(players), snake(snake), ladder(ladder) {
    this->total_players = players.size();
  }
  void playGame() {
    int i = 0;
    while (i < total_players) {
      int dice = rand() % 6 + 1;
      if (players[i].final_pos + dice <= 100) {
        players[i].initial_pos = players[i].final_pos;
        players[i].final_pos += dice;

        for (int j = 0; j < snake.SnakePos.size(); j++) {
          if (players[i].final_pos == snake.SnakePos[j].first) {
            players[i].final_pos = snake.SnakePos[j].second;
          }
        }
        for (int j = 0; j < ladder.LadderPos.size(); j++) {
          if (players[i].final_pos == ladder.LadderPos[j].first) {
            players[i].final_pos = ladder.LadderPos[j].second;
          }
        }
        cout << players[i].name << " rolled a " << dice << " moved from "
             << " from " << players[i].initial_pos << " to "
             << players[i].final_pos << endl;
        // Check if player wins
        if (players[i].final_pos == 100) {
          cout << players[i].name << " won the game!" << endl;
          break;
        }
      }
      i = (i + 1) % total_players;
    }
  }
};

int main() {
  srand(time(0));
  int s, l, p;
  vector<pair<int, int> > SnakePos;
  vector<pair<int, int> > LadderPos;
  vector<Players> players;
  cout << "enter the number of snakes\n";
  cin >> s;

  cout << "enter the snake positions in the order of head and tail\n";
  for (int i = 0; i < s; i++) {
    int x, y;
    cin >> x >> y;
    SnakePos.push_back(make_pair(x, y));
  }
  cout << "enter the number of ladders\n";
  cin >> l;

  cout << "enter the ladder positions in the order of start and end\n";
  for (int i = 0; i < l; i++) {
    int x, y;
    cin >> x >> y;
    LadderPos.push_back(make_pair(x, y));
  }

  cout << "enter the number of players\n";
  cin >> p;

  cout << "enter the player names\n";
  for (int i = 0; i < p; i++) {
    string name;
    cin >> name;
    players.push_back(Players(name));
  }

  Snake snake(SnakePos);
  Ladder ladder(LadderPos);
  for (auto it = snake.SnakePos.begin(); it != snake.SnakePos.end();) {
    if (it->first < it->second) {
      cout << "Invalid snake positions at head: " << it->first
           << " and tail:" << it->second << endl;
      it = snake.SnakePos.erase(it);
    } else
      ++it;
  }
  for (auto it = ladder.LadderPos.begin(); it != ladder.LadderPos.end();) {
    if (it->first > it->second) {
      cout << "Invalid ladder positions at head: " << it->first
           << " and tail:" << it->second << endl;
      it = ladder.LadderPos.erase(it);
    } else
      ++it;
  }
  Game game(players, snake, ladder);
  game.playGame();
  return 0;
};