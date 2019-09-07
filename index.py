import sys
from lib import *
from player import Player
from board import Board

# Initialize the Board and Player objects
def init(final_pos, root_pos, players, number_of_players):
    board = Board(100, 1, final_pos, root_pos, number_of_players, players, 'none')
    player_info = {}
    for player in players:
        player_info[player] = Player(player, 0)
    playGame(player_info, board)


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
    s = int(f1[0])
    for i in range(1, 101):
        final_pos[i] = i
        root[i] = i
    for i in range(1, s + 1):
        x, y = map(int, f1[i].split())
        if root[x] != root[y]:
            union(root, x, y)
        final_pos[find_root(root, x)] = y
    l = int(f1[s + 1])
    for i in range(s + 2, s + l + 2):
        x, y = map(int, f1[i].split())
        if root[x] != root[y]:
            union(root, x, y)
        final_pos[find_root(root, x)] = y
    p = int(f1[s + l + 2])
    for i in range(s + l + 3, s + l + p + 3):
        players.append(f1[i])
    init(final_pos, root, players, p)


if __name__ == "__main__":
    read_input(sys.argv[1])
