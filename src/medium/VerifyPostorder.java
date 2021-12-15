package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/15 20:16
 * @Description:
 */
public class VerifyPostorder {
    public static void main(String[] args){

    }
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        //扫描左子树，比postorder[j]小，记录停留地点
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        //扫描右子树，比postorder[j]大
        //如果最后p未扫到最后一个节点，说明不满足,递归判断左右子树
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
