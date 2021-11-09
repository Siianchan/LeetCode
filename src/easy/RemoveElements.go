package main

//给你一个链表的头节点 head 和一个整数 val ，
//请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {

}
func removeElements(head *ListNode, val int) *ListNode {
	for head != nil && head.Val == val {
		//查看头部节点是否等于给出的数字
		//如果是就直接删除掉
		head = head.Next
	}
	//返回的头部节点
	first := head
	for head != nil && head.Next != nil {
		if head.Next.Val == val {
			//删除等于给出数字的节点
			head.Next = head.Next.Next
		} else {
			head = head.Next
		}
	}
	return first
}
