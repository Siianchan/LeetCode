package medium;

import java.util.Arrays;

/**
 * @author siianchan
 * @since 2024/5/27 11:15
 */
public class MissingRolls {
    /**
     * 现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份
     * ，你手上只拿到剩余 m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
     * 给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
     * 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。
     * 如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组。
     * k 个数字的 平均值 为这些数字求和后再除以 k 。
     * 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被 n + m 整除。
     * 示例 1：
     * 输入：rolls = [3,2,4,3], mean = 4, n = 2
     * 输出：[6,6]
     * 解释：所有 n + m 次投掷的平均值是 (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4 。
     */
    public static void main(String[] args) {
        int[] rolls = new int[]{3, 2, 4, 3};
        int[] rolls2 = new int[]{1, 5, 6};
        new MissingRolls().missingRolls(rolls2, 3, 4);
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int length = rolls.length;
        int sum = Arrays.stream(rolls).sum();
        int originSum = (length + n) * mean;
        int gap = originSum - sum;
        if (gap > 6 * n || gap < n) {
            //差值大于全是6
            //差值小于全是1
            return new int[]{};
        }
        //剩下的绝对是有解的
        int[] ans = new int[n];
        Arrays.fill(ans, mean);
        //将答案填充全部为平均数
        int gap2 = gap - mean * n;
        if (gap2 == 0) {
            return ans;
        }
        //根据全平均数的差值，将答案中的每个数进行+-
        if (gap2 > 0) {
            for (int x = 0; x < n; x++) {
                if (ans[x] < 6) {
                    if (6 - ans[x] >= gap2) {
                        ans[x] += Math.abs(gap2);
                        return ans;
                    } else {
                        gap2 -= 6 - ans[x];
                        ans[x] = 6;
                    }
                }
            }
        } else {
            for (int x = 0; x < n; x++) {
                if (ans[x] > 1) {
                    if (ans[x] - 1 >= Math.abs(gap2)) {
                        ans[x] -= Math.abs(gap2);
                        return ans;
                    } else {
                        gap2 += ans[x] - 1;
                        ans[x] = 1;
                    }
                }
            }
        }
        return new int[]{};
    }


    //dfs解法
    public int[] dfs(int n, int[] ans, int gap) {
        if (n == 0) {
            if (gap == 0) {
                return ans;
            }
            return null;
        } else {
            if (gap > 6 * n || gap < n) {
                return null;
            }
        }
        for (int x = 1; x <= 6; x++) {
            ans[n - 1] = x;
            if (dfs(n - 1, ans, gap - x) != null) {
                return ans;
            }
        }
        return null;
    }
}
