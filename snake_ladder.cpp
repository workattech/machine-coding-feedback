#include <iostream>
#include <unordered_map>
using namespace std;

class snake
{
public:
	unordered_map <int, int > snake_table;
	void fill_table(int key, int data)
	{
		snake_table[key] = data;
	}

};

class ladder
{
public:
	unordered_map<int, int> ladder_table;
	void fill_table(int key, int data)
	{
		ladder_table[key] = data;
	}
};

class player
{
public:
	int cur_pos;
	string name;
        static int won;
	player(string s)
	{
		name = s;
		cur_pos = 0;
	}
	void move(unordered_map <int, int > snake_table, unordered_map<int, int> ladder_table)
	{
	    int dice_value = (rand() % 6) + 1;
	    int next = cur_pos + dice_value;
	    if (next > 100)
              next = cur_pos;
	    unordered_map<int, int>::iterator sl = snake_table.find(next);
	    unordered_map<int, int>::iterator ld = ladder_table.find(next);
	    while (sl != snake_table.end() || ld != ladder_table.end())
	    {
	    	if (sl != snake_table.end())
	    	{
	    		next = sl->second;
	    	}
	    	if (ld != ladder_table.end())
	    	{
	    		next = ld->second;
	    	}
	    	sl = snake_table.find(next);
		ld = ladder_table.find(next);
	    }
            if (next == 100) 
              { 
                  won = 1;
              }
	    cout << name << " rolled a "<< dice_value << " and moved from " << cur_pos << " to " << next << endl;
	    cur_pos = next;
	}
};

int player::won = 0;
int main() {
    snake s1;
    ladder l1;
    int snake_no = 0;
    srand(time(0));

    cin >> snake_no;
    for (int i = 0;i<snake_no;i++)
    {
    	int key = 0, data = 0;
    	cin >> key >> data;
    	s1.fill_table(key, data);
    }

    int ladder_no = 0;
    cin >> ladder_no;
    for (int i = 0; i<ladder_no;i++)
    {
    	int key = 0, data = 0;
    	cin >> key >> data;
    	l1.fill_table(key, data);
    }

    int player_no = 0;
    cin >> player_no;
    player *p_list[player_no];
    for (int i = 0; i<player_no; i++)
    {
    	string player_name;
    	cin >> player_name;
    	p_list[i] = new player(player_name);
    }
    int i = 0;
 
    while(1)
    {
    	p_list[i]->move(s1.snake_table, l1.ladder_table);
    	if (player::won == 1)
    	{
    		cout << p_list[i]->name << " wins the game" << endl;
    		break;
    	}
    	i = (i+1) % player_no;
    }
   return 0;
}
