package medium;

import java.util.ArrayList;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/29 15:56
 * @Description:
 */
public class ReorderList {
    
    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     * L0 → L1 → … → Ln-1 → Ln 
     * 请将其重新排列后变为：
     * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(null);
    }

    public void reorderList(ListNode head) {
        ListNode l = head;
        ArrayList<ListNode> arrayList = new ArrayList();
        int a = -1;
        while (l != null) {
            //存入有序线性表
            arrayList.add(l);
            l = l.next;
            a++;
        }
        ListNode first = head;
        for (int x = 0, y = 0; x < a; x++, head = head.next) {
            if (x % 2 == 0) {
                //从结尾开始添加节点
                head.next = arrayList.get(a - y);
            } else {
                //从开头开始添加节点
                y += 1;
                head.next = arrayList.get(y);
            }
            if (x == a - 1) {
                //如果是最后一个，将节点变成null
                head.next.next = null;
            }
        }
        while (first != null) {
            System.out.println(first.val);
            first = first.next;
        }
    }
}
