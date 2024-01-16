package hard;


import java.util.Arrays;

/**
 * @author siianchan
 * @since 2024/1/16 10:23
 */
public class Count {
    /**
     * 2719. 统计整数数目
     * 给你两个数字字符串 num1 和 num2 ，以及两个整数 max_sum 和 min_sum 。如果一个整数 x 满足以下条件，我们称它是一个好整数：
     * num1 <= x <= num2
     * min_sum <= digit_sum(x) <= max_sum.
     * 请你返回好整数的数目。答案可能很大，请返回答案对 109 + 7 取余后的结果。
     * 示例 1：
     * 输入：num1 = "1", num2 = "12", min_num = 1, max_num = 8
     * 输出：11
     * 解释：总共有 11 个整数的数位和在 1 到 8 之间，分别是 1,2,3,4,5,6,7,8,10,11 和 12 。所以我们返回 11 。
     */
    public static int mod = 1000000007;
    int[] max_str;
    int[] min_str;
    int max;
    int min;
    int[][] memo;

    public static void main(String[] args) {
        //519488312
        System.out.println(new Count().count("1479192516", "5733987233", 36, 108));
//        System.out.println(new Count().count("1", "100", 1, 20));
    }

    public int count(String num1, String num2, int min_sum, int max_sum) {
        max = max_sum;
        min = min_sum;
        max_str = new int[num2.length()];
        min_str = new int[num2.length()];
        memo = new int[num2.length()][9 * num2.length()];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }
        for (int x = 0; x < num2.length(); x++) {
            //转成数组
            max_str[x] = num2.charAt(x) - '0';
        }
        for (int x = 0; x < num1.length(); x++) {
            //转成数组，不够补0
            min_str[min_str.length + x - num1.length()] = num1.charAt(x) - '0';
        }
        return dfs(0, 0, true, true);
    }

    public int dfs(int index, int count, boolean isLimit, boolean isLimit2) {
        //index 当前位数，count和，isLimit是否限制了数字范围（高），isLimit2是否限制了数字范围（低）
        if (index == max_str.length) {
            //递归到最后一位时，如果符合范围内，+1
            if (count >= min) {
                return 1;
            }
            return 0;
        }
        if (!isLimit && !isLimit2 && memo[index][count] != -1) {
            //记忆化搜索
            return memo[index][count];
        }
        int ret = 0;
        //如果限制了高，则位数最高到max_str[index]，否则是9
        int high = isLimit ? max_str[index] : 9;
        //如果限制了低，则位数最低到min_str[index]，否则是0
        int low = isLimit2 ? min_str[index] : 0;
        for (int x = low; x <= high; x++) {
            if (count + x <= max) {
                ret += dfs(index + 1, count + x, isLimit && x == high, isLimit2 && x == low);
                ret %= mod;
            }
        }
        if (!isLimit && !isLimit2) {
            //限制了位数不需要记忆化
            memo[index][count] = ret;
        }
        return ret;
    }
}
