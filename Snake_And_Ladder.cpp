#include<bits/stdc++.h>
using namespace std;
#define ll long long int 
ll fun(ll , ll , map<ll,ll> , map<ll,ll>);
int main()
{
    ll s, l, p, head, tail, start, end, temp = 0, last = 0 ;
    map<ll,ll> mymap;
    map<ll,ll> mymap2;

    cin >> s;
    
    for(ll i=0;i<s;i++)
    {
        cin >> head >> tail;
        mymap[head] = tail;
    }

    cin >> l;
    
    for(ll i=0;i<l;i++)
    {
        cin >> start >> end;
        mymap2[start] = end;
    }
    
    cin >> p;
    
    vector<string> myvec(p);
    vector<ll> myvec2(p);

    for(ll i=0;i<p;i++)
        cin >> myvec[i];

    srand(time(NULL));

    bool var = false;
    cout << endl;
    cout << "-------------------------------------------------------------------------------------------";
    cout << endl;

    while(var != true)
    {
        for(ll i = 0 ; i < p ; i++)
        {   	
            temp = rand()%6 + 1;

            last = fun(myvec2[i], temp, mymap, mymap2);
            
            cout << myvec[i] << " rolled a " << temp;
            cout << " and moved from " <<myvec2[i] << " to " << last << endl;
            
            myvec2[i] = last;
            
            if(myvec2[i] == 100)
            {  
            	var = true;
                cout << myvec[i] << " wins the match " << endl;
                break;
            }
        }
    }

    cout << endl;
    cout << "--------------------------------------------------------------------------------------------";
    cout << endl;
    return 0;
}
ll fun(ll p, ll d, map<ll,ll> ma2, map<ll,ll> ma)
{
    if((p + d) > 100)
        return p;

    p = p + d;
    
    if(ma.count(p) > 0)
        return ma[p];

    else if(ma2.count(p) > 0)
        return ma2[p];

    return p;
}