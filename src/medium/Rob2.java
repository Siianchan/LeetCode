package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/11/8 19:23
 * @Description:
 */
public class Rob2 {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     */

    public static void main(String[] args) {
        int a[] = new int[]{1, 2};
        rob(a);
    }

    public static int rob(int[] nums) {
        return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }

    static int dp(int[] nums, int start, int end) {
        int[] dp = new int[nums.length - 1];  // 3
        dp[0] = nums[start]; // 2
        dp[1] = Math.max(nums[start], nums[start + 1]);// 3
        for (int x = start + 2; x <= end; x++) {
            dp[x - start] = Math.max(dp[x - 2 - start] + nums[x], dp[x - 1 - start]);
        }
        return dp[nums.length - 2];
    }
}
