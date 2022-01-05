package easy;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/5 15:27
 * @Description:
 */
public class IsStraight {
    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     * 示例 1:
     * 输入: [1,2,3,4,5]
     * 输出: True
     */

    public static void main(String[] args) {

    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int sumZero = 0;
        for (int x = 0; x < 4; x++) {
            if (nums[x] == 0) sumZero++;
            else if (nums[x] == nums[x + 1]) return false;
        }
        return nums[4] - nums[sumZero] < 5;
    }
}
