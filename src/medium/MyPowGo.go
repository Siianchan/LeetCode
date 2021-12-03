package main

import (
	"fmt"
	"math"
)

func main() {
	myPow(2.0, -2)
}

func myPow(x float64, n int) float64 {
	c := math.Pow(x, float64(n))
	fmt.Println(c)
	return c
}
