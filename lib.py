import random


def playGame(player_info, board):
    # Initializing with 1st player
    cur_player = 0

    # Game will be played until one player is left
    while board.get_number_of_players() > 1:
        # Selecting random dice value
        dice_value = random.randint(1, 6)

        # Getting current player and his/her position
        player = board.get_player(cur_player)
        cur_pos = player_info[player].position()

        # Handling 3 consecutive sixes
        if dice_value == 6:
            dice_value2 = random.randint(1, 6)
            if dice_value2 == 6:
                dice_value3 = random.randint(1, 6)
                if dice_value3 == 6:
                    print('{0} rolled three {1} and remained in {2}'.format(player, dice_value, cur_pos))
                    cur_player = (cur_player + 1) % board.get_number_of_players()
                    continue;
                else:
                    dice_value = dice_value + dice_value2 + dice_value3
            else:
                dice_value = dice_value + dice_value2

        # After the dice roll, if a piece is supposed to move outside board, it does not move.
        if dice_value + cur_pos > board.get_end_position():
            print('{0} rolled a {1} and moved from {2} to {3}'.format(player, dice_value, cur_pos, cur_pos))
            cur_player = (cur_player + 1) % board.get_number_of_players()
            continue

        # Calculating final position after the dice roll
        new_pos = board.get_final_pos(board.find_root(dice_value + cur_pos))
        print('{0} rolled a {1} and moved from {2} to {3}'.format(player, dice_value, cur_pos, new_pos))
        player_info[player].update_position(new_pos)

        # If new position == board_size the player wins
        if new_pos == board.get_end_position():
            board.update_leaderboard(player)
            cur_player = cur_player - 1

        # Next player turn
        cur_player = (cur_player + 1) % board.get_number_of_players()

        # Adding last left player to leaderboard
        if board.get_number_of_players() == 1:
            board.update_leaderboard(board.get_player(cur_player))