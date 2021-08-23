package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/23 17:10
 * @Description:
 */
public class NumDecodings {
    /**
     * 条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 输入：s = "12"
     * 输出：2
     * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
     */
    public static void main(String[] args) {
        NumDecodings decodings = new NumDecodings();
        System.out.println(decodings.numDecodings("1123"));
    }

    public int numDecodings(String s) {
        if (s.length() <= 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        char[] chs = s.toCharArray();
        dp[0] = 1;
        for (int x = 1; x < chs.length; x++) {
            if (chs[x] == '0') {
                if (chs[x - 1] == '1' || chs[x - 1] == '2') {
                    dp[x] = x == 1 ? dp[0] : dp[x - 2];
                } else {
                    return 0;
                }
            } else if (chs[x - 1] == '1' || (chs[x - 1] == '2' && chs[x] <= '6')) {
                dp[x] = x == 1 ? dp[x - 1] + 1 : dp[x - 1] + dp[x - 2];
            } else {
                dp[x] = dp[x - 1];
            }
        }
        return dp[s.length() - 1];
    }
}
