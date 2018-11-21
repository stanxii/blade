// 利用快排算法的partition函数实现O(n)时间复杂度求数组中第k小的数，golang版本。

package main

import "fmt"

func partition(a []int, left, right int) int {
	low, up := left+1, right
	x := a[left]
	for {
		for a[low] < x && low < up {
			low++
		}
		for a[up] > x {
			up--
		}
		if low >= up {
			break
		}
		a[low], a[up] = a[up], a[low]
	}
	a[left], a[up] = a[up], a[left]
	return up
}
func getTopK(a []int, k int) int {
	if k < 1 || k > len(a) {
		return -1
	}
	k = len(a) - k
	low, up, index := 0, len(a)-1, 0
	for index != k {
		if index < k {
			low = index + 1
		} else {
			up = index - 1
		}
		index = partition(a, low, up)
	}
	return a[index]
}
func main() {
	a := []int{29, 22, 33, 6, 77, 99, 88, 250, 100}
	k := 3
	fmt.Println("top k:", k, "value:", getTopK(a, k))
}
