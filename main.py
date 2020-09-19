from copy import copy

from classes import SnakeAndLadder, Player, Dice

game = SnakeAndLadder()

# get the snakes
s = int(input())
snakes = {}
for _ in range(s):
    start, end = map(int, input().split(" "))
    snakes[start] = end
    game.snakes[start] = end

# get the ladders
l = int(input())
ladders = {}
for _ in range(l):
    start, end = map(int, input().split(" "))
    ladders[start] = end
    game.ladders[start] = end

# get the players
n = int(input())
players = []
for _ in range(n):
    player = str(input())
    players.append(player)

    p = Player(player)
    game.add_player(p)

# Orchestrate
dice = Dice()
player_order = game.get_player_order()

curr_play = 0
count = 10
while not game.is_game_end():
    dice_val = dice.roll()
    game.move(player_order[curr_play], dice_val)

    if dice_val != 6:
        curr_play = (curr_play + 1) % len(game.players)

    count -= 1
