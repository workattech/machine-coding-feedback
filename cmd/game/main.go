package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"strconv"
	"strings"
	"github.com/Piyushh1/mock-machine-coding-1/internal/app/game"
)

var (
	gameManager      game.Manager
	data string
)

func main() {
	setup()
	run()
	cleanup()
}

func setup() {
	if len(os.Args) < 2 {
		fmt.Println("Missing parameter, provide file name!")
		os.Exit(1)
	}
	var err error
	filecontent, err := ioutil.ReadFile(os.Args[1])
	if err != nil {
		fmt.Println("Can't read file:", os.Args[1])
		os.Exit(1)
	}

	data = string(filecontent)

	//Initialize Manager
	gameManager = game.NewManager()

	// Note: The way input is taken can be improved.File input is supported for now.
	input := strings.Split(data, "\n")
	numberOfSnake, err := strconv.Atoi(input[0])
	if err != nil {
		log.Fatal(fmt.Errorf("invalid command"))
	}
	i := 1

	for ; i <= numberOfSnake; i++ {
		cells := strings.Split(input[i], " ")
		gameManager.InitSnakes(cells[0], cells[1])
	}

	numberOfLadder, _ := strconv.Atoi(input[i])
	iterator := i + numberOfLadder

	for i = i+1; i <= iterator; i++ {
		cells := strings.Split(input[i], " ")
		gameManager.InitLadder(cells[0], cells[1])
	}

	numberOfPlayer, _ := strconv.Atoi(input[i])

	iterator = i + numberOfPlayer
	for i = i+1; i <= iterator; i++ {
		cells := strings.Split(input[i], " ")
		gameManager.InitPlayers(cells[0])
	}
}

func run() {
	gameManager.StartGame()
}


func cleanup() {
}
