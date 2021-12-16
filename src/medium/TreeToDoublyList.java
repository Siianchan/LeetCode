package medium;

import java.util.HashMap;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/15 21:34
 * @Description:
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
