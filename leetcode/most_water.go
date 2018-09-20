package main

import "fmt"

func maxArea(height []int) int {
	i, j, s, ms := 0, len(height)-1, 0, 0
	for i < j {
		if height[i] < height[j] {
			s = height[i] * (j - i)
			i++
		} else {
			s = height[j] * (j - i)
			j--
		}
		ms = max(s, ms)
	}
	return ms
}
func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}

func main() {
	arr := []int{7, 3, 8, 12, 5}
	fmt.Println(maxArea(arr))
}
