class Board():

    def __init__(self, board_size, number_of_dices, final_position, root_pos, number_of_players, players, winner):
        self.__board_size = board_size
        self.__number_of_dices = number_of_dices
        self.__final_position = final_position
        self.__root_pos = root_pos
        self.__winner = winner
        self.__players = players
        self.__number_of_players = number_of_players

    def get_winner(self,):
        return self.__winner

    def get_player(self,i):
        return self.__players[i]

    def get_number_of_players(self):
        return self.__number_of_players

    def get_final_pos(self,i):
        return self.__final_position[i]

    def get_root_pos(self):
        return self.__root_pos

    def update_winner(self, name):
        self.__winner = name

    def find_root(self, x):
        while self.__root_pos[x] != x:
            self.__root_pos[x] = self.__root_pos[self.__root_pos[x]]
            x = self.__root_pos[x]
        return x

    def union(self, x, y):
        root_x = self.find_root(x)
        root_y = self.find_root(y)
        self.__root_pos[root_y] = self.__root_pos[root_x]