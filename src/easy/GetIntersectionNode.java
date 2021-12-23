package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/23 14:56
 * @Description:
 */
public class GetIntersectionNode {

    /**
     * 输入两个链表，找出它们的第一个公共节点。
     * 如下面的两个链表：
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     */

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aNum = 0;
        int bNum = 0;
        ListNode fa = headA;
        ListNode fb = headB;
        while (fa != null || fb != null) {
            if (fa != null) {
                aNum++;
                fa = fa.next;
            }
            if (fb != null) {
                bNum++;
                fb = fb.next;
            }
        }
        if (aNum >= bNum) {
            for (int x = 0; x < (aNum - bNum); x++) {
                headA = headA.next;
            }
        } else {
            for (int x = 0; x < (bNum - aNum); x++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
