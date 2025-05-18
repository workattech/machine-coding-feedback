package entity

import (
	"log"
	user "trello/internal/User"
)

const (
	urlPrefix = "https://ayush.trello.com/boards/"
)

type Board struct {
	Entity
	Privacy string
	Url     string
	Members map[string]*user.User
}

func CreateBoard(id, name, privacy string) *Board {
	if privacy == "" {
		privacy = "PRIVATE"
	}
	return &Board{
		Entity: Entity{
			Id:               id,
			Name:             name,
			ChildrenEntities: make(map[string]IEntity),
		},
		Privacy: privacy,
		Members: make(map[string]*user.User),
		Url:     urlPrefix + id,
	}
}

func (b *Board) Update(updateType string, name string, privacy string, member *user.User) {
	switch updateType {
	case "PRIVACY":
		b.Privacy = privacy
		break
	case "NAME":
		b.Name = name
		break
	case "ADD_MEMBER":
		if member != nil {
			b.AddMember(member)
		}
		break
	case "REMOVE_MEMBER":
		if member != nil {
			b.RemoveMember(member)
		}
		break
	}
}

func (b *Board) AddMember(member *user.User) {
	if _, ok := b.Members[member.Id]; ok {
		log.Println("BOARD AddMember user " + member.Id + " already exists in board " + b.Id)
		return
	}
	b.Members[member.Id] = member
}
func (b *Board) RemoveMember(member *user.User) {
	if _, ok := b.Members[member.Id]; !ok {
		log.Println("BOARD RemoveMember user " + member.Id + " does not exist in board " + b.Id)
		return
	}
	delete(b.Members, member.Id)
}

func (b *Board) AddChildEntity(childEntity IEntity) {
	if childEntity.GetType() == "LIST" || childEntity.GetType() == "CARD" {
		b.ChildrenEntities[childEntity.GetId()] = childEntity
	}
}
func (b *Board) RemoveChildEntity(childEntity IEntity) {
	delete(b.ChildrenEntities, childEntity.GetId())
}

func (b *Board) AddParent(newParent IEntity) {
	log.Println("Board Cannot have a parent")
}

func (b *Board) Show() {
	log.Printf("BOARD :: id - %s, name - %s, privace - %s", b.Id, b.Name, b.Privacy)
	if len(b.Members) > 0 {
		log.Println("Members of this board:")
		for _, v := range b.Members {
			v.Show()
		}
	}
	if len(b.ChildrenEntities) > 0 {
		log.Printf("Entities under this board:")
		for _, v := range b.ChildrenEntities {
			v.Show()
		}
	}
}

func (b *Board) Destroy() {
	for k, v := range b.ChildrenEntities {
		v.Destroy()
		delete(b.ChildrenEntities, k)
	}
}

func (c *Board) GetType() string {
	return "BOARD"
}
