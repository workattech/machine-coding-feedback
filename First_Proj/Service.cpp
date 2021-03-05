/*
 * Service.cpp
 *
 *  Created on: 14-Jan-2021
 *      Author: sam
 */

#include "Service.h"

Service::Service() {

	snlb.setsize(default_size);
	srand(time(0));
}

int Service::DiceRoll(){

	return (1 + (rand()%6) );
}
void Service::setPlayer(queue<Player> p){

	unordered_map<string, int> playerp;
	while(!p.empty())
	{
		Player k = p.front();
		player.push(k);
		playerp.emplace(make_pair(k.getname(), 0));
		p.pop();
	}

	snlb.setplayerpeices(playerp);
}
void Service::setSnake(vector<Snake> sna){

	snlb.setsnakes(sna);
}
void Service::setLadder(vector<Ladder> ladd){

	snlb.setladders(ladd);
}

int Service::move(int newpos){
	int oldpos;
	do
	{
		oldpos = newpos;
		for(Snake s: snlb.getsnakes())
		{
			if(newpos==s.getstart())
				newpos=s.getend();
		}

		for(Ladder l: snlb.getladders())
		{
			if(newpos==l.getstart())
				newpos=l.getend();
		}
	}while(oldpos!=newpos);

	return newpos;
}

int Service::playermove(Player p, int dicerollvalue, int oldpos){

	int newpos = oldpos + dicerollvalue;
	if(newpos>default_size)
		newpos = oldpos;
	else
		newpos = move(newpos);

	cout<<"Player "<<p.getname()<<" rolled dice with value "<<dicerollvalue<<" and moved from position "<<oldpos<<" to position "<<newpos<<endl;
	return newpos;
}
bool Service::didplayerwin(int pos){

	return pos==default_size;
}
bool Service::isgameover(){

	size_t size = snlb.getplayerpeices().size();
	return size>player.size();

}
void Service::rungame()
{
	while(!isgameover())
	{
		Player t = player.front();
		player.pop();
		int dicerollval = DiceRoll();

		unordered_map<string, int> h = snlb.getplayerpeices();

		int oldpos = h[t.getname()];
		int newpos = playermove(t, dicerollval, oldpos);

		h[t.getname()] = newpos;
		snlb.setplayerpeices(h);

		if(didplayerwin(newpos))
		{
			cout<<" Player "<<t.getname()<<" has won the game "<<endl;
		}
		else
			player.push(t);

	}
}
