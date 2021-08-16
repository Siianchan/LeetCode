package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/16 13:42
 * @Description:
 */
public class SearchMatrix {
    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     */
    public static void main(String[] args) {
        int[][] ma = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(ma, 4));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int x = 0; x < matrix.length; x++) {
            if (matrix[x][matrix[0].length - 1] >= target) {
                if (matrix[x][matrix[0].length - 1] == target) return true;
                for (int y = matrix[x].length - 1; y >= 0; y--) {
                    if (matrix[x][y] < target) return false;
                    if (matrix[x][y] == target) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

}
