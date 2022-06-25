import random
class Dices:
    ## Creating number of Dices
    def __init__(self,number_of_dices):
        self.dice_count=number_of_dices

    def rollDices(self):
        result=[]
        for i in range(self.dice_count):
            result.append(random.randint(1,6))
        return result
