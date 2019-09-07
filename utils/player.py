

class Player():

    def __init__(self, name):
        self.__name = name
        self.__curr_pos = 0

    def move_player_by(self, x, board_size):
        if self.__curr_pos + x <= board_size:
            self.__curr_pos += x

    def move_player_to(self, x):
        self.__curr_pos = x

    def is_winner(self, target=100):
        if self.__curr_pos == target:
            return True
        return False

    def get_current_pos(self):
        return self.__curr_pos

    def get_name(self):
        return self.__name
