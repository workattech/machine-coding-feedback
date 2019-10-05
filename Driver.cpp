// #include "./Headers/snakes.h"
// #include "./Headers/players.h"
// #include "./Headers/ladders.h"

#include<bits/stdc++.h>
#include<iostream>
using namespace std;

class Player
{
public:
	string name;
	int pos;
	bool completed;
	int number_of_dices;
	Player(string name)
	{
		this->name=name;
		completed=false;
		pos=0;
		number_of_dices=2;
	}
	int RollDice()
	{
		if(number_of_dices==1)
			return ((rand()%6)+1);
		else 
			return (((rand()%6)+1)+(rand()%6)+1);
	}
	 
};

class Board
{
public:
	vector<int> boardMap;
	int size;
	Board()
	{
		size=200;
		vector<int> temp(size+1,0);
		boardMap=temp;
	}
	void setBoard()
	{
		int no_of_snakes;
		cin>>no_of_snakes;
		int start;
		for(int i=0;i<no_of_snakes;i++)
		{
			cin>>start;
			cin>>boardMap[start];
		}

		int no_of_ladders;
		cin>>no_of_ladders;
		for(int i=0;i<no_of_ladders;i++)
		{
			cin>>start;
			cin>>boardMap[start];
		}
	}
};


class Game
{
public:
	vector<Player>players;
	Board board;

	Game()
	{
		Board b1;
		board=b1;
		initializeGame();
	}

	void initializeGame()
	{
		board.setBoard();
		int no_of_players;
		cin>>no_of_players;
		Player p1("Intitalizing");
		vector<Player> temp(no_of_players,p1);
		players=temp;
		string name;
		for(int i=0;i<no_of_players;i++)
		{
			cin>>name;
			Player p(name);
			players[i]=p;
		}
	}

	void startGame()
	{
		int turn=0;
		int cur_no_players=players.size();
		while(1)
		{
			for(int turn=0;turn<players.size();turn++)
			{
				if(players[turn].completed==true)
					continue;
				if(cur_no_players==1)
					break;
				int player_pos=players[turn].pos;
				int dice_no=players[turn].RollDice();
				int new_player_pos=player_pos+dice_no;
				if (new_player_pos>board.size)
				{
					new_player_pos=player_pos;
				}

				else if(new_player_pos==board.size)
				{
					players[turn].completed=true;
					cur_no_players--;
					cout<<players[turn].name<<" wins the game"<<endl;
					continue;
				}

				else if(board.boardMap[new_player_pos]!=0)
					new_player_pos=board.boardMap[new_player_pos];
				
				
				players[turn].pos=new_player_pos;
				cout<<players[turn].name<<" rolled a "<<dice_no<<" and moved from "<<player_pos<<" to "<<new_player_pos<<endl;
			}
			if(cur_no_players==1)
				break;
		}
	}
};


int main()
{
		
	Game g1;
	//cout<<g1.players[0].name<<endl;
	//cout<<g1.players[1].name<<endl;
	g1.startGame();
	return 0;
}