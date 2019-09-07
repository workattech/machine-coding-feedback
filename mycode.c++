#include<bits/stdc++.h>
using namespace std;
#define pb push_back

int s,l,p,r,c;
map<int,int>snake;
map<int,int>ladder;
vector<string>name;
void get_input(){
	int a,b,i;
	string c;
	cin>>s;
	for(i=0;i<s;i++){
		cin>>a>>b;
		snake.insert({a,b});
	}
	cin>>l;
	for(i=0;i<l;i++){
		cin>>a>>b;
		ladder.insert({a,b});
	}
	cin>>p;
	for(i=0;i<p;i++){
		cin>>c;
		name.pb(c);
	}
}
void play(){
	int i=0,die,x,tpos;
	vector<int>pos(p,0);
	while(1){
		die=rand()%6+1;
		x=pos[i%p];
		tpos=x+die;
		while(1){
			if(snake.find(tpos)!=snake.end())
				tpos=snake[tpos];
			else if(ladder.find(tpos)!=ladder.end())
				tpos=ladder[tpos];
			else
				break;
		}
		if(tpos>100)
			cout<<name[i%p]<<" rolled a "<<die<<" and moved from "<<pos[i%p]<<" to "<<pos[i%p]<<endl;
		else if(tpos==100){
			cout<<name[i%p]<<" rolled a "<<die<<" and moved from "<<pos[i%p]<<" to "<<tpos<<endl;
			cout<<name[i%p]<<" wins the game"<<endl;
			pos[i%p]=tpos;
			break;
		}
		else{
			cout<<name[i%p]<<" rolled a "<<die<<" and moved from "<<pos[i%p]<<" to "<<tpos<<endl;
			pos[i%p]=tpos;
		}
		i++;
	}
}
void get_input2(){
	int i,temp,f=0,head,tail,start,end;
	string z;
	//enter board size
	cin>>r>>c;
	cin>>p;
	for(i=0;i<p;i++){
		cin>>z;
		name.pb(z);
	}
	s=rand()%(r*c-1);
	for(i=0;i<s;i++){
		while(1){
			head=rand()%(r*c-2)+2;
			if(snake.find(head)==snake.end())
				break;
		}
		tail=rand()%(head-1)+1;
		snake.insert({head,tail});
	}
	for(i=0;i<l;i++){
		while(1){
			start=rand()%(r*c-1)+1;
			if(snake.find(start)==snake.end() && ladder.find(start)==ladder.end())
				break;
		}
		end=rand()%(r*c-start)+(start+1);
		f=0;
		if(snake.find(end)!=snake.end()){
			temp=snake[end];
			if(temp==start)
				f=1;
			while(1){
				if(ladder.find(temp)!=ladder.end())
					temp=ladder[temp];
				if(snake.find(temp)!=snake.end()){
					temp=snake[temp];
					if(temp==start){
						f=1;
						break;
					}
				}
				else
					break;
			}
		}
		if(f==1)
			i--;
		else
			ladder.insert({start,end});
	}
}
void play2(){
	int i=0,die,x,tpos,p1=p,k,count=0,count1=0,die1,die2,s=0;
	vector<string>name2;
	vector<int>pos(p,0),pos1;
	while(1){
		count=0;
		s=0;
		do{
			if(count==3)
				s=0;
			die1=rand()%6+1;
			die2=rand()%6+1;
			die=die1+die2;
			s+=die;
			count++;
		}while(die==6);
		//considering that the player gets another chance on cancellation of 3 6's
		die=s;
		x=pos[i%p];
		tpos=x+die;
		while(1){
			if(snake.find(tpos)!=snake.end())
				tpos=snake[tpos];
			else if(ladder.find(tpos)!=ladder.end())
				tpos=ladder[tpos];
			else
				break;
		}
		if(tpos>r*c)
			cout<<name[i%p]<<" rolled a "<<die<<" and moved from "<<pos[i%p]<<" to "<<pos[i%p]<<endl;
		else if(tpos==r*c){
			cout<<name[i%p]<<" rolled a "<<die<<" and moved from "<<pos[i%p]<<" to "<<tpos<<endl;
			cout<<name[i%p]<<" wins the game"<<endl;
			pos[i%p]=tpos;
			name2.clear();
			pos1.clear();
			for(k=i%p+1;k<p;k++){
				name2.pb(name[k]);
				pos1.pb(pos[k]);
			}
			for(k=0;k<i%p;k++){
				name2.pb(name[k]);
				pos1.pb(pos[k]);
			}
			p--;
			name.clear();
			pos.clear();
			for(k=0;k<p;k++){
				name.pb(name2[k]);
				pos.pb(pos1[k]);
			}
			count1++;
			i=-1;
			if(count1==p1-1)
				break;
		}
		else{
			cout<<name[i%p]<<" rolled a "<<die<<" and moved from "<<pos[i%p]<<" to "<<tpos<<endl;
			pos[i%p]=tpos;
		}
		i++;
	}
}
int main(){
	srand(time(NULL));
	get_input();
	play();
	//optional changes
	name.clear();
	snake.clear();
	ladder.clear();
	get_input2();
	play2();
	return 0;
}