package internal

import (
	"fmt"
	entity "trello/internal/Entity"
	user "trello/internal/User"
)

type ProjectManager struct {
	currentId int
	Users     map[string]*user.User
	Entities  map[string]entity.IEntity
}

func CreateManager() *ProjectManager {
	return &ProjectManager{
		currentId: 0,
		Users:     make(map[string]*user.User),
		Entities:  make(map[string]entity.IEntity),
	}
}

func (pm *ProjectManager) AddUser(user *user.User) {
	pm.Users[user.Id] = user
}

func (pm *ProjectManager) AddEntity(projectEntity entity.IEntity) {
	pm.Entities[projectEntity.GetId()] = projectEntity
}

func (pm *ProjectManager) DeleteEntity(id string) {
	deletedEntity := pm.Entities[id]
	deletedEntity.Destroy()
	delete(pm.Entities, id)
}

func (pm *ProjectManager) AddParentToEntity(parentId string, childId string) {
	parentEntity := pm.Entities[parentId]
	childEntity := pm.Entities[childId]
	previousParent := childEntity.GetParent()
	if previousParent != nil {
		previousParent.RemoveChildEntity(childEntity)
	}
	childEntity.AddParent(parentEntity)
}

func (pm *ProjectManager) AddChildToEntity(parentId string, childId string) {
	parentEntity := pm.Entities[parentId]
	childEntity := pm.Entities[childId]
	parentEntity.AddChildEntity(childEntity)
	pm.AddParentToEntity(parentId, childId)
}

func (pm *ProjectManager) ShowEntitites(id string) {

	if id == "" {
		for _, v := range pm.Entities {
			v.Show()
		}
	} else {
		entityToShow := pm.Entities[id]
		entityToShow.Show()
	}
}

func (pm *ProjectManager) UpdateBoard(id string, updateType string, name string, privacy string, member *user.User) {
	board := pm.Entities[id].(*entity.Board)
	board.Update(updateType, name, privacy, member)
}

func (pm *ProjectManager) UpdateList(id string, updateType string, name string) {
	list := pm.Entities[id].(*entity.List)
	list.Update(updateType, name)
}

func (pm *ProjectManager) UpdateCard(id string, updateType string, name string, desc string, assignee *user.User) {
	card := pm.Entities[id].(*entity.Card)
	card.Update(updateType, name, desc, assignee)
}

func (pm *ProjectManager) GenerateUniqueId() string {
	pm.currentId++
	return fmt.Sprintf("%v", pm.currentId)
}
