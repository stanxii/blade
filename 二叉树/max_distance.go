package main
import "fmt"

type TreeNode struct {
	val   int
	left  *TreeNode
	right *TreeNode
}

var max int

func maxDistance(root *TreeNode) int {
	if root.left == nil || root.right == nil {
		return 0
	}
	var leftMaxLen, rightMaxLen, maxLen int
	if root.left != nil {
		leftMaxLen = maxDistance(root.left) + 1
	}
	if root.right != nil {
		rightMaxLen = maxDistance(root.right) + 1
	}
	maxSumLen := leftMaxLen + rightMaxLen + 2
	if maxSumLen > max {
		max = maxSumLen
	}
	if leftMaxLen > rightMaxLen {
		maxLen = leftMaxLen
	}else{
		maxLen = rightMaxLen
	}
	return maxLen
}

func main() {
	node := new(TreeNode)
	maxDistance(node)
	fmt.Println(max)
}
