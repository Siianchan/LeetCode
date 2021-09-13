package medium;

import java.util.ArrayDeque;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/13 14:20
 * @Description:
 */
public class Connect {
    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * 初始状态下，所有 next 指针都被设置为 NULL。
     */
    public static void main(String[] args) {
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node.left = node1;
        node.right = node2;
        Connect c = new Connect();
        c.connect(node);
    }

    public Node connect(Node root) {
        ArrayDeque<Node> arrayDeque = new ArrayDeque();
        ArrayDeque<Node> arrayDeque2 = new ArrayDeque();
        if (root == null) return null;
        arrayDeque.add(root);
        while (arrayDeque.size() > 0) {
            while (arrayDeque.size() > 0) {
                Node r = arrayDeque.poll();
                r.next = arrayDeque.peek();
                if (r.left != null)
                    arrayDeque2.add(r.left);
                if (r.right != null)
                    arrayDeque2.add(r.right);
            }
            arrayDeque = new ArrayDeque<>(arrayDeque2);
            arrayDeque2 = new ArrayDeque<>();
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}