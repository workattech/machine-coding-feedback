/*
 * Snake.cpp
 *
 *  Created on: 14-Jan-2021
 *      Author: sam
 */

#include "Snake.h"

Snake::Snake(int s, int e) {
	// TODO Auto-generated constructor stub
	startpt = s;
	endpt = e;
}

int Snake::getstart()
{
	return startpt;
}

int Snake::getend()
{
	return endpt;
}

