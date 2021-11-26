package main

import "fmt"

/*地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，
因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？*/

func main() {
	fmt.Println(movingCount(16, 18, 9))
}

func movingCount(m int, n int, k int) int {
	var maxRet int
	arr := make([][]int, m)
	for i := 0; i < m; i++ {
		arr[i] = make([]int, n)
	}
	var check func(int, int) bool
	check = func(x int, y int) bool {
		sum := 0
		for ; x > 0; x /= 10 {
			sum += x % 10
		}
		for ; y > 0; y /= 10 {
			sum += y % 10
		}
		if sum > k {
			return false
		}
		return true
	}
	var dfs func([][]int, int, int)
	dfs = func(i [][]int, x int, y int) {
		if i[x][y] == 0 {
			i[x][y] = 1
			maxRet++
		} else {
			return
		}
		if y+1 < len(i[0]) && check(x, y+1) {
			dfs(i, x, y+1)
		}
		if x+1 < len(i) && check(x+1, y) {
			dfs(i, x+1, y)
		}
	}
	dfs(arr, 0, 0)
	return maxRet
}
