package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/12 15:16
 * @Description:
 */
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
public class RotateRight {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode first = listNode;
        for (int x = 2; x < 6; x++) {
            listNode.next = new ListNode(x);
            listNode = listNode.next;
        }
//            for(int x=0;x<5;x++){
//                System.out.println(first.val);
//                first=first.next;
//            }
        RotateRight rotateRight = new RotateRight();
        rotateRight.rotateRight(first, 1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int size = 0;
        ListNode curr = head, tail = null;   // 定义当前节点和尾部节点
        // 获取链表长度和最后一个节点
        while (curr != null) {
            curr = curr.next;
            size++;
            if (curr != null) tail = curr;
        }
        int n = k % size; // 倒数第n个节点及其之后的节点要发生移动
        if (n == 0) {
            return head;
        }
        ListNode slow = head;

        for (int x = 0; x < size - n - 1; x++) {
            slow = slow.next;
        }
        tail.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
