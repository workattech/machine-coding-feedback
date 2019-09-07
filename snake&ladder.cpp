#include <iostream>
#include <string>

#include "board.h"

int main()
{
    // read the file and create the board
    std::string filePath;
    std::cin >> filePath;
    Board game(filePath);
    bool playMore = false;
    do
    {
        game.restartGame();
        game.startGame();
        std::cout << "Do you want to play once more? enter 1 to continue else 0" << std::endl;
        int a;
        std::cin >> a;
        playMore = (a == 1);
    } while (playMore);
    return 0;
}