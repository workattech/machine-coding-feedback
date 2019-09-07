import sys
from lib import *
from player import Player
from board import Board

# Initialize the Board and Player objects
def init(final_pos, root_pos, players, number_of_players, board_size):
    board = Board(board_size, 1, final_pos, root_pos, number_of_players, players, [])
    player_info = {}

    # Initializing the player positions to 0
    for player in players:
        player_info[player] = Player(player, 0)

    # Start the game
    playGame(player_info, board)

    # Print the Leaderboard
    leaderboard = board.get_leaderboard()
    position = 1
    for player in leaderboard:
        print('{0} - {1}'.format(position, player))
        position = position + 1

'''
 Using Disjoint Set Union for maintaining the end position a person would go to if he lands on ith block
 and to maintain connecting snakes and ladders
'''
def find_root(root, x):
    while root[x] != x:
        root[x] = root[root[x]]
        x = root[x]
    return x


def union(root, x, y):
    root_x = find_root(root, x)
    root_y = find_root(root, y)
    root[root_y] = root[root_x]

# Parsing the input file
def read_input(inputfile):
    final_pos = {}
    root = {}
    players = []
    f = open(inputfile, 'r')
    f1 = f.read().splitlines()

    # Getting the board size
    board_size = int(f1[0])

    # Getting the number of snakes
    s = int(f1[1])

    for i in range(1, board_size+1):
        final_pos[i] = i
        root[i] = i
    for i in range(2, s + 2):
        x, y = map(int, f1[i].split())
        if root[x] != root[y]:
            union(root, x, y)
        final_pos[find_root(root, x)] = y

    # Getting the number of ladders
    l = int(f1[s + 2])
    for i in range(s + 3, s + l + 3):
        x, y = map(int, f1[i].split())
        if root[x] != root[y]:
            union(root, x, y)
        final_pos[find_root(root, x)] = y

    # Getting the number of players
    p = int(f1[s + l + 3])
    for i in range(s + l + 4, s + l + p + 4):
        players.append(f1[i])
    init(final_pos, root, players, p, board_size)


if __name__ == "__main__":
    read_input(sys.argv[1])
