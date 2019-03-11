/*
 * @lc app=leetcode id=41 lang=golang
 *
 * [41] First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (28.28%)
 * Total Accepted:    194K
 * Total Submissions: 686.1K
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array, find the smallest missing positive
 * integer.
 *
 * Example 1:
 *
 *
 * Input: [1,2,0]
 * Output: 3
 *
 *
 * Example 2:
 *
 *
 * Input: [3,4,-1,1]
 * Output: 2
 *
 *
 * Example 3:
 *
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 *
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 */
func firstMissingPositive(nums []int) int {
	arrayMap := make(map[int]bool)
	var max int
	for _, v := range nums {
		if v > max {
			max = v
		}
		if v > 0 {
			arrayMap[v] = true
		}
	}
	var res int
	for i := 1; i <= max; i++ {
		if _, ok := arrayMap[i]; !ok {
			res = i
			break
		}
	}
	if res == 0 {
		res = max + 1
	}
	return res
}