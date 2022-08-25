from models.board import Board
from models.game import Game

game_board = Board()
# game = Game()

print(f"Enter Number of snakes")
snakes_count = int(input())

for i in range(0, snakes_count):
    print(f"Enter head & Tail position for snake number: {i}")
    snake_ip = input().split()

    game_board.register_cell_object(int(snake_ip[0]), int(snake_ip[1]), "snake")

print(f"Enter Number of ladders")
ladders_count = int(input())

for i in range(0, ladders_count):
    print(f"Enter head & Tail position for ladder number: {i}")
    ladder_ip = input().split()

    game_board.register_cell_object(int(ladder_ip[0]), int(ladder_ip[1]), "ladder")

print("Enter number of player")

players_count = int(input())

game = Game(game_board)

for i in range(0, players_count):
    print(f"Enter player name for player number: {i}")

    player_name = input()

    game.register_player(player_name)

while(not game.winner):
    game.play_move()

print(f"{game.winner.name} wins the game")

