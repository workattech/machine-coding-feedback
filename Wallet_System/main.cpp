#include<bits/stdc++.h>
#include "personalstatement.h"
#include "wallet.h"
#include "person.h"
#include "Service.h"

using namespace std;

int main()
{
    Service Flipkartwallet;
    int n;
    cout<<"Enter number "<<endl;
    cin>>n;
    cin.sync();
    for(int i=0; i<n; i++)
    {
        /*
        string Commands, command, ws;
        cout<<"Enter a command "<<endl;
        cin>>ws;
        getline(cin, Commands);

        vector<string> commands;
        stringstream X(Commands);

        while(getline(X, command, ' '))
            commands.push_back(command);
        */
        string command;

        cout<<"Enter a command ";

        getline(cin, command);

        int start=0;
        vector<string> commands;
        for(int it=0; it<command.size(); it++)
        {
            if(command[it]==' ')
            {
                string singlecommand = command.substr(start, it-start);
                start = it+1;
                commands.push_back(singlecommand);
            }
        }
        commands.push_back(command.substr(start, command.size()-start));

        double amount;

        int e=0;
        if(commands[0]=="CreateWallet")
            e=1;
        else if(commands[0]=="TransferMoney")
            e=2;
        else if(commands[0]=="Statement")
            e=3;
        else if(commands[0]=="Overview")
            e=4;
        else if(commands[0]=="Offer2")
        e=5;


        switch(e)
        {
            case 1: {
                string name = commands[1];
                    amount = stod(commands[2]);
                    Flipkartwallet.createaccount(name, amount);
                    break;
            }

            case 2:
                {
                             string name1 = commands[1];
                    string name2 = commands[2];
                    amount = stod(commands[3]);
                    Flipkartwallet.transfermoney(name1, name2, amount);
                    break;
        }

            case 3: {
                string name = commands[1];
                    Flipkartwallet.viewstatement(name);
                    break;
            }

            case 4: {
                Flipkartwallet.overview();
                    break;
            }

            case 5: {
                Flipkartwallet.offer2();
                    break;
            }

            default: {
             cout<<"wrong command, enter again! ";break;

            }

        }
        //cout<<"Enter 1 to continue or 0 to stop "<<endl;
        //cin>>y;
    }
    //while(y);

}

