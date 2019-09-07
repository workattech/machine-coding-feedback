__author__ = "Shakti Prasad Lenka"
__email__ = "sinulenka001@gmail.com"

import time
import os
from models.player import Player
from models.snake_and_ladder import SnakeAndLadder


class PlayGame(object):

	snakeAndLadder = None
	snakes = {}
	ladder = {}
	players = []

	def __init__(self):
		print("\n---------------------------------------\n" +
			  "\n    Welcome to Snake and Ladder Game!  \n" +
			  "\n                Have Fun!!             \n" +
			  "\n---------------------------------------\n" )


	def startGame(self):
		print("\nAlright! Thank you for inputs\n")
		print("\nGame starts in....\n")
		time.sleep(1)
		print("3")
		time.sleep(1)
		print("2")
		time.sleep(1)
		print("1\n")
		self.snakeAndLadder.start()

	def takeFileInput(self):
		snakesRead = True
		ladderRead = False
		playerRead = False
		print("\nPlease place the desired input text file in\n"
			 +" input_files folder.\n")
		fileName = input("\nInput file name\n")
		filePointer = 0
		with open(os.path.join("./input_files",fileName+".txt")) as file:
			fileInput = file.read().splitlines()
			nSnakes = int(fileInput[filePointer])
			filePointer += 1
			while nSnakes:
				head,tail = map(int, fileInput[filePointer].split())
				self.snakes[head] = tail
				nSnakes -= 1
				filePointer += 1

			nLadder = int(fileInput[filePointer])
			filePointer += 1
			while nLadder:
				start,end = map(int, fileInput[filePointer].split())
				self.ladder[start] = end
				nLadder -= 1
				filePointer += 1

			nPlayers = int(fileInput[filePointer])
			filePointer += 1
			while nPlayers:
				playerName = fileInput[filePointer]
				self.players.append(Player(playerName))
				nPlayers -= 1
				filePointer += 1
		file.close()
		self.snakeAndLadder = SnakeAndLadder(100,1,self.snakes,self.ladder,self.players)
		print("SnakeAndLadder Game Initiated")

	def takeConsoleInput(self):
		nSnakes = int(input("\nEnter number of snakes \n"))
		print("\nEnter snakes head and tail\n")
		while nSnakes:
			head,tail = map(int, input().split())
			self.snakes[head] = tail
			nSnakes -= 1

		nLadder = int(input("\nEnter number of ladders \n"))
		print("\nEnter ladders start and end\n")
		while nLadder:
			start,end = map(int, input().split())
			self.ladder[start] = end
			nLadder -= 1

		nPlayers = int(input("\nEnter number of players \n"))
		print("\nEnter the player names\n")
		while nPlayers:
			playerName = input()
			self.players.append(Player(playerName))
			nPlayers -= 1

		self.snakeAndLadder = SnakeAndLadder(100,1,self.snakes,self.ladder,self.players)
		print("SnakeAndLadder Game Initiated")

def main():
	pGame = PlayGame()
	inpChoice = int(input("\nPlease Enter\n1.File Input\n2.Console Input\n"))
	if inpChoice == 1:
		pGame.takeFileInput()
	else:
		pGame.takeConsoleInput()
	pGame.startGame()


if __name__ == '__main__':
	main()