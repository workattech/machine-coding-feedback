import random
def main():
    snakes=int(input())
    head=[]
    tail=[]
    for i in range(snakes):
        s_head,s_tail=map(int,input().split())
        head.append(s_head)
        tail.append(s_tail)
    ladders=int(input())
    start=[]
    end=[]
    for i in range(ladders):
        l_start,l_end=map(int,input().split())
        start.append(l_start)
        end.append(l_end)
    names=[]
    players=dict()
    p=int(input())
    for k in range(p):
        name=input()
        names.append(name)
        players[name]=0
    x=0
    while True:
        dice=random.randrange(1,7)
        curr_pos=players[names[x]]+dice
        if curr_pos in head:
            curr_index=head.index(curr_pos)
            curr_pos=tail[curr_index]
        elif curr_pos>100:
            continue
        elif curr_pos in start:
            curr_index=start.index(curr_pos)
            curr_pos=end[curr_index]
        elif curr_pos==100:
            print(names[x],"rolled a",dice,"and moved from",players[names[x]],"to",curr_pos)
            print(names[x],"wins the game")
            break
        print(names[x],"rolled a",dice,"and moved from",players[names[x]],"to",curr_pos)
        players[names[x]]=curr_pos
        x+=1
        if x==p:
            x=0
            
if __name__== "__main__":
  main()