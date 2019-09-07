import random


def playGame(player_info, board):
    cur_player = 0
    while board.get_winner() == 'none':
        dice_value = random.randint(1, 6)
        player = board.get_player(cur_player)
        cur_pos = player_info[player].position()
        if dice_value + cur_pos > 100:
            print('{0} rolled a {1} and moved from {2} to {3}'.format(player, dice_value, cur_pos, cur_pos))
            cur_player = (cur_player + 1) % board.get_number_of_players()
            continue
        new_pos = board.get_final_pos(board.find_root(dice_value + cur_pos))
        print('{0} rolled a {1} and moved from {2} to {3}'.format(player, dice_value, cur_pos, new_pos))
        player_info[player].update_position(new_pos)
        if new_pos == 100:
            print(player + ' wins the game')
            board.update_winner(player)
        cur_player = (cur_player + 1) % board.get_number_of_players()
