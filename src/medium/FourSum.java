package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-23 19:31
 * @Description:
 */
public class FourSum {
    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 注意：
     * 答案中不可以包含重复的四元组。
     * 示例：
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     */
    public static void main(String args[]) {
        int[] arr = new int[]{1,-2,-5,-4,-3,3,3,5};
        System.out.println(fourSum(arr, -11));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) {
            return lists;
        }
        Arrays.sort(nums);
        for (int x = 0; x < nums.length - 3; x++) {
            if (target>0&&nums[x] > target) {
                break;
            }
            if (x > 0 && nums[x] == nums[x - 1]) {
                continue;
            }
            for (int y = x + 1; y < nums.length - 2; y++) {
                if (y > x + 1 && nums[y] == nums[y - 1]) {
                    continue;
                }
                int a = y + 1;
                int b = nums.length - 1;
                while (a < b) {
                    //当a小于b的时候，不停的一移动a和b的指针位置
                    if (nums[x] + nums[y] + nums[a] + nums[b] > target) {
                        //移动规则：当三个数相加大于0的时候，将b指针往前移动一格（因为是排了序的，所以必定减少和）
                        b--;
                        continue;
                    } else if (nums[x] + nums[y] + nums[a] + nums[b] < target) {
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
                        list.add(nums[y]);
                        list.add(nums[a]);
                        list.add(nums[b]);
                        lists.add(list);
                        a++;
                        b--;
                    }
                }
            }
        }
        return lists;
    }
}

