#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main(){
    int n;
    cout<<"Enter Number of snakes : ";
    cin>>n;
    pair<int,int> Snake[n];
    for(int i = 0 ;i <n;i++){
        cin>>Snake[i].first >> Snake[i].second;
    }
    cout<<"Enter Number of Ladder :";
    int m; cin>>m;
    pair<int,int> Ladder[m];
    for(int i = 0 ; i <m ;i++){
        cin>>Ladder[i].first >> Ladder[i].second;
    }
    vector<int> Play(101);
    for(int i = 0 ; i<101 ; i++){
        Play[i] = i;
    }
    //Traversing Snakes
    for(int i = 0 ; i<n ; i++){
        Play[Snake[i].first] = Snake[i].second;
    }
    //Traversing Ladder
    for(int i = 0 ; i<m ; i++){
        Play[Ladder[i].first] = Ladder[i].second;
    }
    cout<<"Enter The name of Players :"<<endl;
    string s1,s2;
    cin>>s1>>s2;
    int c1 = 0;
    int c2 = 0;
    //PlayGround 
    while(c1 != 100 && c2 != 100){
        srand(time(0));
        int temp1 = 1 + rand() % (6);
        int prev1 = c1;
        c1 = c1 + temp1;
        c1 = Play[c1];
        cout<<s1<<"  Rolled a "<<temp1<<" And moved from "<<prev1<<" to "<<c1<<endl;
        //checking for first Player
        if(c1 == 100){
            cout<<"Winner is "<<s1<<endl;
            break; 
        }

        int prev2 = c2;
        int temp2 = 1 + rand() % 6;
        c2 = c2 + temp2;
        c2 = Play[c2];
        cout<<s2<<"  Rolled a "<<temp2<<" And moved from "<<prev2<<" to "<<c2<<endl;
        if(c2 == 100){
            cout<<"Winner is "<<s2<<endl;
            break; 
        }


    }
    cout<<"THE END"<<endl;

}