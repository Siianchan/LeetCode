package main

/*
199. 二叉树的右视图
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
输入: [1,2,3,null,5,null,4]
输出: [1,3,4]*/

import (
	"container/list"
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	rightSideView(nil)
}

func rightSideView(root *TreeNode) []int {
	if root == nil {
		return nil
	}
	queue := list.New()
	fmt.Println(queue == nil)
	var ret []int
	queue.PushBack(root)
	for queue.Len() > 0 {
		arr := queue.Len()
		a := 1
		for i := 0; i < arr; i++ {
			node := queue.Remove(queue.Front()).(*TreeNode)
			if node.Left != nil {
				queue.PushBack(node.Left)
			}
			if node.Right != nil {
				queue.PushBack(node.Right)
			}
			a = node.Val
		}
		ret = append(ret, a)
	}
	return ret
}
