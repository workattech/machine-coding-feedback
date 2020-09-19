import random


class Dice:
    def __init__(self):
        pass

    def roll(self):
        return random.randint(1, 6)


class Player:
    def __init__(self, name):
        self.name = name
        self.curr_pos = 0


class SnakeAndLadder:
    def __init__(self):
        self.board = [[] for _ in range(101)]
        self.players = []
        self.snakes = {}
        self.ladders = {}

    def is_game_end(self):
        if self.board[100]:
            return True
        return False

    def add_player(self, player):
        self.players.append(player)

    def move(self, player, dice_val):
        play_pos = player.curr_pos
        new_pos = player.curr_pos + dice_val

        if new_pos <= 100:
            player.curr_pos = new_pos
            if player in self.board[play_pos]:
                self.board[play_pos].remove(player)
            self.board[new_pos].append(player)
            print(f"{player.name} rolled a {dice_val} and moved from {play_pos} to {new_pos}")
        else:
            print(f"{player.name} rolled a {dice_val} and can't move from {play_pos}")

        # Check for Ladder
        if player.curr_pos in self.ladders:
            esc_pos = self.ladders[player.curr_pos]
            player.curr_pos = esc_pos
            print(f"{player.name} encountered a ladder and moved from {player.curr_pos} to {esc_pos}")

        # Check for Ladder
        if player.curr_pos in self.snakes:
            dec_pos = self.snakes[player.curr_pos]
            player.curr_pos = dec_pos
            print(f"{player.name} encountered a snake and moved from {player.curr_pos} to {dec_pos}")

    def get_player_order(self):
        random.shuffle(self.players)
        return self.players
