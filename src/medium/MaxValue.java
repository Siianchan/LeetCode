package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/22 14:06
 * @Description:
 */
public class MaxValue {

    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * 示例 1:
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     */

    public static void main(String[] args) {

    }

    public int dp(int[][] grid) {
        //动态规划法
        if (grid.length < 1) {
            return 0;
        }
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                int a = grid[x][y];
                int b = grid[x][y];
                if (x - 1 >= 0) {
                    a += grid[x - 1][y];
                }
                if (y - 1 >= 0) {
                    b += grid[x][y - 1];
                }
                grid[x][y] = Math.max(a, b);
            }
        }
//        for (int x = 0; x < grid.length; x++) {
//            for (int y = 0; y < grid[x].length; y++) {
//                System.out.println(grid[x][y]);
//            }
//        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public int maxValue(int[][] grid) {
        //贪心法
        int x = 0, y = 0;
        int sum = 0;
        while (true) {
            sum += grid[x][y];
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                break;
            }
            if (y + 1 == grid[0].length) {
                x++;
                continue;
            }
            if (x + 1 == grid.length) {
                y++;
                continue;
            }
            if (grid[x + 1][y] >= grid[x][y + 1]) {
                x++;
            } else {
                y++;
            }
        }
        System.out.println(sum);
        return sum;
    }
}
