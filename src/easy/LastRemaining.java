package easy;

import java.util.LinkedList;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/6 14:52
 * @Description:
 */
public class LastRemaining {
    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，
     * 每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
     * 求出这个圆圈里剩下的最后一个数字。
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，
     * 从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     * 示例 1：
     * 输入: n = 5, m = 3
     * 输出: 3
     */

    public static void main(String[] args) {
        lastRemaining(5, 3);
    }

    public static int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
            System.out.println(ans);
        }
        return ans;
    }
}
