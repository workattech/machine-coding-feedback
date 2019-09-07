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
