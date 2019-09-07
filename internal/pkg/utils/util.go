package utils

import "math/rand"

// should be configurable
const dice  = 1

func GenerateRandomMove() int {
	return rand.Intn(dice * 6 - 1) + 1
}
