// https://leetcode.com/problems/binary-tree-maximum-path-sum/
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func maxPathSum(root *TreeNode) int {
	if root == nil {
		return 0
	}
	max := root.Val
	var preMaxPathSum func(*TreeNode) int
	preMaxPathSum = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		val := root.Val

		leftMaxLen := preMaxPathSum(root.Left)
		rightMaxLen := preMaxPathSum(root.Right)
		max = maxNum(max, maxNum(0, leftMaxLen)+maxNum(0, rightMaxLen)+val)

		return maxNum(0, maxNum(leftMaxLen, rightMaxLen)+val)
	}
	preMaxPathSum(root)

	return max
}

func maxNum(x, y int) int {
	var max int
	if x > y {
		max = x
	} else {
		max = y
	}
	return max
}