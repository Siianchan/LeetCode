package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/4 14:22
 * @Description:
 */
public class Permute {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3], [2,3,1],[3,1,2],[3,2,1]]
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        Permute permute = new Permute();
        permute.permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] bl = new boolean[nums.length];
        LinkedList linkedList = new LinkedList();
        dfs(nums, bl, 0, linkedList, ans);
        System.out.println(ans);
        return ans;
    }

    public void dfs(int[] nums, boolean[] bl, int max, LinkedList<Integer> pl, List<List<Integer>> ans) {
        //深搜
        if (max == nums.length) {
//            全排列2，去重
//            if(ans.contains(new ArrayList<>(pl))){
//                return;
//            }
            ans.add(new ArrayList<>(pl));
            return;
        }
        for (int x = 0; x < nums.length; x++) {
            if (!bl[x]) {
                bl[x] = true;
                pl.add(nums[x]);
                dfs(nums, bl, max + 1, pl, ans);
                bl[x] = false;
                pl.removeLast();
            }
        }
    }
}
