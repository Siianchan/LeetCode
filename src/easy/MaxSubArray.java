package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-13 19:45
 * @Description:
 */
public class MaxSubArray {
    /**
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public static void main(String args[]) {
        int[] arrs = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arrs));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum <= 0) {
                //如果加起來之后小于0，则重置下标开始计算
                sum = nums[i];
            } else {
                //如果加起來之后小于0，则重置下标开始计算，否则继续相加
                sum += nums[i];
            }
            //每次相加都计算一次是否是最大值
            res = res > sum ? res : sum;
        }

        return res;
    }
}
