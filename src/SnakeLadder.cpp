#include <bits/stdc++.h>
using namespace std;

int main(){
	#ifndef ONLINE_JUDGE
    // for getting input from input.txt
    freopen("../IO/input.txt", "r", stdin);
    // for writing output to output.txt
    freopen("../IO/output.txt", "w", stdout);
#endif
    int numSnakes;
    cin>>numSnakes;
    unordered_map<int,int> Snakes;
    for(int i=0;i<numSnakes;i++){
    	int upper,lower;
    	cin>>upper>>lower;
    	Snakes[upper]=lower;
    }

    int numLaders;
    cin>>numLaders;
    unordered_map<int,int> Laders;
    for(int i=0;i<numLaders;i++){
    	int lower,upper;
    	cin>>lower>>upper;
    	Laders[lower]=upper;
    }

    int numPlayers;
    cin>>numPlayers;
    vector<pair<string,int>> Players;
    for(int i=0;i<numPlayers;i++){
    	string playername;
    	cin>>playername;
    	Players.push_back(make_pair(playername,0));
    }

    bool win=false;
    srand((unsigned)time(0));
    while(!win){
    	for(int i=0;i<numPlayers;i=(i+1)%numPlayers){
    		int die = rand()%6 + 1;
    		int currentPlayerCurrentPos = Players[i].second;
    		int currentPlayerNewPos = currentPlayerCurrentPos + die;
    		if(currentPlayerNewPos > 100){
    			continue;
    		}
    		else{
    			cout<<Players[i].first<<" rolled a "<<die<<" and moved from "<<currentPlayerCurrentPos<<" to ";
    			if(Snakes.count(currentPlayerNewPos)){
    				currentPlayerNewPos = Snakes[currentPlayerNewPos];
    				while(Snakes.count(currentPlayerNewPos)){
    					currentPlayerNewPos = Snakes[currentPlayerNewPos];
    				}
    				while(currentPlayerNewPos <= 100 && Laders.count(currentPlayerNewPos)){
    					currentPlayerNewPos = Laders[currentPlayerNewPos];
    				}
	    		}

	    		if(Laders.count(currentPlayerNewPos)){
	    			currentPlayerNewPos = Laders[currentPlayerNewPos];
	    			while(Snakes.count(currentPlayerNewPos)){
    					currentPlayerNewPos = Snakes[currentPlayerNewPos];
    				}
    				while(currentPlayerNewPos <= 100 && Laders.count(currentPlayerNewPos)){
    					currentPlayerNewPos = Laders[currentPlayerNewPos];
    				}
	    		}

	    		Players[i].second = currentPlayerNewPos;
	    		cout<<currentPlayerNewPos<<endl;

	    		if(currentPlayerNewPos == 100){
	    			win=true;
	    			cout<<Players[i].first<<" wins the game"<<endl;
	    			break;
	    		}
    		}
    	}
    }
}
