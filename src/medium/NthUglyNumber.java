package medium;


/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/22 14:58
 * @Description:
 */


/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */

public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(13));
    }

    public static int nthUglyNumber(int n) {
        //维护三个指针，每个指针都从1开始，将三指针所指向的丑数，各自乘2，3，5
        //选取一个乘积最小的（保证顺序）,将乘积等于的各自指针+1
        //每个丑数必定为前面的丑数乘2、3、5
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        int dpArr = 2;
        while (dpArr <= n) {
            int a = dp[p2] * 2;
            int b = dp[p3] * 3;
            int c = dp[p5] * 5;
            dp[dpArr] = Math.min(Math.min(a, b), c);
            if (a == dp[dpArr])
                p2++;
            if (b == dp[dpArr])
                p3++;
            if (c == dp[dpArr])
                p5++;
            dpArr++;
        }
        for (int x = 0; x < dp.length; x++) {
            System.out.println(dp[x]);
        }
        return dp[n];
    }
}
