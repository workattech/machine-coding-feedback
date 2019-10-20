from .game import Game
from .board import Board

class Player(Game):

    board = Board()

    def __init__(self, name):
        self._name = name
        self._piece_pos = 0
    
    def play_turn(self):
        die_cast = self.roll()
        if self.is_move_viable(die_cast):
            new_piece_pos = Player.board.run_snakes_ladders(die_cast + self.piece_pos)
            self.move(die_cast, new_piece_pos)
        else:
            self.move(die_cast, self.piece_pos)
        self.if_won()

    def if_won(self):
        if self.piece_pos == Player.board.max_position:
            self.endgame()
            print(f"{self.name} wins the game")

    def is_move_viable(self, num_on_die):
        return True if (self.piece_pos + num_on_die <= Player.board.max_position) else False

    def move(self, num_on_die, new_piece_pos):
        print(f"{self.name} rolled a {num_on_die} and moved from {self.piece_pos} to {new_piece_pos}")
        self.piece_pos = new_piece_pos

    # getters and setters
    @property
    def name(self):
        return self._name
    
    @name.setter
    def name(self, player_name):
        self._name = player_name

    @property
    def piece_pos(self):
        return self._piece_pos
    
    @piece_pos.setter
    def piece_pos(self, player_piece_pos):
        self._piece_pos = player_piece_pos