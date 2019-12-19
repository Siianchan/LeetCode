package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-19 19:50
 * @Description:
 */
public class ThreeSum {
    /**
     * 三数之和
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public static void main(String args[]) {
        int[] nums = new int[]{0, 0, 0, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //固定a，对b和c进行双指针运动
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);//首先对数组进行排序
        for (int x = 0; x < nums.length - 2; x++) {
            if (nums[x] > 0) {
                //当a大于0的时候，后面三位数之和不可能等于0了
                break;
            }
            if (x > 0 && nums[x] == nums[x - 1]) {
                //当a和上一个数字相等时候，进行去重。之所以不跟下一个而跟上一个数字比较、移动坐标
                // 是因为，会减少第二个数字的选择空间
                continue;
            }
            int a = x + 1;
            int b = nums.length - 1;
            while (a < b) {
                //当a小于b的时候，不停的一移动a和b的指针位置
                if (nums[x] + nums[a] + nums[b] > 0) {
                    //移动规则：当三个数相加大于0的时候，将b指针往前移动一格（因为是排了序的，所以必定减少和）
                    b--;
                    continue;
                } else if (nums[x] + nums[a] + nums[b] < 0) {
                    //移动规则：当三个数相加小于0的时候，将a指针往后移动一格（因为是排了序的，所以必定增加和）
                    a++;
                } else {
                    //当三个数相加等于0时，进行a和b的去重处理并记录结果
                    while (a < nums.length - 2 && nums[a] == nums[a + 1]) {
                        a++;
                    }
                    while (b < nums.length - 2 && nums[b] == nums[b - 1]) {
                        b--;
                    }
                    List<Integer> list = new ArrayList();
                    list.add(nums[x]);
                    list.add(nums[a]);
                    list.add(nums[b]);
                    lists.add(list);
                    a++;
                    b--;
                }
            }
        }
        return lists;
    }
}
