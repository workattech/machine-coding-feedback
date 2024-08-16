exports.default = () => {
    const nextNum = Math.ceil((1+Math.random()*10))%7;
    return nextNum === 0 ? 1 : nextNum;
}