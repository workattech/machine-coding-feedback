const getNextPosition = require('./get-next-pos.js').default;
const rollDice = require('./roll-dice.js').default;
const logMove = require('./log-move.js').default;

exports.default = (turn, positions, names, snakes, ladders) => {
    const currPosition = positions[turn];
    const name = names[turn];
    const diceValue = rollDice();
    const nextPosition = getNextPosition(currPosition, snakes, ladders, diceValue);
    logMove(name, diceValue, currPosition, nextPosition);
    positions[turn] = nextPosition;
}