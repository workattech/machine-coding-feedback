import random

class Player:
    ## Creating player object to store name and current position of player
    def __init__(self,name):
        self.name=name
        self.position=0

    def getName(self):
        return self.name
    
    def setPosition(self,pos):
        self.position=pos
        
    def getPosition(self):
        return self.position

class Dices:
    ## Creating number of Dices
    def __init__(self,number_of_dices):
        self.dice_count=number_of_dices

    def rollDices(self):
        result=[]
        for i in range(self.dice_count):
            result.append(random.randint(1,7))
        return result

class Board:
    ## Generating Board with given snakes,ladders and size
    def __init__(self,snakes,ladders,size):
        self.snakes=snakes
        self.ladders=ladders
        self.size=size

    def getNewPos(self,curr_pos,dice_roll):
        if curr_pos+dice_roll<=self.size:
            curr_pos+=dice_roll

        if curr_pos==self.size-1 and dice_roll==2:
            curr_pos=self.size
            
        while curr_pos in self.snakes or curr_pos in self.ladders:
            if curr_pos in self.snakes:
                curr_pos=self.snakes[curr_pos]
            if curr_pos in self.ladders:
                curr_pos=self.ladders[curr_pos]
        return curr_pos

    def checkWin(self,pos):
        if pos==self.size:
            return True
        return False

def initialize(num_dices):
    snakes={}
    ladders={}
    ## Taking input
    size_of_board=int(input())
    for i in range(int(input())):
        start,end=map(int,input().split())
        snakes[start]=end

    for i in range(int(input())):
        start,end=map(int,input().split())
        ladders[start]=end
    board=Board(snakes,ladders,size_of_board)
    
    players=[]
    for i in range(int(input())):
        name=input()
        players.append(Player(name))
        
    dices=Dices(num_dices)
    
    return board,players,dices

def play(board,dices,players):
    players_left=len(players)
    next_win_position=1
    turn=0

    while players_left>1:
        dice_rolls=dices.rollDices()
        move_by=sum(dice_rolls)

        start=players[turn].getPosition()
        new_pos=board.getNewPos(start,move_by)
        players[turn].setPosition(new_pos)

        print(players[turn].getName(),"rolled a",','.join(str(dices) for dices in dice_rolls),"and moved from",start,"to",new_pos)

        if board.checkWin(new_pos):
            print(players[turn].getName(),"has finished at position",next_win_position)
            players_left-=1
            next_win_position+=1
            players.pop(turn)
        else :
            turn=(turn+1)%players_left
        
def main():
    num_dices=2
    board,players,dices=initialize(num_dices)
    play(board,dices,players)
    
if __name__=="__main__":
    main()
