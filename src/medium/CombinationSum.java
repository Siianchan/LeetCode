package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2020-12-08 12:58
 * @Description:
 */

public class CombinationSum {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     * [7],
     * [2,2,3]
     * ]
     */
    static List<List<Integer>> ans = new ArrayList();

    public static void main(String[] args) {
        int target = 8;
        int[] candidates = {2, 3, 5};
        combinationSum(candidates, target);
        System.out.println(ans);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> lists = new ArrayList<>();
        dfs(candidates, lists, target, 0);
        return ans;
    }

    public static void dfs(int[] candidates, List<Integer> lists, int num, int arr) {
        if (num == 0) {
            ans.add(new ArrayList<>(lists));
            return;
        }
        if (num < 0) return;
        for (int x = arr; x < candidates.length; x++) {
            lists.add(candidates[x]);
            dfs(candidates, lists, num - candidates[x], x);
            lists.remove(lists.size() - 1);
        }
    }
}
