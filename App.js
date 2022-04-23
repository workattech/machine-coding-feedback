import React, { useState, useEffect, useRef } from 'react';
import { SnakePositions } from './Snake.js';
import { LadderPositions } from './Ladder.js';
import './style.css';

export default function App() {
  const [startGame, setStartGame] = useState(false);
  const [gameOver, setGameOver] = useState(false);
  const [firstPlayerName, setFirstPlayerNme] = useState('');
  const [secondPlayerName, setSecondPlayerNme] = useState('');
  const [firstPosition, setFirstPosition] = useState({
    prevStep: 0,
    currStep: 0,
  });
  const [secondPosition, setSecondPosition] = useState({
    prevStep: 0,
    currStep: 0,
  });
  const [currentTurn, setCurrentTurn] = useState(1);
  const [diseNumber, setDiseNumber] = useState(0);
  const [currentSenerio, setCurrentSenerio] = useState('normal');
  const firstPlayer = useRef(null);
  const secondPlayer = useRef(null);
  const currentPlayer = currentTurn === 1 ? firstPlayerName : secondPlayerName;
  const previousPlayer = currentTurn === 2 ? firstPlayerName : secondPlayerName;
  const currentPosition = currentTurn === 1 ? secondPosition : firstPosition;

  const isSnakePresent = (position) => {
    let snakePos = SnakePositions.find((snake) => snake.start === position);
    if (snakePos) {
      if (currentTurn == 1) {
        setFirstPosition({
          prevStep: position,
          currStep: snakePos.end,
        });
      } else {
        setSecondPosition({ prevStep: position, currStep: snakePos.end });
      }
      setCurrentSenerio('snake');
      return true;
    }
    return false;
  };

  const isLadderPresent = (position) => {
    let ladderPos = LadderPositions.find((ladder) => ladder.start === position);
    if (ladderPos) {
      if (currentTurn == 1) {
        setFirstPosition({ prevStep: position, currStep: ladderPos.end });
      } else {
        setSecondPosition({ prevStep: position, currStep: ladderPos.end });
      }
      if (isWin(ladderPos.end)) setGameOver(true);
      setCurrentSenerio('ladder');
      return true;
    }
    return false;
  };

  const isWin = (position) => {
    return position === 100;
  };

  const outofBound = (position) => {
    return position > 100;
  };

  const startGameBtn = () => {
    setFirstPlayerNme(firstPlayer.current.value);
    setSecondPlayerNme(secondPlayer.current.value);
    setStartGame(true);
  };

  const restartGame = () => {
    setStartGame(false);
    setGameOver(false);
    setFirstPlayerNme('');
    setSecondPlayerNme('');
    setCurrentTurn(1);
    setCurrentSenerio('normal');
    setDiseNumber(0);
    setFirstPosition({ prevStep: 0, currStep: 0 });
    setSecondPosition({ prevStep: 0, currStep: 0 });
  };

  const diseRoll = () => {
    const number = Math.floor(Math.random() * 6 + 1);
    setDiseNumber(number);
    if (currentTurn == 1) {
      let newPosition = firstPosition.currStep + number;
      if (!outofBound(newPosition)) {
        if (
          !isSnakePresent(newPosition) &&
          !isLadderPresent(newPosition) &&
          !isWin(newPosition)
        ) {
          setCurrentSenerio('normal');
          setFirstPosition({
            prevStep: firstPosition.currStep,
            currStep: newPosition,
          });
        } else if (isWin(newPosition)) {
          setGameOver(true);
        }
      } else setCurrentSenerio('outofBound');
    } else {
      let newPosition = secondPosition.currStep + number;
      if (!outofBound(newPosition)) {
        if (
          !isSnakePresent(newPosition) &&
          !isLadderPresent(newPosition) &&
          !isWin(newPosition)
        ) {
          setSecondPosition({
            prevStep: secondPosition.currStep,
            currStep: newPosition,
          });
        } else if (isWin(newPosition)) {
          setGameOver(true);
        }
      }
    }
    setCurrentTurn(currentTurn === 1 ? 2 : 1);
  };

  return (
    <div>
      <h1>SNAKE AND LADDER</h1>
      {!gameOver && !startGame && (
        <div>
          <label>Enter First Player Name: </label>
          <input ref={firstPlayer} />
          <label>Enter Second Player Name: </label>
          <input ref={secondPlayer} />
          <button onClick={() => startGameBtn()}>Start</button>
        </div>
      )}
      {!gameOver && startGame && (
        <div>
          <p>
            {firstPlayerName} current position is {firstPosition.currStep}
          </p>
          <p>
            {secondPlayerName} current position is {secondPosition.currStep}
          </p>

          <h2>{currentPlayer} Your Turn</h2>
          <button onClick={() => diseRoll()}>Roll the dise</button>
          {Boolean(diseNumber) && currentSenerio === 'normal' && (
            <p>
              {previousPlayer} rolled a {diseNumber} and moved from{' '}
              {currentPosition.prevStep} to {currentPosition.currStep}{' '}
            </p>
          )}
          {Boolean(diseNumber) && currentSenerio === 'ladder' && (
            <p>
              {previousPlayer} has {diseNumber} got ladder and moved from{' '}
              {currentPosition.prevStep} to {currentPosition.currStep}{' '}
            </p>
          )}
          {Boolean(diseNumber) && currentSenerio === 'snake' && (
            <p>
              {previousPlayer} has {diseNumber} got snake bite and moved from{' '}
              {currentPosition.prevStep} to {currentPosition.currStep}{' '}
            </p>
          )}
          {Boolean(diseNumber) && currentSenerio === 'outofBound' && (
            <p>
              {previousPlayer} stays at {currentPosition.currStep} as{' '}
              {diseNumber} as out of bound
            </p>
          )}
        </div>
      )}
      {gameOver && (
        <h1>
          {currentPlayer} wins the game{' '}
          <button onClick={() => restartGame()}>Play Again</button>
        </h1>
      )}
    </div>
  );
}
