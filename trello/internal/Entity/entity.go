package entity

type Entity struct {
	Id               string
	Name             string
	Parent           IEntity
	ChildrenEntities map[string]IEntity
}

func (e *Entity) GetId() string {
	return e.Id
}

func (e *Entity) GetParent() IEntity {
	return e.Parent
}

type IEntity interface {
	GetId() string
	Show()
	Destroy()
	GetType() string
	GetParent() IEntity
	AddChildEntity(entity IEntity)
	RemoveChildEntity(entity IEntity)
	AddParent(parentEntity IEntity)
}
