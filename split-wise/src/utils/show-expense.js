exports.default = (expense, users) => {
    let didShow = false;
    users.forEach((user) => {
        const userExpense = expense[user];
        Object.keys(userExpense).map(user1 => {
            if(userExpense[user1] > 0) {
                didShow = true;
                console.log(`${user1} owes ${user}: ${userExpense[user1]}`);
            }
        })
    })
    if(!didShow) {
        console.log('No balances')
    }
}