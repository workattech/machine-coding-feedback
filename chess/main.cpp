#include<bits/stdc++.h>
#include "./Class/Game.cpp"
using namespace std;
#define ll long long

int main(){
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    Game * game = new Game();
    game->startGame();

    return 0;
}