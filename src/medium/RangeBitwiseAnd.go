package main

/*给你两个整数 left 和 right ，表示区间 [left, right] ，
返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
示例 1：
输入：left = 5, right = 7
输出：4*/

func main() {

}
func rangeBitwiseAnd(left int, right int) int {
	shift := 0
	for left < right {
		left, right = left>>1, right>>1
		shift++
	}
	return left << shift

}
