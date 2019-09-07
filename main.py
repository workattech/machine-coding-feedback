from utils.board import Board
from utils.player import Player
from utils.movable import Movable

# Parse the input file
def parse_input_file():
    file = open('input.txt', 'r')
    __input = file.read()
    file.close()

    player_list = []
    snake_list = []
    ladder_list = []

    __input = __input.split('\n')
    __snake_cnt = int(__input[0])
    __line_no = 1
    while(__snake_cnt!=0):
        _source, _destination = __input[__line_no].split()
        snake_list.append(Movable(int(_source), int(_destination)))

        __line_no += 1 
        __snake_cnt -= 1

    __ladder_cnt = int(__input[__line_no])
    __line_no += 1
    while(__ladder_cnt!=0):
        _source, _destination = __input[__line_no].split()
        ladder_list.append(Movable(int(_source), int(_destination)))

        __line_no += 1
        __ladder_cnt -= 1

    __player_cnt = int(__input[__line_no])
    __line_no += 1
    while(__player_cnt!=0):
        _name = __input[__line_no]
        player_list.append(Player(_name))

        __line_no += 1
        __player_cnt -= 1

    return player_list, snake_list, ladder_list

def main(board_size, number_of_dice):
    player_list, snake_list, ladder_list = parse_input_file()
    
    board_object = Board(board_size, player_list, snake_list, ladder_list, number_of_dice)

    # stop when one player wins
    while board_object.get_number_of_winner() == 0:
        _dice_val, _source, _player = board_object.make_move()
         
        print(str(_player.get_name()) + " rolled a " + str(_dice_val) + " and moved from " + str(_source) + " to " + str(_player.get_current_pos()))

    _rank_list = board_object.get_rank_list()
    
    for key, val in _rank_list.items():
        print(key.get_name() + " wins the game")

if __name__ == "__main__":
    number_of_dice = 1
    board_size = 100
    main(board_size, number_of_dice)
