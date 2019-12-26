package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-26 17:36
 * @Description:
 */
public class SwapPairs {
    /**
     * 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public static void main(String args[]) {
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //新建一个链表
        ListNode node = new ListNode(-1);
        //最终返回的链表
        ListNode res = node;
        while (head != null && head.next != null) {
            //1 2 3 4
            //交换两个链表链接顺序
            //将res的下一个节点指向2
            node.next = head.next;
            //将head的下一个节点3
            head.next = head.next.next;
            //将node的下一个节点的下一个节点指向1
            node.next.next = head;
            //最后变成的顺序： res -> 2 -> 1 ->3

            //进入下一轮循环
            node = node.next.next;
            head = head.next;
        }
        return res.next;
    }
}
