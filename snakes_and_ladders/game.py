from .dice import Dice
from .board import Board
from .player import Player

class Game:
    def __init__(self, snakes, ladders, player_names):
        self.board = Board(snakes, ladders)
        self.players = [Player(name) for name in player_names]
        self.dice = Dice()

    def play(self):
        won = False
        while not won:
            for player in self.players:
                dice_value = self.dice.roll()
                initial_pos = player.position
                new_pos = initial_pos + dice_value
                if new_pos > 100:
                    new_pos = initial_pos
                else:
                    new_pos = self.board.get_next_position(new_pos)

                player.position = new_pos
                print(f"{player.name} rolled a {dice_value} and moved from {initial_pos} to {new_pos}")

                if new_pos == 100:
                    print(f"{player.name} wins the game")
                    won = True
                    break
