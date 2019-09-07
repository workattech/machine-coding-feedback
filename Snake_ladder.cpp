#include<bits/stdc++.h>
#include<time.h>
using namespace std;
int main()
{
    srand(time(0));
    int snk, lad, per; // Number of snakes, ladders and persons
    int ip, fp; // Initial and final position
    cin >> snk; // taking input of number of snakes
    unordered_map<int, int> snakes; //int to int map to find snake address
    for(int i=0;i<snk;i++)
    {
        cin >> ip >> fp;
        snakes[ip] = fp;
    }
    cin >> lad; // taking input of number of ladders
    unordered_map<int, int> ladders; //int to int map to find ladder address
    for(int i=0;i<lad;i++)
    {
        int ip, fp;
        cin >> ip >> fp;
        ladders[ip] = fp;
    }
    cin >> per;
    vector<pair<string, int>> person; //string to int vector to keep count of present address of persons
    for(int i=0;i<per;i++)
    {
        string name;
        cin >> name;
        person.push_back(make_pair(name,0));
    }
    int c = 0;
    while(1)
    {
        int x = (rand()%6)+1; // Random dice value generator (1-6)
        int initial;
        int final = person[c].second + x;
        /*Checking whether at next position a snake exist or not*/
        if(final<=100 && snakes.find(final)!=snakes.end())
        {
            initial = person[c].second;
            person[c].second = snakes[final];
            cout << person[c].first << " rolled a " << x << " and moved from " << initial << " to " << person[c].second << endl;
        }
        /*Checking whether at next position a ladder exist or not*/
        else if(final<=100 && ladders.find(final)!=ladders.end())
        {
            initial = person[c].second;
            person[c].second = ladders[final];
            cout << person[c].first << " rolled a " << x << " and moved from " << initial << " to " << person[c].second << endl;
            if(person[c].second==100)
            {
                cout << person[c].first << " wins the game" << endl;
                break;
            }
        }
        /* if neither snake nor ladder exist then moving x moves forward*/
        else
        {
            if(final<=100)
            {
                initial = person[c].second;
                person[c].second+=x;
            }
            else
            {
                initial = person[c].second;
                
            }
            cout << person[c].first << " rolled a " << x << " and moved from " << initial << " to " << person[c].second << endl;
            if(person[c].second==100)
            {
                cout << person[c].first << " wins the game" << endl;
                break;
            }
        }
        /* Printing the initial and final position for each player*/
        c = (c+1)%per;
    }
    return 0;
}
