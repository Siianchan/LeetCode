package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/9 15:12
 * @Description:
 */
public class IsSubStructure {

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * 例如:
     * 给定的树 A:
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 B：
     *    4 
     *   /
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     * 示例 1：
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     */

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //使用逻辑或，当有一个为true时，后边就不会执行
        //递归比较当前节点是否相等以及左右子树
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        //逻辑与，递归比较左右子树是否相等
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}

