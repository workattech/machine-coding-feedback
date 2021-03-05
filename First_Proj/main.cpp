#include "Snake.h"
#include "Ladder.h"
#include "Player.h"
#include "SnakeandLadderboard.h"
#include "Service.h"
#include<iostream>
#include<string>
#include<bits/stdc++.h>
using namespace std;

int main()
{
	//Snake s(10, 20);
	//Ladder l(3,54);
	//Player p("soham", "21");
	//SnakeandLadderboard snl(100);

	//cout<<s.getstart()<<"\t"<<s.getend()<<endl;
	//cout<<l.getstart()<<"\t"<<l.getend()<<endl;
	//cout<<p.getname()<<"\t"<<p.getid()<<endl;

	int snakesize=0, laddersize=0, playersize=0;
	cout<<"Enter Snake size: ";
	cin>>snakesize;

	vector<Snake> snake;
	cout<<"Enter the "<<snakesize<<" startpt and endpt for snakes: ";
	for(int i=0; i<snakesize; i++)
	{
		int st, en;
		cin>>st>>en;
		Snake s(st, en);
		snake.push_back(s);
	}

	cout<<"Enter ladder size: ";
	cin>>laddersize;

	vector<Ladder> ladder;
	cout<<"Enter the "<<laddersize<<" startpt and endpt for ladder: ";
	for(int i=0; i<laddersize; i++)
	{
		int st, en;
		cin>>st>>en;
		Ladder l(st, en);
		ladder.push_back(l);
	}

	cout<<"Enter playersize: ";
	cin>>playersize;

	queue<Player> player;
	cout<<"Enter the name and unique id of "<<playersize<<" players: ";

	string nam, id;
	getline(cin, nam);

	for(int i=1; i<=playersize; i++)
	{
		cout<<"Enter name: ";
		getline(cin, nam);

		cout<<"Enter id: ";
		getline(cin, id);

		Player p(nam, id);
		//cout<<p.getname()<<"\t"<<p.getid()<<endl;
		player.push(p);
	}

	Service snlgame;
	snlgame.setSnake(snake);
	snlgame.setLadder(ladder);
	snlgame.setPlayer(player);

	snlgame.rungame();

	return 0;
}
