#include <iostream>
#include <map>
#include <vector>
#include <cstdlib>
#include <ctime>

using namespace std;

int rollDice() {
    return rand() % 6 + 1;
}

int main() {
    srand(time(0));

    map<int, int> snakes = {{14, 7}, {31, 12}, {37, 3}, {73, 56}};
    map<int, int> ladders = {{2, 23}, {8, 34}, {20, 77}, {32, 68}};

    vector<int> playerPositions = {0, 0}; // 2 players

    bool won = false;
    int turn = 0;

    while (!won) {
        int player = turn % playerPositions.size();
        cout << "Player " << player + 1 << "'s turn. Press Enter to roll dice.";
        cin.ignore();

        int dice = rollDice();
        cout << "Rolled a " << dice << endl;

        playerPositions[player] += dice;

        if (snakes[playerPositions[player]])
            playerPositions[player] = snakes[playerPositions[player]];

        if (ladders[playerPositions[player]])
            playerPositions[player] = ladders[playerPositions[player]];

        cout << "Player " << player + 1 << " is now at position " << playerPositions[player] << endl;

        if (playerPositions[player] >= 100) {
            cout << "Player " << player + 1 << " wins!" << endl;
            won = true;
        }

        turn++;
    }

    return 0;
}
