#include <bits/stdc++.h>
#include "./SnakeAndLadder/Models/dice.cpp"
#include "./SnakeAndLadder/Models/ladder.cpp"
#include "./SnakeAndLadder/Models/snake.cpp"
#include "./SnakeAndLadder/Models/player.cpp"
#include "./SnakeAndLadder/Models/board.cpp"
#include "./SnakeAndLadder/game.cpp"

using namespace std;

int main(){
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);

    int DEFAULT_BOARD_SIZE = 100;
    int DEFAULT_NUMBER_OF_DICE = 1;

// input
    int numberOfSnake;
    cin >> numberOfSnake;
    vector<Snake*> snakes;
    for(int i = 0 ; i < numberOfSnake ; ++i){
        int start, end;
        cin >> start >> end;
        snakes.push_back(new Snake(start, end));
    }

    int numberOfLadder;
    cin >> numberOfLadder;
    vector<Ladder*> ladders;
    for(int i = 0 ; i < numberOfLadder ; ++i){
        int start, end;
        cin >> start >> end;
        ladders.push_back(new Ladder(start, end));
    }

    int numberOfPlayer;
    cin >> numberOfPlayer;
    vector<Player*> players;

    for(int i = 0 ; i < numberOfPlayer ; ++i){
        string name;
        cin >> name;
        players.push_back(new Player(to_string(i), name));
    }

    Board *board = new Board(DEFAULT_BOARD_SIZE,DEFAULT_NUMBER_OF_DICE, ladders, snakes, players);
    Game *game = new Game(board);
    game->start();


    return 0;
}
