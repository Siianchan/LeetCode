package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/10 13:52
 * @Description:
 */
public class PathSum {

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
     * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
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
        PathSum pathSum = new PathSum();
        pathSum.pathSum(treeNode, 6);
    }


    List<List<Integer>> arrayList = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return arrayList;
        dfs(root, targetSum, 0, new LinkedList());
        return arrayList;
    }

    public void dfs(TreeNode root, int targetSum, int nowNum, LinkedList linkedList) {
        //添加当前节点
        linkedList.addLast(root.val);
        if (root.left == null && root.right == null)
            //当左右子树为0时，说明到了叶子节点
            if (nowNum + root.val == targetSum)
                //当和为给定target时，加入路径
                arrayList.add(new LinkedList<>(linkedList));
        if (root.left != null)
            //如果左子树不为空，递归左子树
            dfs(root.left, targetSum, nowNum + root.val, linkedList);
        if (root.right != null)
            //如果右子树不为空，递归右子树
            dfs(root.right, targetSum, nowNum + root.val, linkedList);
        //移除节点
        linkedList.removeLast();
    }
}
