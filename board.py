class Board():

    def __init__(self, board_size, number_of_dices, final_position, root_pos, number_of_players, players, leaderboard):
        self.__board_size = board_size
        self.__number_of_dices = number_of_dices
        self.__final_position = final_position
        self.__root_pos = root_pos
        self.__leaderboard = leaderboard
        self.__players = players
        self.__number_of_players = number_of_players

    # Get the whole Leader Board
    def get_leaderboard(self,):
        return self.__leaderboard

    # Get the player whose turn is next
    def get_player(self,i):
        return self.__players[i]

    # Get number of players left
    def get_number_of_players(self):
        return self.__number_of_players

    # Get the position a player must go to if he lands on ith block
    def get_final_pos(self,i):
        return self.__final_position[i]

    # Get the end position
    def get_end_position(self):
        return self.__board_size

    def get_root_pos(self):
        return self.__root_pos

    # Update the leaderboard when a player reaches the end
    def update_leaderboard(self, name):
        self.__leaderboard.append(name)
        self.__number_of_players = self.__number_of_players - 1
        self.__players.remove(name)

    def find_root(self, x):
        while self.__root_pos[x] != x:
            self.__root_pos[x] = self.__root_pos[self.__root_pos[x]]
            x = self.__root_pos[x]
        return x

    def union(self, x, y):
        root_x = self.find_root(x)
        root_y = self.find_root(y)
        self.__root_pos[root_y] = self.__root_pos[root_x]