# Design Snake And Ladder | Machine Coding

This is my attempt at mock machine coding in Java for a snake and ladder application.
##### Challenge posted by [workat.tech](https://workat.tech/) on [this link.](https://workat.tech/machine-coding/practice/snake-and-ladder-problem-zgtac9lxwntg)

## Problem Statement:

Create a snake and ladder application. The application should take as input (from the command line or a file):

- Size of the board as integer
- Number of dice (either 1 or 2)
- Number of snakes (s) followed by s lines each containing 2 numbers denoting the head and tail positions of the snake.
- Number of ladders (l) followed by l lines each containing 2 numbers denoting the start and end positions of the ladder.
- Number of players (p) followed by p lines each containing a name.

<br>

Sample Input 1:
```
100
1
9
62 5
33 6
49 9
88 16
41 20
56 53
98 64
93 73
95 75
8
2 37
27 46
10 32
51 68
61 79
65 84
71 91
81 100
2
Vineet
Satya
```
<br>

Sample Input 2
```
100
2
0
0
3
Gaurav
Sagar
Vineet
```

## Assumptions:

- Board size is 1 or above.
- There won’t be multiple snakes/ladders at the same start/head point
- It is possible to reach the end of board, i.e., it is possible to win the game.
- Snakes and Ladders do not form an infinite loop.
- If there are two dice in the game, and a player requires just 1 to complete the game; then he is allowed to finish if he rolls 2. 

## Future Scope

- Add test cases
- Add features:
    - On getting a 6, you get another turn and on getting 3 consecutive 6s, all the three of those get cancelled.
    - On starting the application, the snakes and ladders should be created programmatically without any user input, keeping in mind the constraints mentioned in rules.