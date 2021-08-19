package medium;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/19 19:47
 * @Description:
 */
public class Search2 {

    /**
     * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
     * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
     * 输入：nums = [2,5,6,0,0,1,2], target = 0
     * 输出：true
     */

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4};
        Search2 search2 = new Search2();
        search2.search(a, 4);
    }

    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int arr;
        int start = 0;
        int end = nums.length - 1;
        boolean flag = false;
        while (start <= end) {
            arr = (start + end) / 2;
            if (target == nums[arr]) {
                flag = true;
                break;
            }
            if (target > nums[arr]) {
                start = arr + 1;

            } else if (target < nums[arr]) {
                end = arr - 1;
            }
        }
        return flag;
    }
}
