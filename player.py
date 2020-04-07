class Player():
    def __init__(self, name, position):
        # Player name and current position
        self.__name = name
        self.__position = position

    def name(self):
        return self.__name

    def position(self):
        return self.__position

    def update_position(self, new_position):
        self.__position = new_position
