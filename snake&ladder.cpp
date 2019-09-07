#include <iostream>
#include <string>

#include "board.h"

int main()
{
    // read the file and create the board
    std::string inputFilePath, outputFilePath;
    std::cin >> inputFilePath;
    std::cin >> outputFilePath;
    Board game(inputFilePath, outputFilePath);
    bool playMore = false;
    do
    {
        game.restartGame();
        std::cout << "Starting the game play ................................" << std::endl;
        game.startGame();
        std::cout << "Game play has ended, output is stored in the output file" << std::endl;
        std::cout << "Do you want to play once more? enter 1 to continue else 0" << std::endl;
        int a;
        std::cin >> a;
        playMore = (a == 1);
    } while (playMore);
    return 0;
}