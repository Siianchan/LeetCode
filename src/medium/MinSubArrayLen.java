package medium;

/**
 * @author siianchan
 * @since 2024/5/23 14:24
 */
public class MinSubArrayLen {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
     * 子数组
     * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     */
    public static void main(String[] args) {
        byte a=(byte) Integer.MAX_VALUE;
        System.out.println(a);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int ret = Integer.MAX_VALUE;
        int left = 0;
        int now = 0;
        for (int right = 0; right < nums.length; right++) {
            now += nums[right];
            //滑动数组，当满足条件时，滑动左边下标，看是否满足
            while (now - nums[left] >= target) {
                now -= nums[left];
                left++;
            }
            if (now >= target) {
                ret = Math.min(ret, right - left + 1);
            }
        }
        return ret <= nums.length ? ret : 0;
    }
}
