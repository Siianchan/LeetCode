package medium;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/17 16:00
 * @Description:
 */


/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */

public class LongestConsecutive {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {

        //1201
        //0112
        if (nums.length <= 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 1;
        int max = 1;
        for (int x = 0; x < nums.length - 1; x++) {
            if (nums[x] + 1 == nums[x + 1]) {
                max++;
            } else if (nums[x] == nums[x + 1]) {
                continue;
            } else {
                if (max > result) {
                    result = max;
                }
                max = 1;
            }
        }
        if (max > result) {
            result = max;
        }
        return result;
    }
}
