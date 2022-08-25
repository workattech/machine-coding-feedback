import logging
from models.player import Player
from models.board import Board
import random

class Game:
    def __init__(self, board: Board) -> None:
        self.board = board
        self.winner = None
        self.players = []

    def register_player(self, player_name):
        player = Player(player_name)
        self.players.append(player)

    def _roll_dice(self):
        return random.randint(1,6)

    def _calculate_new_position(self, current_position, dice_digit):
        new_position = current_position + dice_digit

        if new_position > 100:
            new_position = current_position

        # if there was a snake or ladder at given position
        # then apply the result
        if new_position in self.board.cell_objects:
            return self.board.cell_objects[new_position]["destination_cell"]
        
        return new_position

    def play_move(self):
        for curr_player in self.players:
            dice_result = self._roll_dice()
            # print(curr_player.name,":", curr_player.cell_position)
            new_position = self._calculate_new_position(curr_player.cell_position, dice_result)

            print(f"{curr_player.name} rolled a {dice_result} and moved from {curr_player.cell_position} to {new_position}")

            curr_player.cell_position = new_position
            
            if new_position == 100:
                self.winner = curr_player
                break
