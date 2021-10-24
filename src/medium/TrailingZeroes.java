package medium;

import java.math.BigInteger;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/24 13:43
 * @Description:
 */
public class TrailingZeroes {
    /**
     * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
     * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
     * 示例 1：
     * 输入：n = 3
     * 输出：0
     * 解释：3! = 6 ，不含尾随 0
     */
    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes(30));
    }

    public int trailingZeroes(int n) {
        BigInteger nFactorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }
        // Count how many 0's are on the end.
        int zeroCount = 0;
        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFactorial = nFactorial.divide(BigInteger.TEN);
            zeroCount++;
        }
        return zeroCount;
    }

//    public int trailingZeroes(int n) {
    //只计算5的因子
//        return n < 5 ? 0 : (n / 5 + trailingZeroes(n / 5));
//    }
}
