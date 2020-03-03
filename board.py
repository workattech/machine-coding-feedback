class Board:
    def __init__(self, size, snakes, ladders):
        self.size = size
        self.snakes = snakes
        self.ladders = ladders

    def is_winner(self, player):
        if player.pos == self.size:
            print(player.name + ' wins the game')
            return True
        return False


