package medium;
/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2020-05-05 13:01
 * @Description:
 */

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class IsValidSudoku {

    public static void main(String args[]) {

    }

    public boolean isValidSudoku(char[][] board) {
        //创建一个行和列和九宫格的二维数组，便利一遍，查看所在的组的数字下标有没有已填充，没有说明就没有重复
        boolean[][] row = new boolean[9][9];//行
        boolean[][] col = new boolean[9][9];//列
        boolean[][] block = new boolean[9][9];//九宫格
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] != '.') {//查看是否数字下标
                    int num = board[x][y] - '1';//提取出char数组中的数字，-1是因为数字是1-9，会越界
                    int blockNum = (x / 3) + (y / 3 * 3);//计算当前坐标是第几个九宫格
                    if (row[x][num] || col[y][num] || block[blockNum][num]) {
                        //只要有一个组已填充，返回false
                        return false;
                    } else {
                        //没有就全部填充上去
                        row[x][num] = true;
                        col[y][num] = true;
                        block[blockNum][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
