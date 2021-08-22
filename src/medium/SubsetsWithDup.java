package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/22 16:19
 * @Description:
 */
public class SubsetsWithDup {
    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     */
    public static void main(String[] args) {
        int[] a = new int[]{1, 1};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        subsetsWithDup.subsetsWithDup(a);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), ans, false);
        return ans;
    }

    private void dfs(int[] nums, int from, List<Integer> a, List<List<Integer>> ans, boolean lastNoPut) {
        if (from == nums.length) {
            ans.add(new ArrayList<>(a));
            return;
        }

        dfs(nums, from + 1, a, ans, true);
        if (lastNoPut && nums[from] == nums[from - 1]) {
            return;
        }
        a.add(nums[from]);
        dfs(nums, from + 1, a, ans, false);
        a.remove(a.size() - 1);
    }

}
