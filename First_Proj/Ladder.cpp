/*
 * Ladder.cpp
 *
 *  Created on: 14-Jan-2021
 *      Author: sam
 */

#include "Ladder.h"

Ladder::Ladder(int s, int e) {
	// TODO Auto-generated constructor stub
	startpt = s;
	endpt = e;
}

int Ladder::getstart(){
	return startpt;
}

int Ladder::getend(){
	return endpt;
}

