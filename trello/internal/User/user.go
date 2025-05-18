package user

import "log"

type User struct {
	Id    string
	Name  string
	Email string
}

func CreateUser(id, name, email string) *User {
	return &User{
		Id:    id,
		Name:  name,
		Email: email,
	}
}

func (u *User) Show() {
	log.Printf("User :: Id - %s, Name - %s, Email - %s", u.Id, u.Name, u.Email)
}
