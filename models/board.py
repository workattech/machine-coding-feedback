class Board:
    max_position = 100
    min_position = 1

    snakes = {}
    ladders = {}

    def run_snakes_ladders(self, p_pos):
        
        player_pos = p_pos
        snake = ladder = True
        
        while snake or ladder:
            if player_pos in Board.snakes.keys():
                player_pos = Board.snakes[player_pos]
            else:
                snake = False

            if player_pos in Board.ladders.keys():
                player_pos = Board.ladders[player_pos]
            else:
                ladder = False

        return player_pos

    def set_snakes(self, list_of_snakes):
        for head, tail in list_of_snakes:
            Board.snakes[head] = tail

    def set_ladders(self, list_of_ladders):
        for start, end in list_of_ladders:
            Board.ladders[start] = end
