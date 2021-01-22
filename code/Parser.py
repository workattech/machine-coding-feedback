class Parser:

    def __init__(self):

        f = open('input.txt', 'r')

        self.snakes = []

        for snake in range(int(f.readline().rstrip('\n'))):
            self.snakes.append(map(int, f.readline().rstrip('\n').split()))

        self.ladders = []

        for ladder in range(int(f.readline().rstrip('\n'))):
            self.ladders.append(map(int, f.readline().rstrip('\n').split()))

        self.players = []

        for player in range(int(f.readline().rstrip('\n'))):
            self.players.append(f.readline().rstrip('\n'))

        f.close()

        self.board_size = 100
        self.faces = 6
