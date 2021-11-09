package main

/*给你两个整数 left 和 right ，表示区间 [left, right] ，
返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
示例 1：
输入：left = 5, right = 7
输出：4*/

func main() {
}
func rangeBitwiseAnd(left int, right int) int {
	/*我们观察按位与运算的性质。对于一系列的位，例如 [1, 1, 0, 1, 1][1,1,0,1,1]，
	只要有一个零值的位，那么这一系列位的按位与运算结果都将为零。*/
	shift := 0
	for left < right {
		left, right = left>>1, right>>1
		shift++
	}
	return left << shift

}
