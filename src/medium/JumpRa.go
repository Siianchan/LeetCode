package main

import "fmt"

//有三种跳法，往前跳一格，往后跳一格，跳两倍
//求去y点最少需要跳多少次
func main() {
	JumpRa(20)
}

func JumpRa(y int) {
	dp := make([]int, y+1)
	dp[1] = 1 //
	for i := 2; i <= y; i++ {
		if i%2 == 0 {
			dp[i] = dp[i/2] + 1 //如果是偶数，直接等于i/2跳过来，在i/2的步数上+1
		} else {
			//[0 1 2 3 3 4 4 5 4 5 5 6 5 6 6 6 5]
			//如果是奇数，假如是7，看是3次数少还是4次数少 3跳两倍过来+1,再往前跳再+1，和4跳两倍回退1是一样的，所以全部+2
			dp[i] = Min(dp[i/2], dp[(i+1)/2]) + 2
		}
	}
	fmt.Println(dp)
}

func Min(i int, j int) int {
	if i > j {
		return j
	}
	return i
}
