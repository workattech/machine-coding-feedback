from board import Board
from dice import Dice
from player import Player

BOARD_SIZE = 100
DICE_COUNT = 1


if __name__ == "__main__":

    with open("input.txt", "r") as f:

        snakes = {}
        snakes_count = int(f.readline())
        for i in range(snakes_count):
            start, end = f.readline().split(' ')
            snakes[int(start)] = int(end)

        ladders = {}
        ladders_count = int(f.readline())
        for i in range(ladders_count):
            start, end = f.readline().split(' ')
            ladders[int(start)] = int(end)

        players = []
        players_count = int(f.readline())
        for i in range(players_count):
            player_name = f.readline()
            players.append(Player(player_name))

    board = Board(BOARD_SIZE, snakes, ladders)
    dice = Dice(DICE_COUNT)
    finding_winner = True
    while finding_winner:
        for each_player in players:
            each_player.roll_dice_and_move(board, dice)
            if board.is_winner(each_player):
                finding_winner = False
                break
