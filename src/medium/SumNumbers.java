package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/18 15:31
 * @Description:
 */
public class SumNumbers {

    /**
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     * 每条从根节点到叶节点的路径都代表一个数字：
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     * 叶节点 是指没有子节点的节点。
     */

    int result = 0;

    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {

        return 0;
    }

    public void dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            result += num * 10 + root.val;
            return;
        }
        if (root.left != null)
            dfs(root.left, num * 10 + root.val);
        if (root.right != null)
            dfs(root.right, num * 10 + root.val);
    }
}
