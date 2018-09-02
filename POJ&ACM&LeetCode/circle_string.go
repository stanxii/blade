package main

import "fmt"

func isCircleString(stringList []string) bool {
	first, last := make(map[string]int), make(map[string]int)
	for _, str := range stringList {
		firstChar := string(str[0])
		lastChar := string(str[len(str)-1])
		if val, ok := first[firstChar]; ok {
			first[firstChar] = val + 1
		} else {
			first[firstChar] = 1
		}
		if val, ok := last[lastChar]; ok {
			last[lastChar] = val + 1
		} else {
			last[lastChar] = 1
		}
	}
	for k, v := range first {
		if val, ok := last[k]; !ok {
			return false
		} else if v != val {
			return false
		}
	}
	return true
}

func main() {
	stringList := []string{"grep", "pip", "echo", "open", "net", "tag", "pre"}
	fmt.Println(isCircleString(stringList))
}
