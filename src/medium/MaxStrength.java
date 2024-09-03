package medium;


/**
 * @author zxq
 * @since 2024/9/3 13:39
 */
public class MaxStrength {

    /**
     * 给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。
     * 老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，
     * 如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为
     * nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​] 。
     * 请你返回老师创建的小组能得到的最大实力值为多少。
     * 输入：nums = [3,-1,-5,2,5,-9]
     * 输出：1350
     * 解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5]
     * 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这是可以得到的最大实力值。
     */

    public static void main(String[] args) {
        System.out.println(maxStrength(new int[]{0, -1}));
    }

    public static long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        long z = 1;
        int index = 0;
        int countf = 0;
        int zerocount = 0;
        int maxZ = Integer.MIN_VALUE;
        int maxF = Integer.MIN_VALUE;
        while (index < nums.length) {
            if (nums[index] == 0) {
                index++;
                zerocount++;
                continue;
            }
            if (nums[index] < 0) {
                if (nums[index] > maxF) {
                    maxF = nums[index];
                }
                countf++;
            }
            if (nums[index] > maxZ) {
                maxZ = nums[index];
            }
            z *= nums[index];
            index++;
        }
        if ((countf == 1 && maxZ <= 0) || zerocount == nums.length) {
            return 0;
        }
        return z > 0 ? z : z / maxF;
    }

}
