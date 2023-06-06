package medium;


/**
 * @author
 * @since 2023/6/6 13:30
 */
public class EqualPairs {

    /**
     * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
     * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
     * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
     * 输出：3
     * 解释：存在三对相等行列对：
     * - (第 0 行，第 0 列)：[3,1,2,2]
     * - (第 2 行, 第 2 列)：[2,4,2,2]
     * - (第 3 行, 第 2 列)：[2,4,2,2]
     */
    public static void main(String[] args) {
        new EqualPairs().equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 4}, {2, 4, 2, 2}, {2, 5, 2, 2}});
        //        3 1 2 2
        //        1,4,4,4
        //        2,4,2,2
        //        2,5,2,2
    }

    public int equalPairs(int[][] grid) {
        int result = 0;
        for (int x = 0; x < grid.length; x++) {
            result += check(grid[x], grid);
        }
        return result;
    }

    public int check(int[] row, int[][] grid) {
        int result = 0;
        f1:
        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (row[y] != grid[y][x]) {
                    continue f1;
                }
            }
            result++;
        }
        return result;
    }
}
