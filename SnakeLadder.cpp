#include<bits/stdc++.h>
using namespace std;

class Player{
    string name;
    int position;

public:
    Player(){}
    Player(string name)
    {
        srand(time(0));
        this->name=name;
        this->position=0;
    }
    string getName()
    {
        return name;
    }
    int getPosition()
    {
        return position;
    }
    void setPosition(int newPosition)
    {
        position=newPosition;
    }
    int rollDice(int noOfDice)
    {
        return noOfDice + (rand() % (noOfDice*6-noOfDice+1));
    }
};


class Snake{
    int head;
    int tail;

public:
    Snake(){}
    Snake(int head,int tail)
    {
        this->head=head;
        this->tail=tail;
    }
    int getHead()
    {
        return head;
    }
    int getTail()
    {
        return tail;
    }
};

class Ladder{
    int head;
    int tail;

public:
    Ladder(){}
    Ladder(int head,int tail)
    {
        this->head=head;
        this->tail=tail;
    }
    int getHead()
    {
        return head;
    }
    int getTail()
    {
        return tail;
    }
};


class Board{
    int boardSize;
    vector<int> board;
    vector<Snake> snakes;
    vector<Ladder> ladders;
public:
    Board(){}
    Board(int boardSize)
    {
        this->boardSize=boardSize;
        board.resize(boardSize+1,0);
    }
    int getBoardSize()
    {
        return boardSize;
    }
    vector<Snake> getSnakes()
    {
        return snakes;
    }
    vector<Ladder> getLadders()
    {
        return ladders;
    }

    void setSnakes(vector<Snake> s)
    {
        snakes=s;
    }
    void setLadders(vector<Ladder> l)
    {
        ladders=l;
    }

    void arrangeBoard()
    {
        for(Snake s: snakes)
            board[s.getHead()]=s.getTail();
        for(Ladder l: ladders)
            board[l.getHead()]=l.getTail();
    }
    int getJumpValue(int position)
    {
        return board[position];
    }

    void displayBoard()
    {
        for(int i=0;i<=boardSize;i++)
            cout<<board[i]<<" ";
        cout<<"\n";
    }
};





int main()
{
    int boardSize,s,l,p,i=1,head,tail,noOfDice;
    string name;
    vector<Snake> snakes;
    vector<Ladder> ladders;
    queue<Player> players;
    cout<<"Enter Board Size\n"; // Optional Req 2
    cin>>boardSize;

    cout<<"Enter no of snakes\n";
    cin>>s;
    while(i<=s)
    {
        cout<<"Enter head and tail for snake "<<i<<":\n";
        cin>>head>>tail;
        Snake snake(head,tail);
        snakes.push_back(snake);
        i++;
    }

    i=1;
    cout<<"Enter no of ladders\n";
    cin>>l;
    while(i<=l)
    {
        cout<<"Enter head and tail for ladder "<<i<<":\n";
        cin>>head>>tail;
        Ladder ladder(head,tail);
        ladders.push_back(ladder);
        i++;
    }

    i=1;
    cout<<"Enter no of players(at least 2):\n";
    cin>>p;
    while(i<=p)
    {
        cout<<"Enter name of player "<<i<<":\n";
        cin>>name;
        Player player(name);
        players.push(player);
        i++;
    }

    cout<<"Enter no of dice\n";     //Optional Req 1
    cin>>noOfDice;

    Board b(boardSize);
    b.setSnakes(snakes);
    b.setLadders(ladders);
    b.arrangeBoard();


    while(players.size()>1) //Optional Req 3
    {
        //Game begins
        Player p=players.front();
        players.pop();
        int diceValue=p.rollDice(noOfDice);
        int initialPosition=p.getPosition();
        int finalPosition=initialPosition+diceValue;
        if(finalPosition>b.getBoardSize())
            finalPosition=initialPosition;
        else
        {
            while(b.getJumpValue(finalPosition)!=0)
            {
                finalPosition=b.getJumpValue(finalPosition);
            }
        }
        p.setPosition(finalPosition);

        cout<<p.getName()<<" rolled a "<<diceValue<<" and moved from "<<initialPosition<<" to "<<finalPosition<<"\n";
        if(finalPosition==b.getBoardSize())
        {
            cout<<p.getName()<<" has won!!\n\n";
            continue;
        }
        players.push(p);
    }
    return 0;
}

