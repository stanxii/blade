// 求二叉树最长路径

package main
import "fmt"

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

var max int

func maxDistance(root *TreeNode) int {
	if root.Left == nil && root.Right == nil {
		return 0
	}
	var leftMaxLen, rightMaxLen, maxLen int
	if root.Left != nil {
		leftMaxLen = maxDistance(root.Left) + 1
	}
	if root.Right != nil {
		rightMaxLen = maxDistance(root.Right) + 1
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

func maxPathSum(root *TreeNode) int {
	val := root.val
	if root.Left == nil && root.Right == nil {
		return val
	}
	var leftMaxLen, rightMaxLen, maxLen int
	if root.Left != nil {
		leftMaxLen = maxPathSum(root.Left) + val
	}
	if root.Right != nil {
		rightMaxLen = maxPathSum(root.Right) + val
	}
	maxSumLen := leftMaxLen + rightMaxLen - val
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
