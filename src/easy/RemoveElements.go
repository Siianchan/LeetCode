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
	if head == nil {
		return nil
	}
	for head != nil && head.Val == val {
		head = head.Next
	}
	first := head
	for head != nil && head.Next != nil {
		if head.Next.Val == val {
			head.Next = head.Next.Next
		} else {
			head = head.Next
		}
	}
	return first
}
