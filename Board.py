class Board():
    def __init__(self, size, snakes, ladders):
        self.size = size
        self.snakes = snakes
        self.ladders = ladders

    def snakeAt(self, currPos):
        for snake in self.snakes:
            if snake.start == currPos:
                return snake.end

        return -1

    def ladderAt(self, currPos):
        for ladder in self.ladders:
            if ladder.start == currPos:
                return ladder.end

        return -1

