package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/13 19:32
 * @Description:
 */
public class NniquePaths {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * 输入：m = 3, n = 7
     * 输出：28
     */
    public static void main(String[] args) {
        NniquePaths nniquePaths = new NniquePaths();
        System.out.println(nniquePaths.uniquePaths(7, 3));
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}};

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];

        return dfs(0, 0, m, n, memo);
    }

    private int dfs(int x, int y, int m, int n, int[][] memo) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        int sum = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || ny >= n) continue;
            sum += dfs(nx, ny, m, n, memo);
        }
        memo[x][y] = sum;
        return sum;
    }
}
