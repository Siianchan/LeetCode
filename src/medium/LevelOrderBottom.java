package medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/5 14:00
 * @Description:
 */
public class LevelOrderBottom {
    /**
     * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * 返回其自底向上的层序遍历为：
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
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
        System.out.println(levelOrderBottom(treeNode));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque();
        ArrayDeque<TreeNode> arrayDeque2 = new ArrayDeque();
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;
        arrayDeque.add(root);
        while (arrayDeque.size() > 0) {
            List a = new LinkedList();
            while (arrayDeque.size() > 0) {
                TreeNode r = arrayDeque.poll();
                a.add(r.val);
                if (r.left != null)
                    arrayDeque2.add(r.left);
                if (r.right != null)
                    arrayDeque2.add(r.right);
            }
            ((LinkedList<List<Integer>>) lists).addFirst(a);
            arrayDeque = new ArrayDeque<>(arrayDeque2);
            arrayDeque2 = new ArrayDeque<>();
        }
        return lists;
    }
}
