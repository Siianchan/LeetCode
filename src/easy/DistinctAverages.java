package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author
 * @since 2023/6/5 15:35
 */
public class DistinctAverages {
    /**
     * 最大值+最小值共有多少个平均数
     */
    public static void main(String[] args) {
        new DistinctAverages().distinctAverages(new int[]{4, 1, 4, 0, 3, 5});
    }

    public int distinctAverages(int[] nums) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(nums);
        int a = 0;
        int b = nums.length - 1;
        while (a < b) {
            result.add(nums[a++] + nums[b--]);
        }
        return result.size();
    }
}
