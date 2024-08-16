exports.default = (input) => {
    const inputToArr = input.split('\n');
    const numSnake = Number(inputToArr[0]);
    const numLadder = Number(inputToArr[numSnake+1]);
    const snakes = {};
    const ladders = {};
    const players = { names: [], positions: [] };

    for(let i=1;i<=numSnake;i++) {
        const snake = inputToArr[i].split(' ');
        snakes[Number(snake[0])] = Number(snake[1]);
    }

    for(let i=numSnake+2;i<numSnake+numLadder+2;i++) {
        const ladder = inputToArr[i].split(' ');
        ladders[Number(ladder[0])] = Number(ladder[1]);
    }

    for(let i=numSnake+numLadder+3;i<inputToArr.length;i++) {
        const player = inputToArr[i];
        players.names.push(player);
        players.positions.push(0);
    }

    return { snakes, ladders, players };
}