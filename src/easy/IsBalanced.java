package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/7 19:10
 * @Description:
 */
public class IsBalanced {
    //    给定一个二叉树，判断它是否是高度平衡的二叉树。
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
        IsBalanced os = new IsBalanced();
        os.isBalanced(treeNode);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = 0;
        int right = 0;
        left = dfs(root.left);
        right = dfs(root.right);
        //因为子树也可能存在不是平衡的情况，所以要递归判断子树
        return Math.abs(left - right) > 1 ? false : true && isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return Math.max(dfs(treeNode.left), dfs(treeNode.right)) + 1;
    }
}
