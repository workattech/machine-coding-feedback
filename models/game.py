from random import randint

class Game:
    
    _continue_game = True
    
    def roll(self):
        return randint(1,6)
    
    def endgame(self):
        Game._continue_game = False
