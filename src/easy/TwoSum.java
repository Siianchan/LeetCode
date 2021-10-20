package easy;

import java.util.HashMap;
import java.util.Set;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-11-30 21:41
 * @Description:
 */
public class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums=[2,7,11,15],target=9
     * 因为 nums[0]+nums[1]=2+7=9
     * 所以返回[0,1]
     */
    public static void main(String[] args) {
        twoSum2(new int[]{2, 7, 11, 15}, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int a, b;
        for (int x = 0; x < nums.length - 1; x++) {
            a = nums[x];
            for (int y = x + 1; y < nums.length; y++) {
                b = nums[y];
                if (a + b == target) {
                    answer[0] = x + 1;
                    answer[1] = y + 1;
                    break;
                }
            }
        }
        return answer;
    }

    public  static  int[] twoSum2(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap();
        HashMap<Integer, Integer> hashMap2 = new HashMap();
        for (int x = 0; x < nums.length; x++) {
            if (hashMap.get(nums[x]) == null) {
                hashMap.put(nums[x], x + 1);
            } else {
                hashMap2.put(nums[x], x + 1);
            }
        }
        Set<Integer> set = hashMap.keySet();
        for (Integer s : set
        ) {
            System.out.println(s);
            int arrA = hashMap.get(s);
            int a = target - s;
            Integer arrB;
            if (a == s) {
                arrB = hashMap2.get(a);
            } else {
                arrB = hashMap.get(a);
            }
            if (arrB != null) {
                answer[0] = arrA < arrB ? arrA : arrB;
                answer[1] = arrA > arrB ? arrA : arrB;
                break;
            }
        }
        return answer;
    }
}
