class Player:
    def __init__(self, name):
        self.name = name
        self.pos = 0

    def roll_dice_and_move(self, board, dice):
        dice_val = dice.roll_dice()
        old_pos = self.pos
        if dice_val + self.pos <= 100:
            self.pos += dice_val
        if self.pos in board.snakes:
            self.pos = board.snakes[self.pos]
        if self.pos in board.ladders:
            self.pos = board.ladders[self.pos]
        print(self.name + ' rolled a ' + str(dice_val) + ' and moved from ' + str(old_pos) + ' to ' + str(self.pos))
        return self.pos


