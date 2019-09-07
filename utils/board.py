from .player import Player
from .movable import Movable
from random import randrange

class Board():

    def __init__(self, 
                board_size, 
                player_list, 
                snake_list, 
                ladder_list,
                no_of_dice=1):

        self.__board_size = board_size
        self.__player_list = player_list
        self.__snake_list = snake_list
        self.__ladder_list = ladder_list

        self.__no_of_dice = no_of_dice

        self.__curr_player = 0  # current player holding the dice
        self.__total_players = len(self.__player_list)

        self.__rank = {}

        self.__init_board()

    def __init_board(self):
        self.__movable_source_to_destination = {}

        for snake in self.__snake_list:
            self.__movable_source_to_destination[snake.get_source()] = snake.get_target()
        
        for ladder in self.__ladder_list:
            self.__movable_source_to_destination[ladder.get_source()] = ladder.get_target()

    def make_move(self):
        
        __player = self.get_current_player()
        __source = __player.get_current_pos()
        __dice_val = self.__get_dice_val()

        if not __player in self.__rank:

            __player.move_player_by(__dice_val, self.__board_size)

            __player_current_pos = __player.get_current_pos()

            # encountered a snake or ladder
            if __player_current_pos in self.__movable_source_to_destination:
                __player.move_player_to(self.__movable_source_to_destination[__player_current_pos])

            if __player.is_winner(self.__board_size):
                self.__rank[__player] = len(self.__rank)+1

        __player = self.__player_list[self.__curr_player]
        # Pass dice to next player
        self.__curr_player = (self.__curr_player + 1)%self.__total_players
        
        return __dice_val, __source, __player 

    # roll dice and get value
    def __get_dice_val(self):
        val = 0
        six_cnt = 0
        chances = 1
        while (chances != 0):
            x = 0
            for d in range(self.__no_of_dice):
                x += randrange(1, 6)
            if x == 6:
                six_cnt += 1
                chances += 1
            val += x
            # 3 times sixes
            if six_cnt == 3:
                val = 0
                six_cnt = 0
            chances -= 1
        return val

    # return the player who is holding the dice
    def get_current_player(self):
        return self.__player_list[self.__curr_player]

    # return how many players have won yet
    def get_number_of_winner(self):
        return len(self.__rank)

    # returns ranking for players at current instant
    def get_rank_list(self):
        return self.__rank
