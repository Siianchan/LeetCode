package medium;

import java.util.*;

/**
 * @author siianchan
 * @since 2024/5/23 13:27
 */
public class LongestEqualSubarray {

    /**
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     * 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
     * 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
     * 子数组 是数组中一个连续且可能为空的元素序列。
     */

    public static void main(String[] args) {


    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        List<Integer>[] posLists = new ArrayList[n + 1];
        Arrays.setAll(posLists, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            posLists[x].add(i - posLists[x].size());
        }

        int ans = 0;
        for (List<Integer> pos : posLists) {
            if (pos.size() <= ans) {
                continue; // 无法让 ans 变得更大
            }
            int left = 0;
            for (int right = 0; right < pos.size(); right++) {
                while (pos.get(right) - pos.get(left) > k) {
                    // 要删除的数太多了
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}
