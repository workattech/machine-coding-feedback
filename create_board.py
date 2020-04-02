from random import randrange, choice
from string import ascii_lowercase


"""
creates board file
"""

def create_board(file_path, board_size=100, number_of_snakes=10, number_of_ladders=10, number_of_players=3):
    board = [0]*board_size

    info_data = [str(number_of_snakes)]

    _curr_snakes=0
    while _curr_snakes < number_of_snakes:
        source = randrange(1, board_size)
        if source-1 <= 1:
            continue
        destination = randrange(1, source-1)

        if destination == board_size:
            continue

        if board[source] == 0 and board[destination] == 0:
            board[source] = 1
            board[destination] = 1
            info_data.append(str(source)+ " " + str(destination))
            _curr_snakes += 1

    _curr_ladders=0
    info_data.append(str(number_of_ladders))
    while _curr_ladders < number_of_ladders:
        source = randrange(1, board_size)
        if source+1 >= board_size:
            continue
        destination = randrange(source+1, board_size)

        if board[source] == 0 and board[destination] == 0:
            board[source] = 1
            board[destination] = 1
            info_data.append(str(source)+ " " + str(destination))
            _curr_ladders += 1

    info_data.append(str(number_of_players))
    for i in range(number_of_players):
        name=''.join(choice(ascii_lowercase) for _ in range(6))
        info_data.append(name)
    info_data = ("\n".join(info_data)) 

    file = open(file_path, 'w')
    file.write(info_data)
    file.close()

