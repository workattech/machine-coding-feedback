#include"bits/stdc++.h"
using namespace std;
#define fast ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define pb push_back
#define mp make_pair
#define int long long
const int mm = 1e5 + 5;
/* space = 1 , tab = 2 for better understanding sublime text editor*/
unordered_map<int, int>snakeH;
unordered_map<int, int>snakeT;
unordered_map<int, int>ladderH;
unordered_map<int, int>ladderT;

class games_in{
	public :
	void take_input_for_snakes(){
		int number_of_snake; cin >> number_of_snake;

		///intaking all snake's head and tail

		for(int i=0; i<number_of_snake; i++){
			int head ,tail; cin >> head >> tail;
			snakeH[ head ] = tail;
			snakeT[ tail ] = head;
		}
	}

	void take_input_for_ladders(){
		int num_of_lad; cin >> num_of_lad;

		// intaking all ladders

		for(int i=0; i<num_of_lad; i++){
			int head, tail; cin >> head >> tail;
			ladderH[ head ] =  tail;
			ladderT[ tail ] = head;
		}

	}
	void intake_player(){
		int n; cin >> n;
		vector<pair<string, int> > players;
		for(int i=0; i<n; i++) {
			string s; cin >> s;
			players.pb( mp( s, 0 ) );
		}
	}
}
class games_out : public games_in{
	public :
	void play(){
		int player_number = 0;

		while(1){
			
			player_number %= n;
			
			string s = players[ player_number ].first;
			
			int cur_start = players[ player_number ].second;
			
			int move = rand() % 7 + 1;

			
			if(move + cur_start <= 100)
				int end = cur_start + move;
			
			cout<< s << " rolled a " << move <<" from "
				<<cur_start<<" to "<<endl;
			
			if(snakeH.find( end ) != snakeH.end()  ){
				end = snakeH[ end ];
			}
			else if(ladderT.find( end ) != ladderT.end()  ){
				end = ladderT[ end ];
			}
			++player_number;

			if(end == 100){
				cout<< s << " wins the game" << endl;
				break;
			}
		}
	}
}
int32_t main()
{
	//fast
	games_out ob;
	ob.take_input_for_snakes();
	ob.take_input_for_ladders();
	ob.intake_player();
	ob.play();
	return 0;
}
