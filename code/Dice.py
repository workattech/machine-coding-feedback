from random import randint
class Dice:

    def __init__(self, faces):
        self.faces = faces

    def roll(self):
        return randint(1, self.faces)