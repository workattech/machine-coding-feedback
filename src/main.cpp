#include "stdc++.h"
using namespace std;

vector<pair<int, int> > board(101);

int main()
{

    int s;
    cin >> s;
    while (s--)
    {
        int x, y;
        cin >> x >> y;
        board[x].first = y;
    }
    int l;
    cin >> l;
    while (l--)
    {
        int x, y;
        cin >> x >> y;
        board[x].second = y;
    }
    int n;
    cin >> n;
    vector<pair<string, int> > players(n);
    for (int i = 0; i < n; i++)
    {
        cin >> players[i].first;
    }

    while (true)
    {
        int dice, i;
        for (i = 0; i < n; i++)
        {
            
            dice = rand() % 6 + 1;
            int prev = players[i].second, next;
            if (prev + dice == 100)
            {
                cout << players[i].first << " rolled a " << dice << " and moved from " << prev+dice << " to " << next << endl;
                cout << players[i].first << " wins the game" << endl;
                break;
            }
            else if (prev + dice > 100)
            {
                next = prev;
            }
            else
            {
                int x = prev + dice;
                while (board[x].first > 0 || board[x].second > 0)
                {
                    if (board[x].first > 0)
                        x = board[x].first;
                    if (board[x].second > 0)
                        x = board[x].second;
                }
                next = x;
                if (next == 100)
                {
                    cout << players[i].first << " rolled a " << dice << " and moved from " << prev << " to " << next << endl;
                    cout << players[i].first << " wins the game" << endl;
                    break;
                }
            }
            players[i].second = next;
            cout << players[i].first << " rolled a " << dice << " and moved from " << prev << " to " << next << endl;
        }
        if (i < n)
            break;
    }
}
