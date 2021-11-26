package main

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(selectTopK([]int{-1, 2, 0}, 2))
}
func findKthLargest(nums []int, k int) int {
	//快排
	Fdfs(nums, 0, len(nums)-1, k)
	return nums[k-1]
}
func Fdfs(nums []int, start int, end int, k int) {
	if start >= end {
		return
	}
	base := nums[start]
	l := start
	r := end
	for l < r {
		for l < r && nums[r] <= base {
			r--
		}
		nums[l] = nums[r]
		for l < r && nums[l] >= base {
			l++
		}
		nums[r] = nums[l]
	}
	nums[l] = base
	fmt.Println(nums)
	if l == k-1 {
		return
	}
	if l < k-1 {
		Fdfs(nums, r+1, end, k)
	} else {
		Fdfs(nums, start, l-1, k)
	}
}

func selectTopK(nums []int, k int) int {
	//选择排序
	max := math.MinInt32
	for i := 0; i < len(nums); i++ {
		max = math.MinInt32
		fmt.Println(max)
		arr := i
		for j := i; j < len(nums); j++ {
			if nums[j] >= max {
				max = nums[j]
				arr = j
			}
		}
		temp := nums[i]
		nums[i] = max
		nums[arr] = temp
		fmt.Println(arr, nums)
		if i+1 == k {
			break
		}
	}
	return nums[k-1]
}
