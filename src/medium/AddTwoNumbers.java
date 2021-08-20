package medium;

import java.math.BigInteger;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-11-30 22:05
 * @Description:
 */
public class AddTwoNumbers {
    /**
     * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是
     * 按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static void main(String args[]) {
        MyNode myNode = new MyNode();
        MyNode myNode2 = new MyNode();
        myNode.addNode(0);
        myNode2.addNode(1);
        myNode2.addNode(9);
        myNode2.addNode(9);
        myNode2.addNode(9);
        myNode2.addNode(9);
        myNode2.addNode(9);
        myNode2.addNode(9);
        myNode2.addNode(9);
        myNode2.addNode(9);
        myNode2.addNode(9);
        addTwoNumbers(myNode.head, myNode2.head);
    }

    public static void printNode(ListNode listNode) {
        ListNode head = listNode;
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        while (l1 != null || l2 != null) {
            //取出链表中的数，存到a和b中
            if (l1 != null) {
                a.insert(0, l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                b.insert(0, l2.val);
                l2 = l2.next;
            }
        }
        //得到a+b的和c
        BigInteger c = new BigInteger(a.toString()).add(new BigInteger(b.toString()));
        char[] ch = c.toString().toCharArray();
        ListNode head = null;
        for (int x = ch.length - 1; x >= 0; x--) {
            ListNode newNode = new ListNode(ch[x] - '0');
            if (head == null) {
                head = newNode;
                continue;
            }
            //将开始的数组复制给tmp
            ListNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            //复制新节点
            tmp.next = newNode;
        }
        printNode(head);
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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