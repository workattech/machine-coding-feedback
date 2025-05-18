package entity

import (
	"log"
	user "trello/internal/User"
)

type Card struct {
	Entity
	Desc     string
	Assignee *user.User
}

func CreateCard(id string, name string, desc string, assignee *user.User) *Card {
	return &Card{
		Entity: Entity{
			Name: name,
			Id:   id,
		},
		Desc:     desc,
		Assignee: assignee,
	}
}

func (c *Card) Assign(assignee *user.User) {
	c.Assignee = assignee
}

func (c *Card) Update(updateType, name, desc string, assignee *user.User) {

	switch updateType {
	case "NAME":
		c.Name = name
		break
	case "DESC":
		c.Desc = desc
		break
	case "ASSiGNEE":
		c.Assignee = assignee
		break
	}
}

func (c *Card) Show() {
	assignedTo := "No One"
	if c.Assignee != nil {
		assignedTo = c.Assignee.Name
	}
	log.Printf("CARD :: id - %s, name - %s, desc - %s, assigned to - %s", c.Id, c.Name, c.Desc, assignedTo)
}

func (c *Card) AddParent(newParent IEntity) {
	if newParent.GetType() == "BOARD" || newParent.GetType() == "LIST" {
		c.Parent = newParent
	} else {
		log.Println("Card cannot have parents other than BOARD or LIST")
	}
}

func (c *Card) AddChildEntity(childEntity IEntity) {
	log.Println("Card cannot have a child Entity")
}
func (c *Card) RemoveChildEntity(childEntity IEntity) {
	log.Println("Card cannot remove a child Entity")
}
func (c *Card) GetType() string {
	return "CARD"
}

func (c *Card) Destroy() {

}
