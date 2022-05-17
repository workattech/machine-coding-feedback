#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;
//function to update position in case a snake or ladder is at current position
int update(int pos,int dice,unordered_map<int,int> snakes,unordered_map<int,int> ladders)
{
    if(pos+dice>100)
        return pos;
    pos = pos + dice;
    if(snakes.count(pos)>0)
        return snakes[pos];
    else if(ladders.count(pos)>0)
        return ladders[pos];
    return pos;
}
int main()
{
    int s,l,p;
    //No of snakes
    cin>>s;
    // head of snakes mapped to its tail
    unordered_map<int,int> snakes;
    int head,tail;
    //getting input for s snakes
    for(int i=0;i<s;i++)
    {
        cin>>head>>tail;
        snakes[head] = tail;
    }
    //no of ladders
    cin>>l;
    unordered_map<int,int> ladders;
    int start,end;
    // getting input for l ladders
    for(int i=0;i<l;i++)
    {
        cin>>start>>end;
        ladders[start] = end;
    }
    cin>>p;
    vector<string> players(p);
    for(int i=0;i<p;i++)
    {
        cin>>players[i];
    }
    vector<int> positions(p);
    int dice=0,new_position=0;
    bool win=false;
    while(!win)
    {
        for(int i=0;i<p;i++)
        {
            dice = rand()%6 + 1;
            new_position = update(positions[i],dice,snakes,ladders);
            cout<<players[i]<<" rolled a "<<dice<<" and moved from "<<positions[i]<<" to "<<new_position<<endl;
            positions[i] = new_position;
            if(positions[i]==100)
            {  win = true;
                cout<<players[i]<<" wins the match "<<endl;
                break;

            }
        }
    }
    return 0;
}
