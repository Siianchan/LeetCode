package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/24 15:30
 * @Description:
 */
public class KthLargest {
    /**
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     * 示例 1:
     * 输入: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     *    2
     * 输出: 4
     */
    public static void main(String[] args) {

    }

    int num = 0;
    int ret = 0;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ret;
    }

    public void dfs(TreeNode treeNode, int k) {
        //右左中的顺序遍历，从大到小
        if (treeNode.right != null) {
            dfs(treeNode.right, k);
        }
        num++;
        if (num == k) {
            ret = treeNode.val;
            return;
        }
        if (treeNode.left != null) {
            dfs(treeNode.left, k);
        }
    }
}
