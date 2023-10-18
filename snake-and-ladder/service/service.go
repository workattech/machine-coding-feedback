package service

import (
	"math/rand"

	"github.com/shani34/machine-coding-feedback/snake-and-ladder/models"
)
func GenerateRandomNumber()int{
	return rand.Intn(6)
}

func ValidateSnake(start , end int)bool{
	if(start<=end || start>=100 || end<=0){
		return false
	}
	return true
}

func ValidateLadder(start,end int)bool{
    if(start>=end || start<=0 || end>=100){
		return false
	}
	return true;
}

func StartGame(users models.Users, ladder map[int]int, snakes map[int]int)string{
	score:=make(map[string]int);
	winner:=false
	winnerName:=""

	//running infity loop 
	for{
		for i:=0;i<len(users); i++{

			v,ok:=score[users[i]]
			if ok{
				userScore:=v+GenerateRandomNumber()
				if userScore<=100{
				score[users[i]]=userScore;
				}

				//handle the ladder 
				if newValue,okladder:=ladder[userScore]; okladder{
					score[users[i]]=newValue
				}
				//handle the snake
				if newValue,okladder:=snakes[userScore]; okladder{
					score[users[i]]=newValue
				}
			}else{
				score[users[i]]=0;
			}
			if(v+GenerateRandomNumber()==100){
				winner=true
				winnerName=users[i]
				break
			}
		}

		if winner{
			break
		}
	}

	return winnerName
}
