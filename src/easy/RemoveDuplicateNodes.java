package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author siianchan
 * @since 2024/1/19 15:12
 */
public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        removeDuplicateNodes(head);
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        //无序 删除重复节点
        Set<Integer> con = new HashSet();
        if (head == null) {
            return head;
        }
        ListNode first = head;
        while (head.next != null) {
            con.add(head.val);
            if (con.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
            if (head == null) {
                break;
            }
        }
        return first;
    }

}
