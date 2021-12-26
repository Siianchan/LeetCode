package medium;

import java.util.HashMap;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/26 14:02
 * @Description:
 */

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 */
public class SingleNumber {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap();

    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int n : nums
        ) {
            hashMap.put(n, hashMap.get(n) == null ? 1 : hashMap.get(n) + 1);
        }
        for (int n : nums
        ) {
            if (hashMap.get(n) == 1) {
                return n;
            }
        }
        return 0;
    }
}
