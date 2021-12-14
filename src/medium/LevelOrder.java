package medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/29 19:59
 * @Description:
 */
public class LevelOrder {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode fir = treeNode;
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
        System.out.println(levelOrder(fir));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
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
            lists.add(a);
            arrayDeque = new ArrayDeque<>(arrayDeque2);
            arrayDeque2 = new ArrayDeque<>();
        }
        return lists;
    }
}
