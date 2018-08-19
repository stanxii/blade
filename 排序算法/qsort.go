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

func quickSort(a []int, left, right int) {
	if left < right {
		mid := partition(a, left, right)
		quickSort(a, left, mid-1)
		quickSort(a, mid+1, right)
	}
}

func main() {
	a := []int{29, 22, 33, 6, 77, 99, 88, 250, 100}
	fmt.Println("before: ", a)
	quickSort(a, 0, len(a)-1)
	fmt.Println("after: ", a)
}
