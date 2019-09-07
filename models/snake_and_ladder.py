__author__ = "Shakti Prasad Lenka"
__email__ = "sinulenka001@gmail.com"

from random import randrange
from .player import Player

class SnakeAndLadder(object):

	def __init__(self,boardSize,nDice,snakes,ladder,players = []):
		self._boardSize = boardSize
		self._nDice = nDice
		self._players = players
		self._snakes = snakes
		self._ladder = ladder
		self._nPlayers = len(players)
		self._nRounds = 0

	def diceThrow(self):
		value = 0
		for throw in range(self._nDice):
			value += randrange(1,6)
		return value

	def ouput(self,player,diceValue):
		print("{} rolled a {} and moved from {} to {}".format(
														player.name,
															diceValue,
												player.initialPosition,
												player.finalPosition))

	def oneRound(self):
		winnerIndex = -1
		winner =None
		success = False
		for index,player in enumerate(self._players):
			damnSnake = True
			yayLadder = True

			#Lets throw dice on behalf of player.name
			diceValue = self.diceThrow()

			player.initialPosition = player.finalPosition
			#only change position if final position is less than _boardSize
			if player.finalPosition + diceValue <=self._boardSize:
				player.finalPosition += diceValue


			##check for ladder and snakes

			while damnSnake or yayLadder:
				if player.finalPosition in self._snakes:
					player.finalPosition = self._snakes[player.finalPosition]
				elif player.finalPosition in self._ladder:
					player.finalPosition = self._ladder[player.finalPosition]

				#check for snake or ladder in resulting position
				damnSnake = player.finalPosition in self._snakes
				yayLadder = player.finalPosition in self._ladder

			#print results
			self.ouput(player, diceValue)

			#check success
			#let other players complete the round even after one player
			#gets to boardSize. They can continue the game till 
			#only one player is left
			if not success and (player.finalPosition == self._boardSize):
				success = True
				winner = player
				winnerIndex = index

		return winnerIndex, winner, success

	def start(self):
		#handle more than 2 players
		while self._nPlayers > 1:
			index, winner,success = self.oneRound()
			self._nRounds += 1
			if success:
				print("{} wins the game".format(winner.name))
				#delete player from list
				self._nPlayers -= 1
				del self._players[index]
		#Extra comments on Game
		print("\nNumber of rounds:{}\n".format(self._nRounds))
		print("Loosing Player:{}\n".format(self._players[0].name))