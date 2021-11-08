package main

import (
	"fmt"
	"time"
)

func main() {
	a := time.Now().UnixNano() / 1e6
	fmt.Println(countPrimes2(10000000))
	fmt.Println(time.Now().UnixNano()/1e6 - a)
}

func countPrimes(n int) int {
	//查找小于n的质数，枚举法（大数后边会超时）
	ret := 1
	for i := 3; i < n; i += 2 {
		if i >= 10 && i%3 == 0 && i%5 == 0 && i%7 == 0 {
			continue
		}
		for j := 2; j < i/2+1; j++ {
			if i%j == 0 {
				ret--
				break
			}
		}
		ret++
	}
	if n <= 2 {
		return 0
	}
	return ret
}

func countPrimes2(n int) int {
	//查找小于n的质数，埃氏筛 1亿素数大概1.3秒，10亿15秒
	ret := 0
	//创建一个数组，大小等于n,false代表是质数，true代表不是质数
	arr := make([]bool, n)
	for x := 2; x < n; x++ {
		if !arr[x] {
			//从2开始，如果是false说明是质数，计数+1
			ret++
			for y := x * x; y < n; y += x {
				//从x*x开始筛，因为2x已经被前面的筛过了
				//将质数的倍数所在的数组位全部改为true
				arr[y] = true
			}
		}
	}
	return ret
}

func countPrimes3(n int) int {

	//查找小于n的质数，线性筛，1亿素数大概1.7秒，10亿14秒
	//创建一个数组，大小等于n,false代表是质数，true代表不是质数
	arr := make([]bool, n)
	//创建一个素数表
	var su []int
	for x := 2; x < n; x++ {
		if !arr[x] {
			su = append(su, x)
		}
		for _, i := range su {
			if i*x >= n {
				break
			}
			arr[i*x] = true
			if x%i == 0 {
				break
			}
		}
	}
	return len(su)
}
