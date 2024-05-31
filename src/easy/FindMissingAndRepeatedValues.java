package easy;

/**
 * @author siianchan
 * @since 2024/5/31 09:33
 */
public class FindMissingAndRepeatedValues {
    /**
     * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。
     * 除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
     * 任务是找出重复的数字a 和缺失的数字 b 。
     * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
     */
    public int[] findMissingAndRepeatedValues2(int[][] grid) {
        //数学解法
        //遍历和。得到a-b
        //遍历和的平方，得到a^2-b^2 即可得到（a+b)(a-b)
        int n = grid.length;
        int m = n * n;
        int d1 = -m * (m + 1) / 2;
        long d2 = (long) -m * (m + 1) * (m * 2 + 1) / 6;
        for (int[] row : grid) {
            for (int x : row) {
                d1 += x;
                d2 += x * x;
            }
        }
        int d = (int) (d2 / d1);
        return new int[]{(d + d1) / 2, (d - d1) / 2};
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        //模拟解法
        int[] var1 = new int[grid.length * grid.length + 1];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                var1[grid[x][y]]++;
            }
        }
        int[] ret = new int[2];
        for (int x = 1; x < var1.length; x++) {
            if (var1[x] != 1) {
                if (var1[x] == 0) {
                    ret[1] = x;
                } else if (var1[x] == 2) {
                    ret[0] = x;
                }
            }
        }
        return ret;
    }
}
