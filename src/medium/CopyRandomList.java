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

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
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
        //循环两边，第一遍建立hash映射，第二遍建立next和random的引用
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
