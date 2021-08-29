package medium;

import com.sun.org.apache.xerces.internal.xs.LSInputList;

import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/26 16:31
 * @Description:
 */
public class InorderTraversal {
    //    给定一个二叉树的根节点 root ，返回它的 中序 遍历。
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode fir = treeNode;
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode3;
        treeNode.right = treeNode2;
        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.inorderTraversal(fir);
    }

    List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        dfs(root);
        return result;
    }

    public void dfs(TreeNode root) {
//        System.out.println(root.val); 前序
        if (root.left != null)
            dfs(root.left);
//        System.out.println(root.val); 中序
        result.add(root.val);
        if (root.right != null)
            dfs(root.right);
//        System.out.println(root.val); 后序
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