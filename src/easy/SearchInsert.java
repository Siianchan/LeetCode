package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2020-04-16 13:17
 * @Description:
 */
public class SearchInsert {
    /**
     * 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     */
    public static void main(String args[]) {

    }

    public int searchInsert(int[] nums, int target) {
        for (int x=0;x<nums.length;x++){
                if(nums[x]>=target){
                    return x;
                }
        }
        return nums.length;
    }

}
