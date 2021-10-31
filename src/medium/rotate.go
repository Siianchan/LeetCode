package main

/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
进阶：
尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
示例 1:
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
*/

func main() {
	arr := []int{1, 2, 3, 4, 5, 6, 7}
	rotate(arr, 7)
}

func rotate(nums []int, k int) {
	ew := make([]int, k)
	l := len(nums)
	k %= l
	if k == 0 {
		return
	}
	for i := 0; i < k; i++ {
		ew[i] = nums[l-k+i]
	}
	for i := l - 1; i >= k; i-- {
		nums[i] = nums[i-k]
	}
	for i := 0; i < k; i++ {
		nums[i] = ew[i]
	}
	//for i := 0; i < l; i++ {
	//	fmt.Print(nums[i], " ")
	//}
}
