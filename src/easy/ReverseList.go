package main

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

func main() {

}
func reverseList(head *ListNode) *ListNode {
	//1 2 3 4 5
	var pre *ListNode = nil
	var tmp *ListNode
	for head != nil {
		tmp = head.Next //2
		head.Next = pre // nil
		pre = head      // 1
		head = tmp      // 2
	}
	return pre
}
