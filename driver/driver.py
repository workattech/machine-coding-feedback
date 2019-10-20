from itertools import cycle

from models import Board, Player, Game

class Driver(object):
    
    def read_board_input(self):
        list_of_objects = []
        no_of_objects = int(input())
        for _ in range(no_of_objects):
            inp1, inp2 = map(int,input().split())
            list_of_objects.append((inp1, inp2))
        return list_of_objects
    
    def read_players(self):
        list_of_players = []
        no_of_players = int(input())
        for _ in range(no_of_players):
            p_name = input().strip()
            list_of_players.append(Player(p_name))
        return list_of_players

    def main(self):
        board = Board()

        board.set_snakes(self.read_board_input())
        # board.set_snakes([(62,5),(33,6),(49,9),(88,16),(41,20),(56,53),(98,64),(93,73),(95,75)])
        
        board.set_ladders(self.read_board_input())
        # board.set_ladders([(2,37),(27,46),(10,32),(51,68),(61,79),(65,84),(71,91),(81,100)])
        
        players = self.read_players()
        # players = [Player('Ashish'), Player('Samin')]
        
        player_lineup = cycle(players)

        while Game._continue_game:
            current_player = next(player_lineup)
            current_player.play_turn()
