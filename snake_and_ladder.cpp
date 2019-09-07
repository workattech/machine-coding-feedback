#include<bits/stdc++.h>

using namespace std;
int v[101];
map<string,int> m;
int main()
{
	int sn,l,p,x,y;
	
	cin>>sn;
	
	for(int i=1;i<=sn;i++)
	{
		cin>>x>>y;
		v[x]=y;
	}
	
	cin>>l;
	
	for(int i=1;i<=l;i++)
	{
		cin>>x>>y;
		v[x]=y;
	}
	
	cin>>p;
	string s;
	
	while(p>0)
	{
		cin>>s;
		m[s]=0;
		p--;
	}
	
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
	return 0;
}
