package medium;

import java.util.Arrays;

/**
 * @author siianchan
 * @since 2024/2/21 13:41
 */
public class BuildTree {

    /**
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历
     * ， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
     * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * 输出：[3,9,20,null,null,15,7]
     */
    public static void main(String[] args) {
        buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length < 1) {
            //节点为空就返回null
            return null;
        }
        int inorderRootIndex = 0;
        //最右边一个是根节点
        int root = postorder[postorder.length - 1];
        //构建当前节点（根节点）
        TreeNode treeNode = new TreeNode(root);
        for (int x = 0; x < inorder.length; x++) {
            //找到根节点在中序遍历中的位置，他左边都是左子树，右边都是右子树
            if (inorder[x] == root) {
                inorderRootIndex = x;
                break;
            }
        }
        //把左右子树分开来，然后递归处理
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, inorderRootIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, inorderRootIndex + 1, inorder.length);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, leftInorder.length + rightInorder.length);
        //递归构建左节点
        treeNode.left = buildTree(leftInorder, leftPostorder);
        //递归构建右节点
        treeNode.right = buildTree(rightInorder, rightPostorder);
        return treeNode;
    }

}
