from Player import Player
from dice import Dices   
from board import Board

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
            turn=turn%players_left
        else :
            turn=(turn+1)%players_left
        
def main():
    num_dices=2
    board,players,dices=initialize(num_dices)
    play(board,dices,players)
    
if __name__=="__main__":
    main()
