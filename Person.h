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

class Person {
	int id;
	string name;
	int position;

public:

	Person(int identityNumber, string playerName)
	{
		id = identityNumber;
		name = playerName;
		position = 0;
	}

	int getPosition()
	{
		return position;
	}

	void setPosition(int newPosition)
	{
		position = newPosition;
	}

	string getName()
	{
		return name;
	}
};