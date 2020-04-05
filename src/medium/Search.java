package medium;
/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2020-04-05 14:04
 * @Description:
 */
/**
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 */
public class Search {
    public static void main(String args[]) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;//缩小中位数
            if (nums[mid] == target) {
                return mid; //如果查找到了，则返回坐标
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {//表示前半部分有序
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {//如果target大于开始，小于中位数，说明target在前半部分
                    end = mid - 1;
                } else {
                    start = mid + 1;//如果不在前半部分，说明在后半部分
                }
            } else {//表示后半部分有序
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}
