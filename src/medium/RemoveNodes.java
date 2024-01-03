package medium;


import java.util.ArrayDeque;

/**
 * @author siianchan
 * @since 2024/1/3 11:22
 */
public class RemoveNodes {
    /**
     * 给你一个链表的头节点 head 。
     * 移除每个右侧有一个更大数值的节点。
     * 返回修改后链表的头节点 head 。
     * 输入：head = [5,2,13,3,8]
     * 输出：[13,8]
     * 解释：需要移除的节点是 5 ，2 和 3 。
     * - 节点 13 在节点 5 右侧。
     * - 节点 13 在节点 2 右侧。
     * - 节点 8 在节点 3 右侧。
     */
    public static void main(String[] args) {
        //5,2,13,3,8
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        print(head);
        System.out.println("===================================");
        RemoveNodes removeNodes = new RemoveNodes();
        print(removeNodes.removeNodes(new ListNode(5)));
    }

    public ListNode removeNodes(ListNode head) {
        ArrayDeque<ListNode> arrayDeque = new ArrayDeque();
        ListNode retHead = head;
        while (head != null) {
            while (!arrayDeque.isEmpty() && arrayDeque.peek().val < head.val) {
                arrayDeque.pop();
            }
            if (arrayDeque.isEmpty()) {
                retHead = head;
            } else {
                arrayDeque.peek().next = head;
            }
            arrayDeque.push(head);
            head = head.next;
        }
        return retHead;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}


