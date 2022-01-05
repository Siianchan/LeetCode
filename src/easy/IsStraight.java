package easy;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/5 15:27
 * @Description:
 */
public class IsStraight {

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
