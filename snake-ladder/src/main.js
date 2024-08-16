const fs = require('fs');
const path = require('path');
const { readInput, isGameOver, getWinningPos, announceWinner, nextMove } = require('./utils/index.js');

const inputFilePath = path.resolve(__dirname, '../resources/input.txt');
const input = fs.readFileSync(inputFilePath, { encoding: 'utf-8'});
const { snakes, ladders, players: { names, positions } } = readInput(input);
const numPlayers = positions.length;

let turn = 0;
while(!isGameOver(positions)) {
    nextMove(turn, positions, names, snakes, ladders);
    turn = (turn+1)%numPlayers
}

const winInd = getWinningPos(positions);
announceWinner(names[winInd]);