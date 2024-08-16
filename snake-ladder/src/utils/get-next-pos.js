const { endPoint } = require('../consts.js');

exports.default = (currPosition, snakes, ladders, diceNum) => {
    let nextPosition = currPosition + diceNum > endPoint ? currPosition : currPosition + diceNum;
    while(snakes[nextPosition] || ladders[nextPosition]) {
        nextPosition = snakes[nextPosition] || ladders[nextPosition];
    }
    return nextPosition;
}