package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/31 20:54
 * @Description:
 */
public class MaxDepth {

    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * 返回它的最大深度 3 。
     */

    int num = 0;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(treeNode7));
    }

    public int maxDepth(TreeNode root) {
        if (root != null)
            dfs(root, 1);
        return num;
    }

    public void dfs(TreeNode root, int val) {
        if (root.left != null)
            dfs(root.left, val + 1);
        if (root.right != null)
            dfs(root.right, val + 1);
        if (val > num)
            num = val;
    }
}
