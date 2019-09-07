from Board import Board
from Snake import Snake
from Ladder import Ladder

import random

def roll_die():
    return random.randint(1, 6)


def create_board():
    size = int(input())
    no_of_snakes = int(input())
    snakes = []
    for i in range (0, no_of_snakes):
        start, end = input().split(' ')
        snake = Snake(int(start), int(end))
        snakes.append(snake)
    no_of_ladders = int(input())
    ladders = []
    for i in range (0, no_of_ladders):
        start, end = input().split(' ')
        ladder = Ladder(int(start), int(end))
        ladders.append(ladder)

    no_of_players = int(input())
    players = []
    for i in range (0, no_of_players):
        players.append(input().split(' '))


    board = Board(size, snakes, ladders)
    positions = [0] * no_of_players

    return board, positions, players

def check_consecutive_snakes(currPos):
    start = currPos
    while(True):
        end = board.snakeAt(start)
        if(end == -1):
            break
        else:
            start = end
    return start

def check_consecutive_ladders(currPos):
    start = currPos
    while(True):
        end = board.ladderAt(start)
        if(end == -1):
            break
        else:
            start = end
    return start

def get_final_pos(currPos):
    while(True):
        start = currPos
        while(True):
            end1 = check_consecutive_snakes(start)
            end2 = check_consecutive_ladders(end1)

            if(end1 == end2):
                break
            else:
                start = end2
        return start

def move_to_next_player(playerNumber):
    if (playerNumber == len(positions) - 1):
        playerNumber = 0
    else:
        playerNumber = playerNumber + 1

    return playerNumber

def play_game(board, positions, players):
    playerNumber = 0
    no_of_people_won = 0
    while(True):
        if(positions[playerNumber] == board.size):
            playerNumber = move_to_next_player(playerNumber)
            continue

        value = roll_die()
        currPos = positions[playerNumber] + value

        if(currPos > board.size):
            finalPos = positions[playerNumber]

        elif(currPos == board.size):
            finalPos = currPos

        else:
            finalPos = get_final_pos(currPos)

        print(players[playerNumber][0] + " rolled a " + str(value) + " and moved from " + str(positions[playerNumber]) + " to " + str(finalPos))

        if(finalPos == board.size):
            no_of_people_won = no_of_people_won + 1
            print(players[playerNumber][0] + " wins the game at position " + str(no_of_people_won))
            if(no_of_people_won == len(players)-1):
                break

        positions[playerNumber] = finalPos
        playerNumber = move_to_next_player(playerNumber)

board, positions, players = create_board()
play_game(board, positions, players)


##PLEASE NOTE

#First input to be number of cells
#Multiplayer supported. Game will continue till one player is left
