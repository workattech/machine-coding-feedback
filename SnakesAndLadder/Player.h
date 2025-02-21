#pragma once
#include<iostream>

using namespace std;

class Player
{
private:
	int id;
	string name;
	int position;
public:
	Player(string name, int id);
	int getPosition();
	void updatePosition(int position);
	string getName();
};

