package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/20 15:44
 * @Description:
 */
public class DeleteDuplicates {

    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，
     * 只保留原始链表中 没有重复出现 的数字。
     * 返回同样按升序排列的结果链表。
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     */

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
