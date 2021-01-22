from Player import Player
from Board import Board
from Parser import Parser
from Dice import Dice

class Game:

    def __init__(self, faces, players, board_size, snakes, ladders):

        self.snakes = {}
        self.ladders = {}
        self.board_size = board_size
        self.dice = Dice(faces)

        for src, dest in snakes:
            self.snakes[src] = dest

        for src, dest in ladders:
            self.ladders[src] = dest

        self.board = Board(self.board_size,self.snakes, self.ladders)
        self.players = [Player(name, self.board) for name in players]
    
    def play(self):
        while(1):
            for player in self.players:
                from_position = player.position
                dice_value = self.dice.roll()
                player.move(dice_value)
                to_position = player.position
                print(player.name, "rolled a", dice_value,  "and moved from", from_position, "to", to_position)
                if player.position == self.board_size:
                    return player.name + " wins the game"

parser = Parser()

game = Game(parser.faces, parser.players, parser.board_size, parser.snakes, parser.ladders)
print(game.play())
    


