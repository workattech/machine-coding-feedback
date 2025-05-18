package main

import (
	"log"
	"trello/internal"
	entity "trello/internal/Entity"
	user "trello/internal/User"
)

func main() {
	user1 := user.CreateUser("idASASXC", "Ayush", "ayu@gmail.com")
	user2 := user.CreateUser("idLSYDIC", "Lucy", "ayu@gmail.com")

	project := internal.CreateManager()
	project.AddUser(user1)
	project.AddUser(user2)

	board1 := entity.CreateBoard("idBOARD2323", "INTERVIEW PREP", "PRIVATE")
	board2 := entity.CreateBoard("idBOARD3454", "HOUSEHOLD", "PUBLIC")

	list1 := entity.CreateList("idLIST2334", "BINARY TREE QUES")
	list2 := entity.CreateList("idLIST4564", "DP QUES")

	card1 := entity.CreateCard("idCARD2323", "Is This tree perfect?", "For a given tree, check if it is perfect : Google the meaning", nil)
	card2 := entity.CreateCard("idCARD4322", "Print inorder traversal", "For a given tree,  print the values in inorder traversal", user1)

	card3 := entity.CreateCard("idCARDe5w4", "LCS", "Find the Longest common subsequence in the given string", user2)

	// list3 := entity.CreateList("idLIST4564", "Groceries to buy")

	card4 := entity.CreateCard("idCARD8978", "Aloo", "buy Aloo macha", user1)
	// card5 := entity.CreateCard("idCARD8978", "Jeera", "buy Jeera macha", user2)

	project.AddEntity(board1)
	project.ShowEntitites(board1.Id)
	log.Println("1-------------")

	project.UpdateBoard(board1.Id, "NAME", "Google Crack!", "", nil)
	project.UpdateBoard(board1.Id, "PRIVACY", "", "PUBLIC", nil)

	project.ShowEntitites(board1.Id)
	log.Println("2-------------")

	project.AddEntity(board2)

	project.UpdateBoard(board1.Id, "ADD_MEMBER", "", "", user1)
	project.UpdateBoard(board1.Id, "ADD_MEMBER", "", "", user2)

	project.UpdateBoard(board1.Id, "REMOVE_MEMBER", "", "", user2)

	project.ShowEntitites(board1.Id)
	log.Println("3-------------")

	project.ShowEntitites("")
	log.Println("4-------------")

	project.AddEntity(list1)
	project.ShowEntitites(list1.Id)
	log.Println("5-------------")

	project.AddEntity(list2)

	project.ShowEntitites(board2.Id)
	log.Println("6-------------")

	project.AddEntity(card1)
	project.AddEntity(card2)
	project.AddEntity(card3)
	project.AddEntity(card4)
	project.AddEntity(card4)

	project.AddChildToEntity(list1.Id, card1.Id)
	project.AddChildToEntity(list1.Id, card2.Id)

	project.AddChildToEntity(board1.Id, list1.Id)

	project.ShowEntitites(list1.Id)
	log.Println("7-------------")

	project.AddParentToEntity(list2.Id, card1.Id)

	project.ShowEntitites(list1.Id)
	log.Println("8-------------")
	project.ShowEntitites(list2.Id)
	log.Println("9-------------")

	project.ShowEntitites("")
	log.Println("10-------------")

}
