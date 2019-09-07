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
    fin>>a;
    f(i,a)
    {
        int b,c;
        fin>>b>>c;
        s.insert({b,c});
    }
    fin>>a;
    f(i,a)
    {
        int b,c;
        fin>>b>>c;
        l.insert({b,c});
    }
    int n;
    fin>>n;
    vector<string> p(n);
    f(i,n)
    {
        fin>>p[i];
    }
    vector<int> v(n,0);
    uniform_int_distribution <int> dis(1,6);
    while(1)
    {
        for(int i=0;i<n;i++)
        {
            int num=dis(rng);
            int ini=v[i];
            int ch=num;
            num+=v[i];
            bool ok=true;
            if(num>100)
            {
                ok=false;
                num=v[i];
            }
            while(ok)
            {
                ok=false;
                if(s.find(num)!=s.end())
                {
                    ok=true;
                    num=s[num];
                }
                if(l.find(num)!=l.end())
                {
                    ok=true;
                    num=l[num];
                }
            }
            fout<<p[i]<<" rolled a "<<ch<<" and moved from "<<ini<<" to "<<num<<endl;
            if(num==100)
            {
                fout<<p[i]<<" wins the game"<<endl;
                return 0;
            }
            v[i]=num;
        }
    }
}
