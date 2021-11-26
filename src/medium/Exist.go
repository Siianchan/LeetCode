package main

import "fmt"

/*给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
*/
func main() {
	board := make([][]byte, 0)
	board = append(board, []byte{'A', 'B', 'C', 'E'})
	board = append(board, []byte{'S', 'F', 'C', 'S'})
	board = append(board, []byte{'A', 'D', 'E', 'E'})
	//board = append(board, []byte{'A', 'A'})
	//board = append(board, []byte{'A', 'A'})
	//board = append(board, []byte{'A', 'A'})
	//fmt.Println(exist(board, "AAAAAAAAA"))
	fmt.Println(exist(board, "ABCCE"))
}

var fx = [4][2]int{
	{0, 1},
	{0, -1},
	{1, 0},
	{-1, 0},
}

func exist(board [][]byte, word string) bool {
	for x := 0; x < len(board); x++ {
		for y := 0; y < len(board[x]); y++ {
			if word[0] == board[x][y] {
				if Edfs(1, x, y, board, word) {
					return true
				}
			}
		}
	}
	return false
}

func Edfs(num int, x int, y int, board [][]byte, word string) bool {
	if num >= len(word) {
		return true
	}
	for i := 0; i < len(fx); i++ {
		if x+fx[i][0] >= 0 && x+fx[i][0] < len(board) && y+fx[i][1] >= 0 && y+fx[i][1] < len(board[0]) && board[x+fx[i][0]][y+fx[i][1]] == word[num] {
			ch := board[x][y]
			board[x][y] = ' '
			if Edfs(num+1, x+fx[i][0], y+fx[i][1], board, word) {
				return true
			}
			board[x][y] = ch
		}
	}
	return false
}
