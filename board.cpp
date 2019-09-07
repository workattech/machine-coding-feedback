#include <fstream>
#include <random>
#include <iostream>
#include "Board.h"

std::default_random_engine generator;
std::uniform_int_distribution<int> distribution(1, 6);

Board::Board(std::string inputFilePath, std::string outputFilePath)
{
    in_path.open(inputFilePath);
    out_path.open(outputFilePath);
    if(!in_path.is_open() || !out_path.is_open())
    {
        std::cerr << "Error in opening input or output file" << std::endl;
        exit(-1);
    }
    initiateBoardGame();
}

void Board::initiateBoardGame()
{
    int numSnakes, numLadders, numPlayers;
    in_path >> this->size;
    in_path >> numSnakes;
    for (int i = 0; i < numSnakes; i++)
    {
        int low, high;
        in_path >> high >> low;
        Snake_Ladder *s = new Snake(low, high);
        this->components.push_back(s);
    }
    in_path >> numLadders;
    for (int i = 0; i < numLadders; i++)
    {
        int low, high;
        in_path >> low >> high;
        Snake_Ladder *s = new Ladder(low, high);
        this->components.push_back(s);
    }
    in_path >> numPlayers;
    for (int i = 0; i < numPlayers; i++)
    {
        std::string name;
        in_path >> name;
        GamePlayer *p = new GamePlayer(name);
        this->players.push_back(p);
    }
}

void Board::startGame()
{

    out_path << "-------------------------------------------------------" << std::endl;
    out_path << "-------------------------------------------------------" << std::endl;
    out_path << "-------------------------------------------------------" << std::endl;
    int activePlayers = this->players.size();
    while (activePlayers > 1)
    {
        for (int i = 0; i < this->players.size(); i++)
        {
            if (!this->players[i]->getActiveStatus())
                continue;

            int k = this->players[i]->rollDice();
            int pos_init = this->players[i]->getCurrPosition();
            for (Snake_Ladder *comp : this->components)
            {
                int modified_pos = comp->modifyPosition(pos_init + k);
                if (modified_pos > this->size)
                {
                    // it means, we are landing outside the board, and this can't be due to any component
                    // it can only be due to the number thrown on the dice
                    // Thus we don't need to do any update in the current postion of the player
                    break;
                }
                this->players[i]->updatePosition(modified_pos);
                if (modified_pos != (pos_init + k))
                {
                    break;
                }
            }
            int pos_final = this->players[i]->getCurrPosition();

            out_path << this->players[i]->getName() << " rolled a " << k << " and moved from " << pos_init << " to " << pos_final << std::endl;

            if (pos_final == this->size)
            {
                out_path << "-------------------------------------------------------" << std::endl;
                out_path << this->players[i]->getName() << " wins among the currently active players" << std::endl;
                out_path << "-------------------------------------------------------" << std::endl;
                this->players[i]->setActiveStatus(false);
                activePlayers--;
                if (activePlayers <= 1)
                    break;
            }
        }
    }
    out_path << "-------------------------------------------------------" << std::endl;
    out_path << "-------------------------------------------------------" << std::endl;
    out_path << "-------------------------------------------------------" << std::endl;
}



void Board::restartGame()
{
    for (GamePlayer *p : this->players)
    {
        p->updatePosition(0);
        p->setActiveStatus(true);
    }
}

int GamePlayer::rollDice()
{
    return distribution(generator);
}