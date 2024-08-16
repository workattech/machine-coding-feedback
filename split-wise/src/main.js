const fs = require('fs');
const path = require('path');
const { readInput, initializeExpense, showExpense, showExpenseByUser, twoPlaces } = require('./utils/index.js');

const inputFilePath = path.resolve(__dirname, '../resources/input.txt');
const input = fs.readFileSync(inputFilePath, { encoding: 'utf-8' });
const parsedInput = readInput(input);
const users = ['u1', 'u2', 'u3', 'u4'];
const expense = initializeExpense(users);

for(let i=0;i<parsedInput.length;i++) {
    const { command, user } = parsedInput[i];
    if(command === 'SHOW') {
        if(user) showExpenseByUser(expense, user);
        else showExpense(expense, users);
    } else {
        const { totalAmount, otherUsersCount, otherUsers, method, shares } = parsedInput[i];
        if(method === 'PERCENT') {
            if(shares.reduce((acc, num) => acc+num) != 100) throw new Error('Count of all shares do not evaluate to 100 percent for input:', parsedInput[i]);
            let amount = 0;
            for(let j=1;j<shares.length;j++) {
                shares[j] = twoPlaces(((shares[j]/100)*totalAmount));
                if(otherUsers[j] != user) {
                    expense[user][otherUsers[j]] += shares[j];
                    expense[otherUsers[j]][user] -= shares[j];
                }
                amount+=shares[j];
            }
            shares[0] = totalAmount-amount;
            if(otherUsers[0] != user) {
                expense[user][otherUsers[0]] += shares[0];
                expense[otherUsers[0]][user] -= shares[0];
            }
        } else if(method === 'EXACT') {
            if(shares.reduce((acc, num) => acc+num) != totalAmount) throw new Error('Count of all shares do not evaluate to total amount for input:', parsedInput[i]);
            for(let j=0;j<shares.length;j++) {
                expense[user][otherUsers[j]] += shares[j];
                expense[otherUsers[j]][user] -= shares[j];
            }
        } else {
            const share = twoPlaces(totalAmount/(otherUsersCount));
            for(let j=0;j<otherUsers.length;j++) {
                expense[user][otherUsers[j]] += share;
                expense[otherUsers[j]][user] -= share;
            }
        }
    }
}