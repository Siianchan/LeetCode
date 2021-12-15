package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/15 20:50
 * @Description:
 */

class NodeR {
    int val;
    NodeR next;
    NodeR random;

    public NodeR(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {

    public NodeR copyRandomList(NodeR head) {
        if (head == null) return null;
        NodeR cur = head;
        Map<NodeR, NodeR> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while (cur != null) {
            map.put(cur, new NodeR(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }
}
