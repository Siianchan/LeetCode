package medium;

import java.util.HashMap;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/15 21:34
 * @Description:
 */

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，
 * 树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针
 */
public class TreeToDoublyList {
    HashMap<Integer, Node> hashMap = new HashMap();
    int count = 0;

    public static void main(String[] args) {
    }

    public Node treeToDoublyList(Node root) {
        dfs(root);
        for (int x = 0; x < hashMap.size(); x++) {
            hashMap.get(x).right = hashMap.get((x + 1) % hashMap.size());
            if (x == 0) {
                hashMap.get(0).left = hashMap.get(hashMap.size() - 1);
                continue;
            }
            hashMap.get(x).left = hashMap.get(x - 1);
        }
        Node pr = hashMap.get(0);
        int print = 0;
        while (print <= 2 * count && pr != null) {
            System.out.println(pr.val);
            pr = pr.right;
            print++;
        }
        return hashMap.get(0);
    }

    public void dfs(Node node) {
        if (node.left != null)
            dfs(node.left);
        hashMap.put(count, node);
        count++;
        if (node.right != null)
            dfs(node.right);
    }
}
