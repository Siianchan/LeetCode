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
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode fir = treeNode;
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        IsSymmetric symmetric = new IsSymmetric();
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
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
