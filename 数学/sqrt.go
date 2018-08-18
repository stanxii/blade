package main

import (
	"fmt"
	"math"
)

// NewtonSqrt 牛顿迭代法求根
func NewtonSqrt(num, accuracy float64) (float64, int) {
	x := num / 2
	count := 1
	for math.Abs(x*x-num) > accuracy {
		fmt.Println(count, x)
		x = (x + num/x) / 2
		count++
	}
	return x, count
}

// BinarySqrt 二分法求根
func BinarySqrt(num, accuracy float64) (float64, int) {
	y := num / 2
	low := 0.0
	up := num
	count := 1
	for math.Abs(y*y-num) > accuracy {
		fmt.Println(count, y)
		if y*y > num {
			up = y
		} else {
			low = y
		}
		y = (low + up) / 2
		count++
	}
	return y, count
}
func main() {
	accuracy := 0.00000001
	fmt.Println("math sqrt", math.Sqrt(5))
	result, count := NewtonSqrt(5, accuracy)
	fmt.Printf("Newton sqrt: %f, number of times: %d", result, count)
	result, count = BinarySqrt(5, accuracy)
	fmt.Printf("binary sqrt: %f, number of times: %d", result, count)
}
