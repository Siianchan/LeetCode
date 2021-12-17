package easy;

import java.util.HashMap;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/23 18:23
 * @Description:
 */
public class MajorityElement {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。
     * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 示例 1：
     * 输入：[3,2,3]
     * 输出：3
     */

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        //哈希表解决
        if (nums.length == 1) return nums[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int x = 0; x < nums.length; x++) {
            Integer var1 = hashMap.get(nums[x]);
            if (var1 != null) {
                if (++var1 > nums.length / 2) {
                    //如果已经大于一半了，直接返回
                    return nums[x];
                }
                //存入
                hashMap.put(nums[x], var1);
            } else {
                //首次存入
                hashMap.put(nums[x], 1);
            }
        }
        return nums[0];
    }
}
