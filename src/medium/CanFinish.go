package main

import "fmt"

/*你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
*/

var res []int

func main() {
	pre := [][]int{{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}
	fmt.Println(canFinish(7, pre))
}

func canFinish(numCourses int, prerequisites [][]int) bool {
	if len(prerequisites) <= 0 {
		return true
	}
	co := make(map[int][]int)
	for i := 0; i < len(prerequisites); i++ {
		k := prerequisites[i][0]
		v := prerequisites[i][1]
		if co[k] == nil {
			co[k] = make([]int, 0)
		}
		co[k] = append(co[k], v)
	}
	res = make([]int, numCourses)
	for i := 0; i < numCourses; i++ {
		val := make([]int, numCourses)
		if val[i] == 0 {
			if !canDfs(val, i, co) {
				return false
			}
		}
	}
	return true
}
func canDfs(val []int, i int, m map[int][]int) bool {
	if val[i] == 1 && res[i] != 1 {
		//如果已访问，并且这个数不是已确定的无循环数，说明已进入循环
		return false
	}
	val[i] = 1
	if m[i] == nil {
		res[i] = 1
		return true
	}
	for x := 0; x < len(m[i]); x++ {
		if res[m[i][x]] != 1 {
			if !canDfs(val, m[i][x], m) {
				return false
			} else {
				res[m[i][x]] = 1
			}
		}
	}
	return true
}
