// https://leetcode.com/problems/diameter-of-binary-tree/
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func diameterOfBinaryTree(root *TreeNode) int {
	if root == nil {
		return 0
	}
	var max int

	var maxPathDistance func(*TreeNode) int
	maxPathDistance = func(root *TreeNode) int {
		if root.Left == nil && root.Right == nil {
			return 0
		}
		var leftMaxLen, rightMaxLen, maxLen int
		if root.Left != nil {
			leftMaxLen = maxPathDistance(root.Left) + 1
		}
		if root.Right != nil {
			rightMaxLen = maxPathDistance(root.Right) + 1
		}
		maxSumLen := leftMaxLen + rightMaxLen
		if maxSumLen > max {
			max = maxSumLen
		}
		if leftMaxLen > rightMaxLen {
			maxLen = leftMaxLen
		} else {
			maxLen = rightMaxLen
		}
		return maxLen
	}
	maxPathDistance(root)
	return max
}
