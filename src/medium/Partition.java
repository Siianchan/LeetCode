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
        partition.partition2(first, 3);
    }

    public ListNode partition2(ListNode head, int x) {
        if (head == null) return null;
        ListNode big = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode firstS = small;
        ListNode firstB = big;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        //防止链表循环，要将尾节点变成空
        big.next = null;
        small.next = firstB.next;
        return firstS.next;
    }

}
