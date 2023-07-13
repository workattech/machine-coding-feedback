#include<bits/stdc++.h>

using namespace std;

class Snake_and_ladder
{
	int no_of_snakes,no_of_ladders,no_of_persons;
	int v[101],s_head[101],s_tail[101],l_start[101],l_end[101];
	string person_list[1001];
	map<string,int> m;
	public:
    Snake_and_ladder()
	{
	  	no_of_snakes=0;
	  	no_of_ladders=0;
	  	no_of_persons=0;
	  	
	  	for(int i=0;i<101;i++)
	  	{
	  		s_head[i]=0;
	  		s_tail[i]=0;
	  		l_start[i]=0;
	  		l_end[i]=0;
	  		v[i]=0;
		}

	}	
    void snakes_details(int s)
	{
		no_of_snakes=s;
		
		for(int i=1;i<=no_of_snakes;i++)
		{
			cin>>s_head[i]>>s_tail[i];
			v[s_head[i]]=s_tail[i];
		}

	}	
    void ladders_details(int l)
	{
		no_of_ladders=l;
		
		for(int i=1;i<=no_of_ladders;i++)
		{
			cin>>l_start[i]>>l_end[i];
			v[l_start[i]]=l_end[i];
		}

	}	
	void person_details(int p)
	{
		no_of_persons=p;
		
		string str;
		for(int i=1;i<=p;i++)
	   {
		cin>>person_list[i];
		m[person_list[i]]=0;
		
	   }

	}
	void output()
	{
		int flag=0;
	map<string,int>::iterator itr;
	
	itr=m.begin();

	while(!flag)
	{ 
		int val=(rand()%6+1);
		if(itr->second+val==100)
		{
			flag=1;
			cout<<itr->first<<" wins the game";
		}
		else if(itr->second+val<100)
		{
			int place;
			if(v[itr->second+val])
			place=v[itr->second+val];
			else place=itr->second+val;
		
		    cout<<itr->first<<" rolled a "<<val<<" and moved from "<<itr->second<<" to "<<place<<endl;
		    itr->second=place;
		
		}
	    itr++;
	    if(itr==m.end())
	    itr=m.begin();
	}
	}
};



int main()
{
	int sn,l,p,x,y;

	Snake_and_ladder turn;
	
	cin>>sn;

	turn.snakes_details(sn);
	
	cin>>l;
	
	turn.ladders_details(l);
	
	cin>>p;
	
	turn.person_details(p);
	
	turn.output();
	
	return 0;
}
