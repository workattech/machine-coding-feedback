#include <iostream>
#include <unordered_map>
using namespace std;

class Snake
{
        unordered_map <int, int > snake_table;

        /* Snake class will be a singleton class, i.e. only one instance */
        static Snake* unique_instance;
        Snake(){};
        Snake(const Snake&);
        Snake& operator=(const Snake&);

public:
        static Snake* get_instance()
        {
           if (unique_instance == NULL)
            {
                unique_instance = new Snake;
            }
            return unique_instance;
        }
        void fill_table(int key, int data)
        {
           snake_table[key] = data;
        }
        unordered_map <int, int> get_snake_table()
        {
           return snake_table;
        }
};

Snake* Snake::unique_instance = NULL;

class Ladder
{
        unordered_map<int, int> ladder_table;

        /* Ladder class will be a singleton class, i.e. only one instance */
        static Ladder* unique_instance;
        Ladder(){};
        Ladder(const Ladder&);
        Ladder& operator=(const Ladder&);

public:
        static Ladder* get_instance()
        {
           if (unique_instance == NULL)
             {
                unique_instance = new Ladder;
             }
           return unique_instance;
        }
        void fill_table(int key, int data)
        {
           ladder_table[key] = data;
        }
        unordered_map <int, int> get_ladder_table()
        {
           return ladder_table;
        }
};

Ladder* Ladder::unique_instance = NULL;

class Player
{
	int cur_pos;
	string name;
public:
	Player()
	{
	    cur_pos = 0;
	}

        void set_name(string name)
        {
            this->name = name;
        }

        string get_player_name()
        {
            return name; 
        }

        int get_player_pos()
        {
            return cur_pos;
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
	    cout << name << " rolled a "<< dice_value << " and moved from " << cur_pos << " to " << next << endl;
	    cur_pos = next;
	}
};

class Game
{      
       Snake *snake;
       Ladder *ladder;
       int player_num;
       Player* players[];
public:
       Game(Snake* s1, Ladder *l1)
       {
          snake = s1;
          ladder = l1;
       }

       void create_player(int player_num)
       {
          this->player_num = player_num;  
          for (int i = 0; i<player_num; i++)
             {  
                players[i] = new Player();
             }
       }

       void set_player_name(int index, string name)
       {
          players[index]->set_name(name);
       }

       void start_game()
       {
          int i = 0; 
          while(1)
            {
               unordered_map <int, int> st = snake->get_snake_table();
               unordered_map <int, int> lt = ladder->get_ladder_table();
               players[i]->move(st, lt);
               if (players[i]->get_player_pos() == 100)
                 {
                    cout << players[i]->get_player_name() << " wins the game" << endl;
                    break;
                 }
               i = (i+1) % player_num;
            }
       }
};

int main() {

    srand(time(0));
    Snake *s1 = Snake::get_instance();
    Ladder *l1 = Ladder::get_instance();

    /* Fill up the snake table */
    int snake_no = 0;
    cin >> snake_no;
    for (int i = 0;i<snake_no;i++)
    {
    	int key = 0, data = 0;
    	cin >> key >> data;
    	s1->fill_table(key, data);
    }

    /* Fill up the ladder table */
    int ladder_no = 0;
    cin >> ladder_no;
    for (int i = 0; i<ladder_no;i++)
    {
    	int key = 0, data = 0;
    	cin >> key >> data;
    	l1->fill_table(key, data);
    }

    Game g1(s1, l1);

    int player_no = 0;
    cin >> player_no;
    g1.create_player(player_no);

    for (int i = 0; i<player_no; i++)
    {
    	string player_name;
    	cin >> player_name;
    	g1.set_player_name(i, player_name);
    }
   
    g1.start_game();

   return 0;
}
