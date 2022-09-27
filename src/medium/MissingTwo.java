package medium;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/9/27 14:39
 * @Description:
 */
public class MissingTwo {

    /**
     * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
     * 以任意顺序返回这两个数字均可。
     * 示例 1:
     * 输入: [1]
     * 输出: [2,3]
     */

    public static void main(String[] args) {
        int[] t = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new MissingTwo().missingTwo(t)));
    }

    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2, cur = n * (1 + n) / 2;
        //求出两数和
        for (int x : nums) cur -= x;
        //两数和除2，可以得出，两个数必不可能在一个区间
        int sum = cur, t = cur / 2;
        //计算其中一个区间的理论总和
        cur = t * (1 + t) / 2;
        for (int x : nums) {
            //计算其中一个区间的实际总和,即可求出缺失的一个数，即可求出缺失的两个数
            if (x <= t) cur -= x;
        }
        return new int[]{cur, sum - cur};
    }
}
