package game

import (
	"fmt"
	"github.com/Piyushh1/mock-machine-coding-1/internal/pkg/utils"
	"strconv"
)

var (
	players []player
	ladder = map[int]int{}
	snake = map[int]int{}
)

const (
	// should be configurable
	finalCell = 100
)

func NewManager() Manager {
	m := new(manager)

	return m
}

type Manager interface {
	InitLadder(startCell, endCell string)
	InitSnakes(endCell, startCell string)
	InitPlayers(name string)
	StartGame()
}

type manager struct {
}


type player struct {
	Name string
	Position int
}

func (m *manager) InitLadder(startCell, endCell string) {
	ec, _ := strconv.Atoi(endCell)
	sc, _ := strconv.Atoi(startCell)
	ladder[sc] = ec
}

func (m *manager) InitSnakes(endCell, startCell string) {
	ec, _ := strconv.Atoi(endCell)
	sc, _ := strconv.Atoi(startCell)
	snake[ec] = sc
}

func (m *manager) InitPlayers(name string) {
	players = append(players, player{Name: name, Position: 0})
}

func checkLadder(cell int) int {
	newCell, ok := ladder[cell]
	 if ok {
	 	return checkLadder(newCell)
	}
	return cell
}

func checkSnake(cell int) int {
	if newCell, ok := ladder[cell]; ok {
		return checkSnake(newCell)
	}
	return cell
}

func checkGameEnd(cell int) bool {
	if cell == finalCell {
		return true
	}
	return false
}

func (m *manager) StartGame() {

	// validate() - call validate before StartGame. This will ensure all user input/file inputs are valid. Ex - ladder cells should not be greater than the board cell etc

	// End game when only single player is remaining
	for len(players) > 1 {
		// iterate through players
		for ind, p := range players {

			if len(players) == 1 {
				break
			}

			move := utils.GenerateRandomMove()
			if p.Position+move > finalCell {
				fmt.Println(p.Name, "rolled a", move, "and moved from", p.Position, "to", p.Position)
				continue
			}
			nextCell := move + p.Position

			// check any ladder on this cell
			newCell := checkLadder(nextCell)
			if newCell != nextCell {
				nextCell = newCell
			}

			// check any snake on this cell
			newCell = checkSnake(nextCell)
			if newCell != nextCell {
				nextCell = newCell
			}

			if checkGameEnd(nextCell) {
				fmt.Println(p.Name, "rolled a", move, "and moved from", p.Position, "to", nextCell)
				// remove the player
				players[ind] = players[len(players)-1] // Copy last element to index i.
				players[len(players)-1] = player{}     // Erase last element (write zero value).
				players = players[:len(players)-1]     // Truncate slice.
				fmt.Println(p.Name,"wins the game")
			} else {
				fmt.Println(p.Name, "rolled a", move, "and moved from", p.Position, "to", nextCell)
				players[ind].Position = nextCell
			}
		}
	}
	fmt.Println("Game Ends")
}
