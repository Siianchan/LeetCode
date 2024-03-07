package medium;

/**
 * @author siianchan
 * @since 2024/3/7 13:37
 */
public class DivisibilityArray {

    /**
     * 2575. 找出字符串的可整除数组
     * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
     * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
     * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
     * 否则，div[i] = 0
     * 返回 word 的可整除数组。
     * 输入：word = "998244353", m = 3
     * 输出：[1,1,0,0,0,1,1,0,0]
     * 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
     */
    public static void main(String[] args) {

    }

    public int[] divisibilityArray(String word, int m) {
        char[] ch = word.toCharArray();
        long sum = 0;
        int[] ret = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            int tmp = ch[i] - '0';
            sum = (sum * 10 + tmp) % m;
            if (sum % m == 0) {
                ret[i] = 1;
            }
        }
        return ret;
    }
}
