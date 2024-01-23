package easy;

/**
 * @author siianchan
 * @since 2024/1/23 16:03
 */
public class AlternatingSubarray {
    /**
     * 2765. 最长交替子数组
     * 给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ：
     * m 大于 1 。
     * s1 = s0 + 1 。
     * 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，
     * s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
     * 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
     * 子数组是一个数组中一段连续 非空 的元素序列。
     * 示例 1：
     * 输入：nums = [2,3,4,3,4]
     * 输出：4
     * 解释：交替子数组有 [3,4] ，[3,4,3] 和 [3,4,3,4] 。最长的子数组为 [3,4,3,4] ，长度为4 。
     */
    public static void main(String[] args) {
        System.out.println(alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
    }

    public static int alternatingSubarray(int[] nums) {
        int max = 1;
        int count = 1;
        boolean flag = true;
        for (int x = 1; x < nums.length; x++) {
            int check = flag ? 1 : -1;
            if (nums[x] - nums[x - 1] == check) {
                //没断
                flag = !flag;
                count++;
            } else {
                max = Math.max(max, count);
                //如果断掉的话,flag从true开始
                flag = nums[x] - nums[x - 1] != 1;
                //如果断掉的话，从1开始计数，如果断掉，且这次能接上的话，从2开始计数
                count = nums[x] - nums[x - 1] == 1 ? 2 : 1;
            }
        }
        max = Math.max(max, count);
        return max > 1 ? max : -1;
    }
}
