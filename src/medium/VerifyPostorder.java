package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/15 20:16
 * @Description:
 */
public class VerifyPostorder {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
     * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     * 参考以下这颗二叉搜索树：
     * 5
     * / \
     * 2   6
     * / \
     * 1   3
     * 示例 1：
     * 输入: [1,6,3,2,5]
     * 输出: false
     * 示例 2：
     * 输入: [1,3,2,6,5]
     * 输出: true
     */

    public static void main(String[] args) {

    }

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        //扫描左子树，比postorder[j]小，记录停留地点
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        //扫描右子树，比postorder[j]大
        //如果最后p未扫到最后一个节点，说明不满足,递归判断左右子树
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
