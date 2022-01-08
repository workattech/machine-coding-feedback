#include <iostream>
#include<vector>
#include<unordered_map>
#include<ctime>
#include<fstream>
#include<sstream>
using namespace std;

class Board {  
  int board_size;
  unordered_map<int, int> snakes;
  unordered_map<int, int> ladders;
  void addSnake(int start, int end) {
    snakes[start] = end;
  }

  void addLadder(int start, int end) {
    ladders[start] = end;
  }
  
  bool isSnake(int position) {
    return snakes.find(position) != snakes.end();
  }

  bool isLadder(int position) {
    return ladders.find(position) != ladders.end();
  }

  bool isValidMove(int position, int diceValue) {
    return (position + diceValue) <= board_size;
  } 

  public:
    Board() {}
    Board(int board_size, vector<vector<int>> &snakes, vector<vector<int>> &ladders) {
      this->board_size = board_size;
      for (const auto snake : snakes) {
        addSnake(snake[0], snake[1]);
      }
      for (const auto ladder : ladders) {
        addLadder(ladder[0], ladder[1]);
      }
    }  

    int move(int currentPosition, int diceValue) {
      if (!isValidMove(currentPosition, diceValue)) return 0;
      int newPosition = currentPosition + diceValue;      
      if (isSnake(newPosition)) {
        return snakes[newPosition];
      } else if (isLadder(newPosition)) {
        return ladders[newPosition];
      }
      return newPosition;
    }
};

class Player {
  string name;
  int currentPosition;
  public:
    Player(string name, int currentPosition) {
      this->name = name;
      this->currentPosition = currentPosition;
    }

    void setCurrentPosition(int position) {
      currentPosition = position;
    }

    int getCurrentPosition() {
      return currentPosition;
    }
    string getName() {
      return name;
    }
};

class Game {
  vector<Player> players;
  Board board;
  int playerTurn = 0;
  int playerWon = -1;
      
  int diceRoll() {
    int diceValue = 1 + rand() % 6;
    return diceValue;
  }

  bool isGameOver() {
    return playerWon != -1;
  }
  public:
    Game(int board_size, vector<string> &players, vector<vector<int>> &snakes, vector<vector<int>> &ladders) {
      this->board = Board(board_size, snakes, ladders);      
      for (auto player: players) { 
        this->players.push_back(Player(player, 0));
      }
    }
    void startGame() {
      while (!isGameOver()) {
        int diceValue = diceRoll();
        Player currentPlayer = players[playerTurn];
        int playerCurrentPosition = currentPlayer.getCurrentPosition();       
        int newPosition = board.move(playerCurrentPosition, diceValue);

        players[playerTurn].setCurrentPosition(newPosition);

        if (newPosition == 100) {
          playerWon = playerTurn;
          printf("%s wins the game\n", currentPlayer.getName().c_str());
          break;
        } 
        printf("%s rolled a %d and moved from %d to %d\n", currentPlayer.getName().c_str(), diceValue, playerCurrentPosition, newPosition);
        
        playerTurn = (playerTurn+1)%players.size();
      }
    }
};

int main() {  
  srand(time(NULL));  
  fstream file;
  file.open("input.txt", ios::in);
  vector<string> players;
  vector<vector<int>> snakes, ladders;
  if (file.is_open()) {
    string temp;
    getline(file, temp);    
    int numSnakes = stoi(temp);
    while (numSnakes--) {
      getline(file, temp);      
      stringstream ss(temp);
      int position;
      vector<int> tempV;
      while (ss >> position) {        
        tempV.push_back(position);        
      }
      snakes.push_back(tempV);
    }    

    getline(file, temp);
    int numLadders = stoi(temp);
    while (numLadders--) {
      getline(file, temp);      
      stringstream ss(temp);
      int position;
      vector<int> tempV;
      while (ss >> position) {        
        tempV.push_back(position);        
      }
      ladders.push_back(tempV);      
    }
    getline(file, temp);
    int numPlayers = stoi(temp);
    while (numPlayers--) {
      getline(file, temp);            
      players.push_back(temp);      
    }
  }
  Game game(100, players, snakes, ladders);
  game.startGame();
} 