package main

import "fmt"

/*给你一个字符串 s，找到 s 中最长的回文子串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。*/

func main() {
	fmt.Println(longestPalindrome("abbd"))
}

func longestPalindrome(s string) string {
	var left, right int
	for i := 0; i < len(s)-1; i++ {
		j1, j2 := strDfs(s, i, i)
		o1, o2 := strDfs(s, i, i+1)
		if o2-o1 > j2-j1 {
			j2 = o2
			j1 = o1
		}
		if j2-j1 > right-left {
			left = j1
			right = j2
		}
	}
	return s[left : right+1]
}
func strDfs(s string, a int, b int) (int, int) {
	for a >= 0 && b < len(s) && s[a] == s[b] {
		a--
		b++
	}
	return a + 1, b - 1
}
