import random

DICE_START = 1
DICE_END = 6


class Dice:
    def __init__(self, dice_count):
        self.dice_count = dice_count

    def roll_dice(self):
        roll_total = 0
        for _ in range(self.dice_count):
            roll_total += random.randrange(DICE_START, DICE_END + 1)
        return roll_total


