package main

import "fmt"

// 求最大连续子数组和
func maxSubArray(arr []int) int {
	currSum := 0
	maxSum := arr[0]

	for _, v := range arr {
		if currSum > 0 {
			currSum += v
		} else {
			currSum = v
		}
		if maxSum < currSum {
			maxSum = currSum
		}
	}
	return maxSum
}

func main() {
	arr := []int{3, -1 , 7, -2, -3, 6, 4}
	fmt.Println(maxSubArray(arr))
}
