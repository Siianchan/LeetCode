package main

import "fmt"

/*给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
示例 1:
输入：s = "egg", t = "add"
输出：true*/

func main() {
	fmt.Println(isIsomorphic("abc", "cde"))
}
func isIsomorphic(s string, t string) bool {
	var sint [256]int
	var tint [256]int
	for i := 0; i < len(s); i++ {
		if sint[s[i]] != tint[t[i]] { //查看该字符上一次出现的位置是否相等
			return false
		} else {
			sint[s[i]] = i + 1 //记录该字符最后一次出现的位置
			tint[t[i]] = i + 1 //
		}
	}
	return true
}
