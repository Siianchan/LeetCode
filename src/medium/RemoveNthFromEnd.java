package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-10 18:46
 * @Description:
 */
public class RemoveNthFromEnd {
    /**
     * 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     */
    public static void main(String args[]) {
        MyNode myNode = new MyNode();
        myNode.addNode(1);
        myNode.addNode(2);
        myNode.addNode(3);
        myNode.addNode(4);
        myNode.addNode(5);
        myNode.head = removeNthFromEnd(myNode.head, 2);
        myNode.printNode();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode firstNode = head;
        ListNode deleteNode = null;
        int start = 0;
        while (firstNode.next != null) {
            //两个节点，第一个从开始跑，第二个从n的位置开始跑，第一个跑完的时候，第二个节点就停留在n的位置
            firstNode = firstNode.next;
            start++;
            if (start == n) {
                deleteNode = head;
            }
            if (start > n) {
                deleteNode = deleteNode.next;
            }
        }
        if (deleteNode == null) {
            //如果删除的节点为null的话，说明删除的是第一个节点
            head = head.next;
        } else {
            //如果删除的节点不为null的话，删除他的下一个节点
            deleteNode.next = deleteNode.next.next;
        }
        return head;
    }
}
/**
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */