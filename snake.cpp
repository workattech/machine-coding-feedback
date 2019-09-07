// Author -> Preeyadarshee Dev
//
// train hard win easy :D
// nik is love
// nik is motivation
//
// do modulo operations very carefully
// try to avoid binary search, use linear search preferrably to make calculations easier
// always make your custom binary search and watch out for overflows
// read the problems carefully
// never rely on floating point calculation
#include<bits/stdc++.h>
#define mp                    make_pair
#define pb                    push_back
#define ll                    long long
#define ss                       second
#define ff                        first
#define fr(i,a,b)   for(ll i=a;i<b;i++)
#define f(i,n)                fr(i,0,n)
#define rf(i,b,a) for(ll i=b-1;i>=a;i--)
#define r(i,n)                rf(i,n,0)
#define inf                   1000000007
#define eps                   0.000000000000001
#define sz(a)                int((a).size())
#define all(c)               (c).begin(),(c).end()
#define tr(c,i)              for(typeof(c).begin() i = (c).begin(); i != (c).end(); i++)
#define present(c,x)         ((c).find(x) != (c).end())
#define cpresent(c,x)        (find(all(c),x) != (c).end())
#define pi                   pair<int,int>
#define pll                  pair < ll , ll >
#define endl                 '\n'
#define PI                   3.141592653589793238462643383279502884197169399375105820974944592307816406286
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
typedef vector< int > vi;
typedef vector< vi > vvi;
int dx[8]={1,-1,0,0,-1,-1,1,1};
int dy[8]={0,0,-1,1,-1,1,-1,1};
vector<int> adj[200010],vis(200010,0),dis(200010,inf),fin(200010,0),col(200010,0),par(200010,0);
int myrandom (int i) { return std::rand()%i;}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    //ifstream fin;
    //ofstream fout;
    //fin.open("input.txt");
    //fout.open("output.txt");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    ifstream fin;
    ofstream fout;
    fin.open("input.txt");
    fout.open("output.txt");
    map<int,int> s,l;
    int a;
    fin>>a;  // number of snakes
    f(i,a)
    {
        int b,c;
        fin>>b>>c; // position of snake
        s.insert({b,c}); // inserting in map : - head as key and tail as value
    }
    fin>>a;  // number of ladders
    f(i,a)
    {
        int b,c;
        fin>>b>>c; // position of ladders
        l.insert({b,c}); // inserting in map :- lower end as key and upper end as value
    }
    int n;
    fin>>n;  // number of players
    vector<string> p(n);
    f(i,n)
    {
        fin>>p[i]; // name of players are pushed in vector
    }
    vector<int> v(n,0); // vector for current position of every player and is initialized to zero
    uniform_int_distribution <int> dis(1,6); // dice can take values from 1 to 6 . so using uniform distribution with random number generator mt19937
    while(1)
    {
        for(int i=0;i<n;i++)
        {
            int num=dis(rng); // generating a random number between 1 to 6
            int ini=v[i];     // initial value of the player's postion
            int ch=num;
            num+=v[i];
            bool ok=true;
            if(num>100)  // no moves , program will jump to printing the statements
            {
                ok=false;
                num=v[i];
            }
            while(ok)
            {
                ok=false;
                if(s.find(num)!=s.end()) // finding if there is a snake at the postion which has been obtained by rolling the dice
                {
                    ok=true;
                    num=s[num]; // if its true , we make the postion of player as the tail of the snake
                }
                if(l.find(num)!=l.end()) // finding if there is a ladder at the postion which has been obtained by rolling the dice
                {
                    ok=true;
                    num=l[num];  // if its true , we make the postion of player as the upper end of the ladder
                }
                // since there can be cases where one player rolled a dice and got a snake and when he/she arrived at new postion arrrived, there is ladder/snake .so we run the loop till we are geeting a laader or snake.
            }
            fout<<p[i]<<" rolled a "<<ch<<" and moved from "<<ini<<" to "<<num<<endl;
            if(num==100)
            {
                fout<<p[i]<<" wins the game"<<endl; // game ends when someonr reaches 100.
                return 0;
            }
            v[i]=num; // updating the position of the current player after all the moves :D
        }
    }
}

