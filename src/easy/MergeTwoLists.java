package easy;


import java.util.ArrayList;
import java.util.Collections;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-14 20:52
 * @Description:
 */
public class MergeTwoLists {
    /**
     * 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public static void main(String args[]) {
        MyNode myNode = new MyNode();
        myNode.addNode(1);
        myNode.addNode(2);
        myNode.addNode(4);
        MyNode myNode2 = new MyNode();
        myNode2.addNode(1);
        myNode2.addNode(3);
        myNode2.addNode(4);
        ListNode listNode = mergeTwoLists(myNode.head, myNode2.head);
        MyNode myNode13 = new MyNode();
        myNode13.head = listNode;
        myNode13.printNode();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        MyNode myNode = new MyNode();
        ArrayList<Integer> arrayList = new ArrayList();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                arrayList.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                arrayList.add(l2.val);
                l2 = l2.next;
            }
        }
        Collections.sort(arrayList);
        for (int a : arrayList
        ) {
            myNode.addNode(a);
        }
        return myNode.head;
    }
}
 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class MyNode {
    ListNode head = null;

    public void addNode(int a) {
        ListNode l = new ListNode(a);
        if (head == null) {
            head = l;
            return;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = l;
    }

    public void printNode() {
        ListNode head = this.head;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}