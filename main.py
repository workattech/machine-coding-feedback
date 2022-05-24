from utilities.game import PlayGame, Player


if __name__ == '__main__':

    tot_snakes = int(input("Input the number of snakes:"))
    # Storing snake's head as key and snake's tail as it's value in dictionary
    snake_pos = dict()
    for _ in range(tot_snakes):
        head = int(input())
        tail = int(input())
        snake_pos[head] = tail
    # Sample Ex:
    # snake_pos = {33: 6, 98: 64, 56: 53, 49: 9, 88: 16, 41: 20, 93: 73, 62: 5, 95: 75}

    tot_ladders = int(input("Input the number of ladders:"))
    # Storing ladders's bottom as key and ladders's top as it's value in dictionary
    ladder_pos = dict()
    for _ in range(tot_ladders):
        bottom = int(input())
        top = int(input())
        ladder_pos[bottom] = top
    # Sample EX:
    # ladder_pos = {65: 84, 2: 37, 51: 68, 81: 100, 71: 91, 10: 32, 27: 46, 61: 79}

    tot_players = int(input("Input the number of players:"))
    players = []
    for _ in range(tot_players):
        player_obj = Player(input())
        players.append(player_obj)

    player_obj = PlayGame(snake_pos, ladder_pos, players)
    print("{} wins the game".format(player_obj.winner.name))
    print("Game Over!!")
