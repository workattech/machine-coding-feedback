package main

import (
	"fmt"

	"github.com/shani34/machine-coding-feedback/snake-and-ladder/models"
	"github.com/shani34/machine-coding-feedback/snake-and-ladder/service"
)


func main(){
	fmt.Println("Enter number of snakes:")
	var snakes int;
	fmt.Scan(&snakes)
	SnakeMap:=make(map[int]int)

	for snakes>0{
		snakes--
		var start, end int
		fmt.Scanf("%v %v", &start,&end)
		//validating snakes
		if service.ValidateSnake(start,end){
			SnakeMap[start]=end
		}else{
			return
		}
	}

	fmt.Println("Enter number of ladders:")
	var ladder int;
	fmt.Scan(&ladder)
	ladderMap:=make(map[int]int)
	for ladder>0{
		ladder--
		var start, end int
		fmt.Scanf("%v %v", &start,&end)

		//validating ladder
		if service.ValidateLadder(start,end){
			ladderMap[start]=end
		}else{
			return
		}
	}

	var(
		 user string;
		numberOfUsers int
		users models.Users
	)

	fmt.Scanf("Enter the Number of Player :%v",&numberOfUsers)

	for numberOfUsers>0{
		numberOfUsers--
		fmt.Scan(&user)
		users=append(users, user)
	}

	winner:=service.StartGame(users,ladderMap,SnakeMap)
	fmt.Println(winner)

}