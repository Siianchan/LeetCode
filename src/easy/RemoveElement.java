package easy;


/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-12 19:42
 * @Description:
 */
public class RemoveElement {
    /**
     * 移除元素
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * 示例 1:
     * 给定 nums = [3,2,2,3], val = 3,
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public static void main(String args[]) {
        int[] nums = new int[]{3, 2, 2, 3};
        removeElement(nums, 2);
        for (int i : nums
        ) {
            System.out.println(i);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        //新建一个下标记录
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] != val) {
                nums[index] = nums[x];
                index++;
            }
        }
        return index;
    }
}
