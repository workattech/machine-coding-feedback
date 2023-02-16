# Solution of Snake and Ladder game Machine Coding
Problem Link : [Create a snake and ladder application.](https://workat.tech/machine-coding/editorial/how-to-design-snake-and-ladder-machine-coding-ehskk9c40x2w)
Author : [Md Sharique Eliyas](https://github.com/mdshariqueeliyas)

How to build and run code
 - Clone the repo and switch to root of the repo
 - run below command to generate all `.class` files in `target` directory.
```
find . -name "*.java" | xargs javac -d target
```
 - Switch to target directory and run
```
java io.shaeli.machinecoding.snakeandladder.Driver < ../src/main/resources/input.txt
```
 - You can update src/main/resources/input.txt file to update board size, number of players, snake and ladders
 - Or you can directly run, this will ask for all the configurations of game.
```
java io.shaeli.machinecoding.snakeandladder.Driver
```
 