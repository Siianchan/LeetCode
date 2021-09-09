package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/8 15:52
 * @Description:
 */
public class MinDepth {
    /**
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
     */
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
        MinDepth minDepth = new MinDepth();
        minDepth.minDepth(treeNode);
    }

    int minArr = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return minArr;
    }

    public void dfs(TreeNode root, int num) {
        if (num > minArr) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (num < minArr) {
                minArr = num;
            }
        }
        if (root.left != null)
            dfs(root.left, num + 1);
        if (root.right != null)
            dfs(root.right, num + 1);
    }
}
