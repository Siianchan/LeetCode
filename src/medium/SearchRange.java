package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2020-04-05 14:16
 * @Description:
 */
/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class SearchRange {
    public static void main(String args[]) {
        int arr[] = new int[]{5, 7, 8, 8, 8, 9, 9};
        searchRange(arr, 8);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length <= 0) {
            return ans;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            //二分查找中位数
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                //如果查找到了，进入此条件
                ans[0] = mid;
                ans[1] = mid;
                while (ans[0] > 0 && nums[ans[0] - 1] == target) {
                    //开始往前搜索是否相同
                    ans[0]--;
                }
                while (ans[1] < nums.length - 1 && nums[ans[1] + 1] == target) {
                    //往后搜索是否相同
                    ans[1]++;
                }
                return ans;
            }
            if (target >= nums[start] && (target < nums[mid])) {
                //如果大于前半段，更新end坐标
                end = mid - 1;
            } else {
                //如果在前半段之内，更新start坐标
                start = mid + 1;
            }
        }
        return ans;
    }
}
