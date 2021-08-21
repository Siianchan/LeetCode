package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/21 16:54
 * @Description:
 */
public class Partition {
    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
     * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     */

    public static void main(String[] args) {
        ListNode st = new ListNode(0);
        ListNode first = st;
        for (int x = 1; x <= 5; x++) {
            st.next = new ListNode(x);
            st = st.next;
        }
        Partition partition = new Partition();
        partition.partition(first, 3);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode small = new ListNode(-999);
        ListNode last = new ListNode(999);
        ListNode firstSmall = small;
        ListNode firstLast = last;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                last.next = null;
                small = small.next;
            } else {
                small.next = null;
                last.next = head;
                last = last.next;
            }
            head = head.next;
        }
        small.next = firstLast.next;
//        while (firstSmall != null) {
//            System.out.println(firstSmall.val);
//            firstSmall = firstSmall.next;
//       }
////        while (firstLast != null) {
////            System.out.println(firstLast.val);
////            firstLast = firstLast.next;
////        }
        return firstSmall.next;
    }
}
