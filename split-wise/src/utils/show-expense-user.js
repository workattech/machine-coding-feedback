exports.default = (expense, user) => {
    let didShow =  false;
    Object.keys(expense[user]).map((user1) => {
        if(expense[user][user1] > 0) {
            console.log(`${user1} owes ${user}: ${expense[user][user1]}`);
        } else if(expense[user][user1]<0) {
            console.log(`${user} owes ${user1}: ${Math.abs(expense[user][user1])}`);
        }
        didShow = didShow || expense[user][user1];
    })
    if(!didShow) {
        console.log('No balances')
    }
}