import random
def findRoot(root, x):
    while root[x] != x:
        root[x] = root[root[x]]
        x = root[x]
    return x


def union(root, x, y):
    rootx = findRoot(root, x)
    rooty = findRoot(root, y)
    root[rooty] = root[rootx]


def playGame(finalPos, root, players, playersPos, numberOfPlayers):
    finish = False
    curPlayer = 0
    while not finish:
        diceValue = random.randint(1, 6)
        curPos = playersPos[players[curPlayer]]
        if diceValue + curPos > 100:
            print('{0} rolled a {1} and moved from {2} to {3}'.format(players[curPlayer], diceValue, curPos, curPos))
            curPlayer = (curPlayer + 1) % numberOfPlayers
            continue
        newPos = finalPos[findRoot(root, diceValue + curPos)]
        print('{0} rolled a {1} and moved from {2} to {3}'.format(players[curPlayer], diceValue, curPos, newPos))
        playersPos[players[curPlayer]] = newPos
        if newPos == 100:
            print(players[curPlayer] + ' wins the game')
            finish = True
            break
        curPlayer = (curPlayer + 1) % numberOfPlayers
