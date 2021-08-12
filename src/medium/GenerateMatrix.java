package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/12 14:53
 * @Description:
 */
public class GenerateMatrix {
    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     */
    public static void main(String[] args) {

    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        fulfilOuter(res, 1, n, 0);
        return res;
    }

    public void fulfilOuter(int[][] res, int count, int n, int offset) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            res[offset][offset] = count;
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            res[offset][i + offset] = count;
            count++;
        }
        for (int i = 0; i < n - 1; i++) {
            res[i + offset][offset + n - 1] = count;
            count++;
        }
        for (int i = 0; i < n - 1; i++) {
            res[offset + n - 1][offset + n - 1 - i] = count;
            count++;
        }
        for (int i = 0; i < n - 1; i++) {
            res[offset + n - 1 - i][offset] = count;
            count++;
        }

        fulfilOuter(res, count, n - 2, ++offset);
    }
}
