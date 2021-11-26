package main

import "fmt"

/*给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
示例 1：
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1*/

func main() {
	//fmt.Println(pow(2, 2))
	fmt.Println(cuttingRope(60))
}
func cuttingRope(n int) int {
	//题解，初步判断大于4的数，最大乘积都由2和3组成，因为10 =  3 × 3 × 4 =
	//和3*3*2*2是一样的，而且乘一个大数肯定不如分开来乘更大，比如2*5就没有2*2*3大
	if n < 4 {
		return n - 1
	}
	max := 0
	for x := 0; ; x++ {
		if 2*x > n {
			break
		}
		for y := 0; ; y++ {
			if 2*x+3*y == n {
				num1 := pow(2, x)
				num2 := pow(3, y)
				if num1*num2 > max {
					max = num1 * num2
				}
				break
			}
			if 2*x+3*y > n {
				break
			}
		}
	}
	return max
}

func pow(a int, b int) int {
	sum := a
	if b == 0 {
		return 1
	}
	for i := 1; i < b; i++ {
		sum *= a
	}
	return sum
}
