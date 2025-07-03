from .game import Game

def read_input():
    s = int(input())
    snakes = {}
    for _ in range(s):
        head, tail = map(int, input().split())
        snakes[head] = tail

    l = int(input())
    ladders = {}
    for _ in range(l):
        start, end = map(int, input().split())
        ladders[start] = end

    p = int(input())
    players = []
    for _ in range(p):
        players.append(input().strip())

    return snakes, ladders, players

if __name__ == "__main__":
    snakes, ladders, players = read_input()
    game = Game(snakes, ladders, players)
    game.play()
