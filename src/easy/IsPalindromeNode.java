package easy;

import java.util.LinkedList;

/**
 * @author siianchan
 * @since 2024/5/8 14:49
 */
public class IsPalindromeNode {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            //单个数
            return true;
        }
        ListNode tmp = head;
        LinkedList<Integer> stack = new LinkedList();
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != head.val) {
                return false;
            } else {
                head = head.next;
            }
        }
        return true;
    }
}
