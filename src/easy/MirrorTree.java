package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/9 16:07
 * @Description:
 */

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode ret = root;
        dfs(root);
        return ret;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            //当节点为空时，返回
            return;
        }
        //交换左右树节点
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
        //递归交换左右子树
        dfs(root.left);
        dfs(root.right);
    }
}
