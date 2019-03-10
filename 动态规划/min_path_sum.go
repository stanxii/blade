package main

func minPathSum(grid [][]int) int {
	row := len(grid)
	col := len(grid[0])
	dp := make([]int, col)
	dp[0] = grid[0][0]
	for j := 1; j < col; j++ {
		dp[j] = dp[j-1] + grid[0][j]
	}
	for i := 1; i < row; i++ {
		for j := 0; j < col; j++ {
			if j == 0 {
				dp[j] += grid[i][j]
			} else if dp[j] < dp[j-1] {
				dp[j] = dp[j] + grid[i][j]
			} else {
				dp[j] = dp[j-1] + grid[i][j]
			}
		}

	}
	return dp[col-1]
}
