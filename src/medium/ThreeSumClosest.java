package medium;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-21 19:15
 * @Description:
 */
public class ThreeSumClosest {
    /**
     * 最接近的三数之和
     * 给定一个包括 
     * n 个整数的数组 nums 
     * 和 一个目标值 target。找出 nums 中的三个整数，
     * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * 例如，
     * 给定数组 nums = [-1，2，1，-4],
     * 和 target = 1.
     * 与 target
     * 最接近的三个数的和为 2.(-1+2+1=2).
     */
    public static void main(String args[]) {
        int[] num = new int[]{-3, -2, -5, 3, -4};
        System.out.println("=" + threeSumClosest(num, -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        //同双指针解法，固定x，对a和b进行移动
        int lastNum = 99999;
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        for (int x = 0; x < nums.length - 2; x++) {
            int a = x + 1;
            int b = nums.length - 1;
            if (x > 0 && nums[x] == nums[x - 1]) {
                continue;
            }
            while (a != b) {
                if (a > x + 2 && nums[a] == nums[a - 1]) {
                    a++;
                    continue;
                }
                if (b < nums.length - 2 && nums[b] == nums[b + 1]) {
                    b--;
                    continue;
                }
                int sum = nums[x] + nums[a] + nums[b];
                int diff = sum - target;
                System.out.println(sum);
                if (diff > 0) {
                    if (Math.abs(diff) < Math.abs(lastNum - target)) {
                        lastNum = sum;
                    }
                    b--;
                } else if (diff < 0) {
                    if (Math.abs(diff) < Math.abs(lastNum - target)) {
                        lastNum = sum;
                    }
                    a++;
                } else {
                    return target;
                }
            }
            if (nums[x] > (target + 1)) {
                break;
            }
        }
        return lastNum == 99999? 0 : lastNum;
    }
}
