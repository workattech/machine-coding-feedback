const twoPlaces = require('./two-places').default;

exports.default = (input) => {
    const inputArr = input.split('\n');
    for(let i=0;i<inputArr.length;i++) {
        const currInput = inputArr[i].split(' ');
        const parsedInput = {}
        switch (currInput[0]) {
            case 'EXPENSE':
                parsedInput.command = currInput[0];
                parsedInput.user = currInput[1];
                parsedInput.totalAmount = twoPlaces(Number(currInput[2]));
                parsedInput.otherUsersCount = Number(currInput[3]);
                parsedInput.otherUsers = currInput.slice(4, 4+parsedInput.otherUsersCount);
                parsedInput.method = currInput[4+parsedInput.otherUsersCount];
                if(parsedInput.method === 'PERCENT' || parsedInput.method === 'EXACT') {
                    parsedInput.shares = currInput.slice([4+parsedInput.otherUsersCount+1]).map(num => twoPlaces(Number(num)));
                }
            case 'SHOW':
                parsedInput.command = currInput[0];
                if(currInput[1]) {
                    parsedInput.user = currInput[1];
                }
        }
        inputArr[i] = parsedInput
    }
    return inputArr;
}