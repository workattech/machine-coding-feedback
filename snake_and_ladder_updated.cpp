#include<bits/stdc++.h>

using namespace std;

class Snake_and_ladder
{
	int s_no,l_no,p_no;
	int v[101],s_head[101],s_tail[101],l_start[101],l_end[101];
	string p_list[1001];
	map<string,int> m;
	public:
    Snake_and_ladder()
	{  cout<<"welcome";
	  	s_no=0;
	  	l_no=0;
	  	p_no=0;
	  	
	  	for(int i=0;i<101;i++)
	  	{
	  		s_head[i]=0;
	  		s_tail[i]=0;
	  		l_start[i]=0;
	  		l_end[i]=0;
	  		v[i]=0;
		}
		cout<<"Ended";
	}	
    void s_insert(int s)
	{
		s_no=s;
		
		for(int i=1;i<=s_no;i++)
		{
			cin>>s_head[i]>>s_tail[i];
			v[s_head[i]]=s_tail[i];
		}
		cout<<"finish1";
	}	
    void l_insert(int l)
	{
		l_no=l;
		
		for(int i=1;i<=l_no;i++)
		{
			cin>>l_start[i]>>l_end[i];
			v[l_start[i]]=l_end[i];
		}
		cout<<"finish2";
	}	
	void p_insert(int p)
	{
		p_no=p;
		
		string str;
		for(int i=1;i<=p;i++)
	   {
		cin>>p_list[i];
		m[p_list[i]]=0;
		
	   }
	   	cout<<"finish3";
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
		    itr++;
		    if(itr==m.end())
		    itr=m.begin();
		}
	}
	}
};



int main()
{
	int sn,l,p,x,y;
	cout<<"hi";
/*	Snake_and_ladder turn;
	
	cin>>sn;
	cout<<"No";
	turn.s_insert(sn);
	
	cin>>l;
	
	turn.l_insert(l);
	
	cin>>p;
	
	turn.p_insert(p);
	
	turn.output();
*/	
	return 0;
}
