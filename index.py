import sys
from lib import *

if __name__=="__main__":
    finalPos = {}
    root = {}
    players = []
    playersPos = {}
    inputfile = sys.argv[1]
    f = open(inputfile, 'r')
    f1 = f.read().splitlines()
    s = int(f1[0])
    for i in range(1,101):
        finalPos[i]=i
        root[i]=i
    for i in range(1,s+1):
        x,y = map(int,f1[i].split())
        if root[x]!=root[y]:
            union(root,x,y)
        finalPos[findRoot(root,x)]=y
    l = int(f1[s+1])
    for i in range(s+2,s+l+2):
        x,y = map(int,f1[i].split())
        if root[x]!=root[y]:
            union(root,x,y)
        finalPos[findRoot(root,x)]=y
    p = int(f1[s+l+2])
    for i in range(p):
        playersPos[i]=0
    for i in range(s+l+3,s+l+p+3):
        players.append(f1[i])
        playersPos[f1[i]] = 0
    playGame(finalPos, root, players, playersPos, p)