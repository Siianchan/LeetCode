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
    TreeNode result1 = new TreeNode();
    TreeNode result2 = result1;

    public void flatten(TreeNode root) {
        if (root != null) {
            dfs(root);
            root.right = result2.right.right;
            root.left = null;
        }
    }

    public void dfs(TreeNode root) {
        result1.right = new TreeNode(root.val);
        result1 = result1.right;
        if (root.left != null)
            dfs(root.left);
        if (root.right != null)
            dfs(root.right);
    }

    public static void main(String[] args) {

    }

}

