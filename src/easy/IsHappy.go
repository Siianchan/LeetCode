package main

/*编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果 可以变为  1，那么这个数就是快乐数。
如果 n 是快乐数就返回 true ；不是，则返回 false 。*/

func main() {
	isHappy(116)
}
func isHappy(n int) bool {
	jiLu := make(map[int]bool) //哈希表记录已循环过的数字
	for n != 1 && !jiLu[n] {   //当和等于1或者开始循环后就退出循环
		jiLu[n] = true
		newInt := 0
		for n > 0 {
			num := n % 10
			newInt += num * num
			n /= 10
		}
		n = newInt
	}
	if n == 1 {
		return true
	}
	return false
}
