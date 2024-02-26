package easy;

/**
 * @author siianchan
 * @since 2024/2/26 14:48
 */
public class RangeSumBST {

    /**
     * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
     * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
     * 输出：32
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            //当前值在范围内，就加上
            ret += root.val;
        }
        if (root.left != null && root.val >= low) {
            //如果当前值比最小值还小，那么搜索左子树就没有意义
            ret += rangeSumBST(root.left, low, high);
        }
        if (root.right != null && root.val <= high) {
            //如果当前值比最大值还大，那么搜索右子树就没有意义
            ret += rangeSumBST(root.right, low, high);
        }
        return ret;
    }
}
