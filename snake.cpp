#include"bits/stdc++.h"
using namespace std;
#define fast ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define pb push_back
#define mp make_pair
#define int long long
const int mm = 1e5 + 5;
/* space = 1 , tab = 2 for better understanding sublime test editor*/
unordered_map<int, int>snakeH;
unordered_map<int, int>snakeT;
unordered_map<int, int>ladderH;
unordered_map<int, int>ladderT;

class games{
	public :
	void take_input_for_snakes(){
		int number_of_snake; cin >> number_of_snake;

		///intaking all the snake head and tail

		for(int i=0; i<number_of_snake; i++){
			int head ,tail; cin >> head >> tail;
			snakeH[ head ] = tail;
			snakeT[ tail ] = head;
		}
	}

	void take_input_for_ladders(){
		int num_of_lad; cin >> num_of_lad;

		// intaking all the ladders

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
	void play(){
		int khiladi_number = 0;
		while(1){
			
			khiladi_number %= n;
			
			string s = players[ khiladi_number ].first;
			
			int cur_start = players[ khiladi_number ].second;
			
			int move = rand() % 7;
			
			if(move + cur_start <= 100)
				int end = cur_start + move;
			
			cout<< s << " rolled a " << move <<" from "
				<<cur_start<<" to "<<end;
			
			if(snakeH.find( end ) != snakeH.end()  ){
				end = snakeH[ end ];
			}
			else if(snakeT.find( end ) != snakeT.end()  ){
				end = snakeT[ end ];
			}
			else if(ladderH.find( end ) != ladderH.end()  ){
				end = ladderH[ end ];
			}
			else if(ladderT.find( end ) != ladderT.end()  ){
				end = ladderT[ end ];
			}
			++khiladi_number;

			if(end == 100){
				cout<< s << " wins the game";
				break;
			}
		}
	}
}
int32_t main()
{
	//fast
	games ob;
	ob.take_input_for_snakes();
	ob.take_input_for_ladders();
	ob.intake_player();
	ob.play();
	return 0;
}
