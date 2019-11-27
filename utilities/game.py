from random import randint


class Player:
    def __init__(self, name):
        self.pos = 0
        self.name = name


class PlayGame(Player):
    def __init__(self, snake_pos, ladder_pos, player):
        self.winner = None
        self.snake_pos = snake_pos
        self.ladder_pos = ladder_pos
        self.players = player
        print("Starting the Game!")
        self._play()

    def _perform_action(self, num):
        """
        This functions performs below actions:
        1. If the num is at snake's head, change the new_pos to it's tail
        2. If the num is at ladder's bottom change the new_pos to is's top
        3. Else do nothing
        :param num:
        :return:
        """
        new_pos = num
        if self._is_ladder(num, list(self.ladder_pos.keys())):
            new_pos = self.ladder_pos[num]
        elif self._is_snake(num, list(self.snake_pos.keys())):
            new_pos = self.snake_pos[num]
        return new_pos

    @staticmethod
    def _roll_dice():
        """
        It generates random integer between 1 and 6
        :return:
        """
        value = randint(1, 6)
        return value

    @staticmethod
    def _is_snake(num, head):
        """
        This function returns True if the current number is at a snake's head
        :param num:
        :param head:
        :return:
        """
        return num in head

    @staticmethod
    def _is_ladder(num, bottom):
        """
        This function returns True if the given num is at a ladder's bottom
        :param num:
        :param bottom:
        :return:
        """
        return num in bottom

    @staticmethod
    def _over_dest(num):
        """
        This functions return True if the num exceeds 100
        :param num:
        :return:
        """
        return num > 100

    @staticmethod
    def _final_dest(num):
        """
        Returns True if the player reached to fina destination i.e.100
        :param num:
        :return:
        """
        return num == 100

    def _play(self):
        """
        This is the driver function of the snake and ladder game
        :return:
        """
        while not self.winner:
            for player in self.players:
                steps = self._roll_dice()
                probab_pos = player.pos + steps
                if self._over_dest(probab_pos):
                    continue
                while True:
                    new_pos = self._perform_action(probab_pos)
                    if new_pos == probab_pos:
                        break
                    probab_pos = new_pos
                print("{} rolled a {} and moved from {} to {}".format(player.name, steps, player.pos, new_pos))
                player.pos = new_pos
                if self._final_dest(player.pos):
                    self.winner = player
                    break
