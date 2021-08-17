package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/17 14:15
 * @Description:
 */
public class Subsets {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4, 5};
        Subsets subsets = new Subsets();
        subsets.subsets(num);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int x = 0; x < nums.length; x++) {
            int size = lists.size();
            for (int y = 0; y < size; y++) {
                List<Integer> linkedList = new ArrayList<>(lists.get(y));
                linkedList.add(nums[x]);
                lists.add(linkedList);
            }
        }
        return lists;
    }

}
