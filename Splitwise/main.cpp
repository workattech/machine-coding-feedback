#include<bits/stdc++.h>
using namespace std;

class User {
	int userId;
	string name, email, contact;
public:
	User (int id, string name, string email, string contact) {
		this->userId = id;
		this->name = name;
		this->email = email;
		this->contact = contact;
	}

	int getUserId () {
		return this->userId;
	}

	void setUserId (int userId) {
		if (this->userId) {
			cout<<"Cannot Set the UserId twice";
			return ;
		}
		this->userId = userId;
	}

};

class Expense {
	vector<vector<int>> borrow;
	int expenseCounter, userCount;
public:
	Expense (int n) {
		this->borrow.resize(n);
		for (int i = 0 ; i < n; ++i)
			this->borrow[i].resize(n, 0);
		this->expenseCounter = 0;
		this->userCount = n;
	}

	void addExpense (int lenderId, int borrowerId, int amount) {
		if (this->borrow[borrowerId-1][lenderId-1] == 0) this->expenseCounter++;
		this->borrow[borrowerId-1][lenderId-1] += amount;
	}

	void showExpense () {
		if (!this->expenseCounter) {
			cout<<"No Balances"<<endl;
			return;
		}
		for (int i =0 ; i < this->userCount; ++i) {
			for (int j = 0; j < this->userCount; ++j) {
				if (this->borrow[i][j]) {
					cout<<"User"<<i+1<<" owes User"<<j+1<<" "<<this->borrow[i][j]<<" amount"<<endl;
				}
			}
		}
	}

	void showExpense (int userId) {
		if (!this->expenseCounter) {
			cout<<"No Balances"<<endl;
			return;
		}
		for (int i =0 ; i < this->userCount ; ++i) {
			if (this->borrow[userId-1][i]) {
				cout<<"User"<<userId<<" owes User"<<i + 1<<" "<<this->borrow[userId-1][i]<<" amount"<<endl;
			} else if (this->borrow[i][userId-1]) {
				cout<<"User"<<i + 1<<" owes User"<<userId<<" "<<this->borrow[i][userId-1]<<" amount"<<endl;
			}
		}
	}
};


int main () {

	#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	#endif

	Expense * expense = new Expense(4);

	string line;
	while (getline(cin, line)) {

		if (line.empty()) continue;

		stringstream ss(line);
		vector<string> tokens;
		string word;
		while(ss >> word) tokens.push_back(word);
		if (tokens.empty()) continue;
		if (tokens[0] == "SHOW") {
			if (tokens.size() == 1) {
				expense->showExpense();
			} else {
				expense->showExpense(tokens[1][1]-'0');
			}
			cout<<"---------------------------------------------------------"<<endl;
		} else {
			int lenderId = tokens[1][1] - '0';
			int amount = stoi(tokens[2]);
			int userDistributionCount = stoi(tokens[3]);
			int cnt = 1;
			vector<int> borrowers(userDistributionCount);
			for (int i =0 ; i < userDistributionCount; ++i)
				borrowers[i] = tokens[3 + i + 1][1] - '0';
			string op = tokens[3 + userDistributionCount + 1];
			if (op == "EQUAL") {
				for (auto borrower : borrowers)
					if (lenderId != borrower)
						expense->addExpense(lenderId, borrower, amount/userDistributionCount);
			} else if (op == "EXACT") {
				vector<int> distributedAmounts(userDistributionCount);
				int expenseAmount = 0;
				for (int i = 1 ; i <= userDistributionCount; ++i) {
					distributedAmounts[i] = stoi(tokens[3 + userDistributionCount + 1 + i]);
					expenseAmount += stoi(tokens[3 + userDistributionCount + 1 + i]);
				}
				if (expenseAmount != amount) {
					cout<<"error distribution not matching"<<endl;
					return 0;
				}
				for (int i =0 ; i < userDistributionCount; ++i)
					if (lenderId != borrowers[i])
						expense->addExpense(lenderId, borrowers[i], distributedAmounts[i]);
			} else if (op == "PERCENT") {
				vector<int> distributedPercentages(userDistributionCount);
				int expensePercentage = 0;
				for (int i = 1 ; i <= userDistributionCount; ++i) {
					distributedPercentages[i] = stoi(tokens[3 + userDistributionCount + 1 + i]);
					expensePercentage += stoi(tokens[3 + userDistributionCount + 1 + i]);
				}
				if (expensePercentage != 100) {
					cout<<"percentages not adding upto 100"<<endl;
					return 0;
				}
				for (int i =0 ; i < userDistributionCount; ++i)
					if (lenderId != borrowers[i])
						expense->addExpense(lenderId, borrowers[i], (distributedPercentages[i]*expensePercentage)/100);
			}
		}

	}

	return 0;
}