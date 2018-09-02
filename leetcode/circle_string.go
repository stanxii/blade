package main

import "fmt"

func isCircleString(stringList []string) bool {
	first, last := make(map[string]int), make(map[string]int)
	var same []string
	for _, str := range stringList {
		firstChar := string(str[0])
		lastChar := string(str[len(str)-1])
		if firstChar == lastChar {
			same = append(same, firstChar)
			continue
		}
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
	flag := true
	for k, v := range first {
		if val, ok := last[k]; !ok {
			flag = false
			break
		} else if v != val {
			flag = false
			break
		}
	}
	if flag {
		for _, key := range same {
			if _, ok := first[key]; !ok {
				flag = false
			}
		}
	}
	return flag
}

func main() {
	stringList := []string{"grep", "pip", "echo", "open", "net", "tag", "pre"}
	// stringList := []string{"ab", "ba", "cc"}
	fmt.Println(isCircleString(stringList))
}
