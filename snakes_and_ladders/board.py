class Board:
    def __init__(self, snakes, ladders):
        self.snakes = snakes  # dict {head: tail}
        self.ladders = ladders  # dict {start: end}

    def get_next_position(self, position):
        prev = -1
        while prev != position:
            prev = position
            if position in self.snakes:
                position = self.snakes[position]
            elif position in self.ladders:
                position = self.ladders[position]
        return position
