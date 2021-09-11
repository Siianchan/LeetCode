package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/11 18:42
 * @Description:
 */
public class Flatten {
    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     */

    public static void main(String[] args) {

    }

    FlattenTreeNode result = new FlattenTreeNode();

    public void flatten(FlattenTreeNode root) {
        if (root != null) {
            dfs(root);
            root = result.right;
        }
    }

    public void dfs(FlattenTreeNode root) {
        result.right = new FlattenTreeNode(root.val);
        result = result.right;
        if (root.left != null)
            dfs(root.left);
        if (root.right != null)
            dfs(root.right);
    }
}


class FlattenTreeNode {
    int val;
    FlattenTreeNode left;
    FlattenTreeNode right;

    FlattenTreeNode() {
    }

    FlattenTreeNode(int val) {
        this.val = val;
    }

    FlattenTreeNode(int val, FlattenTreeNode left, FlattenTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
