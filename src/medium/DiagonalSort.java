package medium;

/**
 * @author siianchan
 * @since 2024/4/29 15:39
 */
public class DiagonalSort {
    /**
     * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。
     * 例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
     * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
     */
    public int[][] diagonalSort(int[][] mat) {
        if (mat.length < 2) {
            return mat;
        }
        for (int x = 0; x < mat.length; x++) {
            sort(x, 0, mat);
        }
        for (int y = 1; y < mat[0].length; y++) {
            //上下轴
            sort(0, y, mat);
        }
        return mat;
    }

    private void sort(int x, int y, int[][] mat) {
        for (int i = x, j = y; i < mat.length && j < mat[0].length; i++, j++) {
            for (int i1 = i + 1, j1 = j + 1; i1 < mat.length && j1 < mat[0].length; i1++, j1++) {
                if (mat[i][j] > mat[i1][j1]) {
                    int tmp = mat[i][j];
                    mat[i][j] = mat[i1][j1];
                    mat[i1][j1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
