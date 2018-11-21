/*
    给定一个数，找到数组中相加等于给定数值的两个数，golang实现。
*/
package main

import "fmt"

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		temp := target - v
		if value, ok := m[temp]; ok {
			result := []int{value, i}
			return result
		}
		m[v] = i
	}
	return nil
}
func main() {
	arr := []int{3, 5, 1, 9, 18, 7, 11}
	fmt.Println(twoSum(arr, 18))
}
