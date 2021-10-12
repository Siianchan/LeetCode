package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/11 17:00
 * @Description:
 */
public class GetIntersectionNode {
    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
     * 如果两个链表没有交点，返回 null 。
     * 图示两个链表在节点 c1 开始相交：
     * 题目数据 保证 整个链式结构中不存在环。
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     */
    public static void main(String[] args) {
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode copyHeadA = headA;
        ListNode copyHeadB = headB;
        int a = 0;
        int b = 0;
        while (copyHeadA != null || copyHeadB != null) {
            if (copyHeadA != null) {
                a++;
                copyHeadA = copyHeadA.next;
            }
            if (copyHeadB != null) {
                b++;
                copyHeadB = copyHeadB.next;
            }
        }
        if (a != b) {
            for (int x = 0; x < Math.abs(a - b); x++) {
                if (a < b) {
                    headB = headB.next;
                } else {
                    headA = headA.next;
                }
            }
        }
        while (headA != null || headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
