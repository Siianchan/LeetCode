package main

/*200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
*/

func main() {

}
func numIslands(grid [][]byte) int {
	ret := 0
	for x := 0; x < len(grid); x++ {
		for y := 0; y < len(grid[x]); y++ {
			if grid[x][y] == '1' {
				dfs(grid, x, y)
				ret += 1
			}
		}
	}
	return ret
}
func dfs(grid [][]byte, x int, y int) {
	if grid[x][y] == '0' {
		return
	}
	grid[x][y] = '0'
	if x > 0 {
		dfs(grid, x-1, y)
	}
	if x < len(grid)-1 {
		dfs(grid, x+1, y)
	}
	if y > 0 {
		dfs(grid, x, y-1)
	}
	if y < len(grid[x])-1 {
		dfs(grid, x, y+1)
	}
}
