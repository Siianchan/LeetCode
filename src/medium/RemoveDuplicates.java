package medium;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/18 13:48
 * @Description:
 */
public class RemoveDuplicates {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 输入：nums = [1,1,1,2,2,3]
     * 输出：5, nums = [1,1,2,2,3]
     * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
     */
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 1, 1, 2, 2, 2, 3};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(a));

    }

    public int removeDuplicates(int[] nums) {
        int dele = 0;
        int xd = 1;
        for (int x = 1; x < nums.length; x++) {
            if (nums[x] == nums[x - 1]) {
                xd++;
                if (xd > 2) {
                    dele++;
                }
            } else {
                if (xd > 2) {
                    for (int y = 0; y < xd - 2; y++) {
                        nums[x - 1 - y] = Integer.MAX_VALUE;
                    }
                }
                xd = 1;
            }
        }

        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - dele; i++) {
//            System.out.println(nums[i]);
//        }
        return nums.length - dele;
    }

}
