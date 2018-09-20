package main

import (
	"fmt"
)

type Matrix [][]int

type LD struct {
	M          Matrix
	Rows, Cols int
}

func (ld *LD) constructMatrix() {

	ld.M = make([][]int, ld.Rows+1)

	for i := 0; i <= ld.Rows; i++ {
		ld.M[i] = make([]int, ld.Cols+1)
		if i == 0 {
			for j := 0; j < ld.Cols+1; j++ {
				ld.M[0][j] = j
			}
		}
		ld.M[i][0] = i
	}
}

func (ld *LD) setMatrix(cost, row, col int) {
	ld.M[row][col] = cost
}

func (ld *LD) getMatrix(cost, row, col int) int {
	return ld.M[row][col]
}

func PrintMatrix(m Matrix) {
	fmt.Print("col: \t ")
	for i := 0; i < len(m[0]); i++ {
		fmt.Print(i, " ")
	}

	fmt.Println()

	for i := 0; i < len(m); i++ {
		fmt.Println("row: ", i, m[i])
	}
}

func minOfThree(a, b, c int) (min int) {
	min = a
	if min > b {
		min = b
	}
	if min > c {
		min = c
	}
	return
}

func LevenshteinDistance(source, dest string) int {
	var cols, rows int = len(source), len(dest)
	if cols == 0 {
		return rows
	}
	if rows == 0 {
		return cols
	}
	var ld *LD = &LD{Rows: rows, Cols: cols}
	ld.constructMatrix()
	// PrintMatrix(ld.M)

	// step 5
	for c := 1; c <= cols; c++ {
		for r := 1; r <= rows; r++ {
			var cur_cost int = 1

			if source[c-1] == dest[r-1] {
				cur_cost = 0
			}
			// step 6
			cost := minOfThree(ld.M[r-1][c-1]+cur_cost, ld.M[r-1][c]+1, ld.M[r][c-1]+1)
			// step 7
			ld.setMatrix(cost, r, c)
		}
	}

	PrintMatrix(ld.M)

	return ld.M[rows][cols]
}