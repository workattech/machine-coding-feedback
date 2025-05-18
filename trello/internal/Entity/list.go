package entity

import "log"

type List struct {
	Entity
}

func CreateList(id string, name string) *List {
	return &List{
		Entity: Entity{
			Id:               id,
			Name:             name,
			ChildrenEntities: make(map[string]IEntity),
		},
	}
}
func (l *List) Show() {
	log.Printf("LIST :: id - %s, name - %s", l.Id, l.Name)
	if len(l.ChildrenEntities) > 0 {
		log.Printf("Cards under this list:")
		for _, v := range l.ChildrenEntities {
			v.Show()
		}
	}
}

func (l *List) AddChildEntity(childEntity IEntity) {
	if childEntity.GetType() == "CARD" {
		l.ChildrenEntities[childEntity.GetId()] = childEntity
	}
}

func (l *List) RemoveChildEntity(childEntity IEntity) {
	delete(l.ChildrenEntities, childEntity.GetId())
}

func (l *List) AddParent(newParent IEntity) {
	if newParent.GetType() != "BOARD" {
		log.Println("List cannot have a parent other than BOARD")
		return
	}
	l.Parent = newParent
}

func (l *List) Update(updateType string, name string) {
	if updateType == "NAME" {
		l.Name = name
	}
}

func (l *List) Destroy() {
	for k, v := range l.ChildrenEntities {
		v.Destroy()
		delete(l.ChildrenEntities, k)
	}
}

func (c *List) GetType() string {
	return "LIST"
}
