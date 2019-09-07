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
