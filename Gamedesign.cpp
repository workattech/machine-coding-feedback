#include <iostream>
#include <iosfwd>
#include <iomanip>
#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <ctime>
#include <cmath>
#include <cassert>
#include <cctype>
#include <climits>
#include <vector>
#include <bitset>
#include <set>
#include <queue>
#include <stack>
#include <map>
#include <deque>
#include <string>
#include <list>
#include <iterator>
#include <sstream>
#include <complex>
#include <fstream>
#include <functional>
#include <numeric>
#include <utility>
#include <algorithm>
#include <assert.h>
#include <unordered_map>
using namespace std;

class Player
{
	string name;
	int position;
	public:
	void setName(string Name)
	{
		this->name = Name;
	}
	string getName()
	{
		return name;
	}
	int getPosition()
	{
		return this->position;
	}
	void setPosition()
	{
		this->position = 0;
	}
	void updatePosition(int x)
	{
		this->position = x; 
	}
	
};

class Dice
{
	int display;
	public:
	int rollDice()
	{
		display = rand() % 6 + 1;
		return display;
	} 
};





class Game{
	
	int snakes[100];
	int ladders[100];
	int playersCount;
	vector < Player* > players; 
	Dice d;
	public:
	void initialiseBoard()
	{
		for(int i=0;i<100;i++)
		{
			snakes[i]=ladders[i]=0;
		}
	}
	void putSnake(int head, int tail)
	{
		snakes[head] = tail;
	}

	void putLadder(int head, int tail)
	{
		ladders[head] = tail;
	}

	void getplayersCount(int n)
	{
		playersCount = n;
	}
	
	void addPlayer(Player *p)
	{
		players.push_back(p);
	}

	void startPlay();
} ;


void Game::startPlay()
{



	int curr_pos,prev_pos,move;
	string name;
	while(1)
	{
	  for(int i=0;i<playersCount;i++)
	  {
	  		curr_pos = players[i]->getPosition();
	  		prev_pos = curr_pos;
	  		name = players[i]->getName();
	  		move = d.rollDice();
	  		if (curr_pos + move <= 100)
	  		{	
	  			curr_pos+= move;
	  			if(curr_pos != 100)
	  			{
	  			if(snakes[curr_pos]!= 0)
	  			{
	  				curr_pos = snakes[curr_pos];
	  			}
	  			else if(ladders[curr_pos]!= 0)
	  			{
	  				curr_pos = ladders[curr_pos];
	  			}
	  			}
	  			
	  		}
	  		cout<<name<<" rolled a "<<move<<" and moved from "<<prev_pos<<" to "<<curr_pos<<endl;	

	  		if(curr_pos == 100)
	  		{
	  			cout<<name<<" wins the game"<<endl;
	  			return;
	  		}
	  		players[i]->updatePosition(curr_pos);

	  }
	}
} 

int main()
{
	Game Board1;
	int i,snakes,ladders,players,head,tail;
	string name;
	Board1.initialiseBoard();
	cin>>snakes;
	for(i=0;i<snakes;i++)
	{
		cin>>head>>tail;
		Board1.putSnake(head,tail);
	}
	cin>>ladders;
	for(i=0;i<ladders;i++)
	{
		cin>>head>>tail;
		Board1.putLadder(head,tail);
	}
	


	cin>>players;
	Board1.getplayersCount(players);
	Player P[players];
	for(i=0;i<players;i++)
	{
		cin>>name;
		P[i].setName(name);
		P[i].setPosition();
		Board1.addPlayer(&P[i]);
	}
	Board1.startPlay();
	return 0;

}