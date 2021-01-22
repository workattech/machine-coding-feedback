class Player:
    
    def __init__(self, name, board):
        self.name = name
        self.position = 0
        self.board = board
    
    def move(self, moves):
        if self.position + moves <= self.board.size:
            self.position += moves
            if self.position in self.board.snakes:
                # print("Ouch! Snake bite stings", self.name)
                self.position = self.board.snakes[self.position]
            
            if self.position in self.board.ladders:
                # print("Hurrah! Ladder to the heaven", self.name)
                self.position = self.board.ladders[self.position]
    