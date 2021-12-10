package easy;


/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/29 15:50
 * @Description:
 */
public class IsSymmetric {
//    给定一个二叉树，检查它是否是镜像对称的。
//    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return isMirror(root.left, root.right);
        }
        return true;
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true; //当两个节点都为空时，返回true
        if (t1 == null || t2 == null) return false;//当有一方节点为空时，返回false
        //判断当前值是否相等，然后递归判断t1左树和t2右树
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
