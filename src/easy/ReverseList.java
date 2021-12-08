package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/8 13:05
 * @Description:
 */

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;//创建一个临时节点保存下一个
            curr.next = prev;//将原来的下一个节点指到上一个节点
            prev = curr;//将上一个节点指向当前节点
            curr = next;//将当前节点指向下一个节点
        }
        return prev;
    }
}
