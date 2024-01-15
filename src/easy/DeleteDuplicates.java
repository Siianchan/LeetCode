package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/21 16:19
 * @Description:
 */
public class DeleteDuplicates {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode first = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
            if (head == null) {
                break;
            }
        }
        return first;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        // 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode first = pre;
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val != pre.next.next.val) {
                pre = pre.next;
            } else {
                int x = pre.next.val;
                while (pre.next != null && pre.next.val == x) {
                    pre.next = pre.next.next;
                }
            }
        }
        return first.next;
    }
}
