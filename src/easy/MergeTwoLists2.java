package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/8 13:25
 * @Description:
 */

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class MergeTwoLists2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum; //dum为返回的头节点,cur是用来操作的节点
        while (l1 != null && l2 != null) {//当一方链表为空时退出
            if (l1.val < l2.val) { //如果l1一直小于l2，一直添加l1
                cur.next = l1;
                l1 = l1.next;
            } else {//反之一直添加l2
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;//最后添加多余的剩余节点
        return dum.next;
    }
}
