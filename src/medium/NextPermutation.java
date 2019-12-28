package medium;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-28 16:35
 * @Description:
 */
public class NextPermutation {
    /**
     * 下一个排列
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须原地修改，只允许使用额外常数空间。
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */
    public static void main(String args[]) {

        int[] nums = new int[]{1, 2, 3};
        nextPermutation(nums);
        System.out.println(nums[0] + "" + nums[1] + "" + nums[2]);
    }

    public static void nextPermutation(int[] nums) {
        for (int x = nums.length - 1; x > 0; x--) {
            if(nums[x]>nums[x]-1){
                //先查找有没有后面一位数字比前面一位数大的情况
                int b=nums[x-1];
                Arrays.sort(nums,x,nums.length);
                //找到之后从后面一位数开始排序到最后一位
                for(int y=x;y<nums.length;y++){
                    //排序后从后一位数字开始循环查找，将比x数字大的进行交换
                    if(nums[y]>b){
                        int a = nums[x-1];
                        nums[x-1] = nums[y];
                        nums[y] = a;
                        return;
                    }
                }
            }
        }
        //如果没找到，进行最小排序
        Arrays.sort(nums);
    }
    // 1 2 4 3
    // 1 3 4 2
    // 2 3 4
    // 1 3 2 4
}
