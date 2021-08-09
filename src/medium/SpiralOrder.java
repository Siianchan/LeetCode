package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/9 14:57
 * @Description:
 */
public class SpiralOrder {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralOrder s = new SpiralOrder();
        System.out.println(s.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList linkedList = new LinkedList();
        dfs(matrix, 0, 0, 0, linkedList);
        return linkedList;
    }

    public void dfs(int[][] matrix, int x, int y, int fx, LinkedList linkedList) {
        if (linkedList.size() == matrix.length * matrix[0].length) {
            return;
        }
        if (fx == 0) { //向右转
            if (y == matrix[x].length || matrix[x][y] == Integer.MAX_VALUE) {
                //如果到达顶点，更改方向 其他同理
                dfs(matrix, x + 1, y - 1, fx + 1, linkedList);
                return;
            }
            linkedList.add(matrix[x][y]);
            matrix[x][y] = Integer.MAX_VALUE;
            dfs(matrix, x, y + 1, fx, linkedList);//继续向右
        } else if (fx == 1) {
            //向下转
            if (x == matrix.length || matrix[x][y] == Integer.MAX_VALUE) {
                dfs(matrix, x - 1, y - 1, fx + 1, linkedList);
                return;
            }
            linkedList.add(matrix[x][y]);
            matrix[x][y] = Integer.MAX_VALUE;
            dfs(matrix, x + 1, y, fx, linkedList);
        } else if (fx == 2) {
            //向左转
            if (y == -1 || matrix[x][y] == Integer.MAX_VALUE) {
                dfs(matrix, x - 1, y + 1, fx + 1, linkedList);
                return;
            }
            linkedList.add(matrix[x][y]);
            matrix[x][y] = Integer.MAX_VALUE;
            dfs(matrix, x, y - 1, fx, linkedList);
        } else if (fx == 3) {
            //向上转
            if (x == -1 || matrix[x][y] == Integer.MAX_VALUE) {
                dfs(matrix, x + 1, y + 1, 0, linkedList);
                return;
            }
            linkedList.add(matrix[x][y]);
            matrix[x][y] = Integer.MAX_VALUE;
            dfs(matrix, x - 1, y, fx, linkedList);
        }
        return;
    }
}
