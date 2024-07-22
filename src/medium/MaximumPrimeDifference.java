package medium;

/**
 * @author siianchan
 * @since 2024/7/2 14:30
 */
public class MaximumPrimeDifference {
    /**
     * 给你一个整数数组 nums。
     * 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
     * 示例 1：
     * 输入： nums = [4,2,9,5,3]
     * 输出： 3
     * 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。
     * 示例 2：
     * 输入： nums = [4,8,2,8]
     * 输出： 0
     * 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。
     */


    public static void main(String[] args) {
        new MaximumPrimeDifference().maximumPrimeDifference(new int[]{4, 8, 2, 8});
    }

    public int maximumPrimeDifference(int[] nums) {
        int x = 0;
        int y = nums.length - 1;
        while (x < nums.length) {
            if (isZs(nums[x])) {
                break;
            }
            x++;
        }
        while (y > x) {
            if (isZs(nums[y])) {
                break;
            }
            y--;
        }
        if (y == x) {
            return 0;
        }
        return y - x;
    }

    public boolean isZs(int a) {
        if (a <= 1) {
            return false;
        }
        if (a == 2 || a == 3) {
            return true;
        }
        if (a % 2 == 0 || a % 3 == 0) {
            return false;
        }
        // 从5开始检查，跳过所有偶数和3的倍数
        //所有大于3的质数都是6k+-1,所以从5开始加6的话，必定是6k-1，再加2的话必定是6k+1
        for (int i = 5; i * i <= a; i += 6) {
            if (a % i == 0 || a % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean f(int a) {
        if (a <= 1) {
            return false;
        }
        if (a <= 3) {
            return true;
        }
        if (a % 2 == 0 || a % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= a; i += 6) {
            if (a % i == 0 || a % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
