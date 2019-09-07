/*
 SNAKE AND LADDER GAME
 ---------------------
 
 - Works well with more than 2 players, the game continues until only one player is left
 - Multiple 6's not handled till now
 - unit tests not written
 - snakes and ladders not created programitiacally
 
 ** Data Structures used
 - snakes : a map to hold the haed and tail of each snake
 - ladders : a map to hold the top and bootom of each ladder
 - playes : a vector of pairs where each pair contains the name of the player and it's position the board.
 - s : no. of snakes
 - l : no. of ladders
 - p : no. of players

 ** Functions descriptions
 - getSnakes(): initializes the snakes
 - getLadders(): initializes the ladders
 - getPlayers(): gets the details of playes, initializes their initial position to zero
 - game(): the main game function
 
 
 */



# include <iostream>
# include <vector>
# include <map>
# include <cstring>
# include <ctime>

using namespace std;

void getSnakes(map <int, int> &);
void getLadders(map <int, int> &, map <int, int>);
void getPlayers(vector <pair <string, int> > &);
void game(int , int , int , map <int, int> , map <int, int> , vector <pair <string, int> > );



int main(){
    srand(time(NULL));
    
    // input the snakes co-ordinates
    map <int, int> snakes;
    getSnakes(snakes);
    
    // input the ladders co-ordinates
    map <int, int> ladders;
    getLadders(ladders, snakes);
    
    // input the names of the players and initialize their initial position as 0;
    vector <pair <string, int> > players;
    getPlayers(players);
    
    
    // code for the game
    game(snakes.size(), ladders.size(), players.size(), snakes, ladders, players);
    
    return 0;
}


void getSnakes(map <int, int> &snakes){
    int s;
    cin>>s;
    for (int i = 0; i < s; i++){
        int head, tail;
        cin>>head>>tail;
        
        if (head <= tail){
            cout<<"Head has to be greater than tail. WRONG INPUT!! TERMINATING!!"<<endl;
            exit(0);
        }
        
        if (snakes.find(head) != snakes.end()){
            cout<<"Already a snake at that position. WRONG INPUT!! TERMINATING!!"<<endl;
            exit(0);
        }else{
            snakes[head] = tail;
        }
    }
}


void getLadders(map <int, int> &ladders, map <int, int> snakes){
    int l;
    cin>>l;
    for (int i = 0; i < l; i++){
        int start, end;
        cin>>start>>end;
        
        if (end <= start){
            cout<<"End has to be greater than start. WRONG INPUT!! TERMINATING!!"<<endl;
            exit(0);
        }
        
        if (snakes.find(start) != snakes.end()){
            cout<<"There's a snake at this position. WRONG INPUT!! TERMINATING!!"<<endl;
            exit(0);
        }
        
        if (ladders.find(start) != ladders.end()){
            cout<<"There's already a ladder at this position. WRONG INPUT!! TERMINATING!!"<<endl;
            exit(0);
        }else{
            ladders[start] = end;
        }
    }
}

void getPlayers(vector <pair <string, int> > &players){
    int p;
    cin>>p;
    for (int i = 0; i < p; i++){
        string name;
        cin>>name;
        
        players.push_back(make_pair(name, 0));
    }
}

void game(int s, int l, int p, map <int, int> snakes, map <int, int> ladders, vector <pair <string, int> > players){
    
    int players_left = p;  //no. of players left in the game
    int ind = 0; // index of the player whose chance it is
    
    while(players_left > 1){
        // get the name and initial position of the player
        string name = players[ind].first;
        int init_position = players[ind].second;
        
        // get a no. between [1,6]
        int dice_roll = rand()%6;
        dice_roll += 1;
        
        int new_position = init_position + dice_roll;
        
        while(snakes.find(new_position) != snakes.end() || ladders.find(new_position) != ladders.end()){
            
            if (snakes.find(new_position) != snakes.end()){
                new_position = snakes[new_position];
            }else if (ladders.find(new_position) != ladders.end()){
                new_position = ladders[new_position];
            }
            
        }
        
        if (new_position > 100){
            new_position = init_position;
        }
        
        players[ind].second = new_position;
        cout<<name<<" rolled a "<<dice_roll<<" and moved from "<<init_position<<" to " <<new_position<<endl;
        
        if (new_position == 100){
            players_left--;  // decrease the no. of players left
            
            
            // remove this player from the list of players
            vector <pair <string, int> > :: iterator it = players.begin()+ind;
            players.erase(it);
            
            
            // print
            cout<<endl;
            cout<<"---------\n";
            cout<<name<<" wins the game\n";
            cout<<"---------\n";
        }
        
        ind++;
        ind = ind%players_left;
    }
}
