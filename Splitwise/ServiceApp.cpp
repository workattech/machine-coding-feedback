#include "ServiceApp.h"

ServiceApp::ServiceApp()
{
    //ctor
}

ServiceApp::ServiceApp(int nuser)
{
    nouser = nuser;
    appt.settotaluser(nuser);
}


void ServiceApp::setuserdetails(vector<User> vuser)
        {

            for(size_t i=0; i<vuser.size(); i++)
            {
                User u = vuser[i];
                userdetails[u.getid()] = u;
            }

            unordered_map<int, unordered_map<int, double> > usertrans;

            for(size_t i=0; i<vuser.size(); i++)
            {
                User u = vuser[i];
                unordered_map<int, double> trans;

                for(size_t j=0; j<vuser.size(); j++)
                {
                    if(j!=i)
                    {
                        trans[vuser[j].getid()] = 0;
                    }
                }

                usertrans[vuser[i].getid()] = trans;
            }

            appt.settransuser(usertrans);

        }


void ServiceApp::setnouser(int nuser)
{
    nouser = nuser;
}

int ServiceApp::getnouser()
{
    return nouser;
}

int ServiceApp::stringtoint(string s)
{
    int x=0;
    stringstream sst(s);
    sst>>x;
    return x;
}

void ServiceApp::transact(vector<string> commands)
{
    for(size_t i=0; i<commands.size(); i++)
    {
        string s = commands[i];
        vector<string> command;
        size_t start=0, j;
        for(j=0; j<s.size(); j++)
        {
            if(s[j]==' ')
            {
                string cmd = s.substr(start, (j-start) );
                command.push_back(cmd);
                start = j+1;
            }
        }
        if(start<s.size())
        {
                string cmd = s.substr(start, (s.size()-start));
                command.push_back(cmd);
        }

        size_t k=0;

        if(command[0].compare("EXPENSE")==0)
        {
            int u_id = stringtoint(command[++k]);
            double amount = stringtoint(command[++k]);
            int nuser = stringtoint(command[++k]);
            vector<int> ids;

            for(; k<(nuser+3); k++)
            {
                ids.push_back(stringtoint(command[k]) );
            }

            if(command[k+1].compare("EQUAL")==0)
            {
                    appt.equal_add(u_id, amount, nuser, ids);
            }
            else if(command[k+1].compare("EXACT")==0)
            {
                vector<double> exactmoney;
                int sum = 0;
                for(size_t l=k+2; l<command.size(); l++)
                {
                    int money = stringtoint(command[l]);
                    sum += money;
                    exactmoney.push_back((double)money);
                }

                if( ((int)sum) == ((int)amount) )
                appt.exact_add(u_id, amount, nuser, ids, exactmoney);
            }
            else if(command[k+1].compare("PERCENT")==0)
            {
                vector<double> percent;
                int p=0;
                for(size_t l=k+2; l<command.size(); l++)
                {
                    int per = stringtoint(command[l]);
                    p += per;
                    percent.push_back((double)per);
                }
                if( ((int)p) == 100)
                    appt.percent_add(u_id, amount, nuser, ids, percent);
            }

        }
        else if(command[0].compare("SHOW")==0)
        {

            if(command.size()==1)
                appt.show();
            else
                appt.show(stringtoint(command[1]));
        }

    }
}
