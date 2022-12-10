from random import randint

class Transition():
    def __init__(self,fromNumber,toNumber):
        self.fromNumber = fromNumber
        self.toNumber = toNumber
        

    def getTo(self):
        return self.toNumber

    def getFro(self):
        return self.fromNumber

class Snake(Transition):
    
    def getSnakeHead(self):
        return self.getFro()
    
    def getSnakeTail(self):
        return self.getTo()

    

class Ladder(Transition):
    def getLadderHead(self):
        return self.getFro()
    def getLadderTail(self):
        return self.getTo()


class Player():
    def __init__(self,name):
        self.name = name
        self.number = 0
    
    def getName(self):
        return self.name
    
    def getNumber(self):
        return self.number

    def setNumber(self,val):
        self.number = val

class Board():
    def __init__(self,snakes,ladders,players):
        self.snakes = snakes
        self.ladders = ladders
        self.players = players

    def getDiceValue(self):
        return randint(1,6)

    def makeMove(self):
        diceVal = self.getDiceValue()
        player = self.players[0]
        nextVal = player.getNumber() +  diceVal
        if nextVal > 100:
            return True
        player.setNumber(nextVal)
        for snake in self.snakes:
            if snake.getFro() == player.getNumber():
                player.setNumber(snake.getTo())
        for ladder in self.ladders:
            if ladder.getFro() == player.getNumber():
                player.setNumber(ladder.getTo())
        if player.getNumber() == 100:
            return False
        self.players.append(self.players.pop(0))
        return True


snake1 = Snake(50,10)
ladder = [Ladder(20,70)]
player1 = Player("spandan")
player2  = Player("swapnil")
players = [player1,player2]
snakes = [snake1]
boardObj = Board(snakes,ladder,players)
gameOn = True
while gameOn:
    gameOn = boardObj.makeMove()
    if not gameOn:
        break

