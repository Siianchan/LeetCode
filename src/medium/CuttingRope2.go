package main

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
//每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
//例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

func main() {
	cuttingRope2(2)
}
func cuttingRope2(n int) int {
	if n < 5 {
		if n == 4 {
			return n
		}
		return n - 1
	}
	x := 0
	//贪心算法，大于5的，尽可能用3取，直到剩余4
	for ; n > 4; n -= 3 {
		x++
	}
	mod := int(1e9 + 7)
	sum := Pow(3, x) * n
	return sum % mod
}
func Pow(a int, b int) int {
	sum := a
	if b == 0 {
		return 1
	}
	for i := 1; i < b; i++ {
		sum *= a
		sum %= 1e9 + 7
	}
	return sum
}
