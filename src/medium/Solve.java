package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/19 15:05
 * @Description:
 */
public class Solve {
    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
     * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
     * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     */
    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        boolean[][] fl = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (x != 0 && x != board.length - 1) {
                    if (y != 0 && y != board[x].length - 1) {
                        //从边界搜寻，不是边界的continue
                        continue;
                    }
                }
                if (board[x][y] == 'O') {
                    //当不是边界，且为O的，开启深搜
                    dfs(board, fl, x, y);
                }
            }
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 'O' && !fl[x][y])//除了被边界链接的O，其他全部改成X
                    board[x][y] = 'X';
            }
        }
    }

    public void dfs(char[][] board, boolean[][] fl, int x, int y) {
        if (fl[x][y]) return;
        fl[x][y] = true;//将被边界链接的O做标记
        if (y + 1 < board[0].length) {
            //向右搜寻
            if (board[x][y + 1] == 'O') {
                dfs(board, fl, x, y + 1);
            }
        }
        if (y - 1 >= 0) {
            //向左搜寻
            if (board[x][y - 1] == 'O') {
                dfs(board, fl, x, y - 1);
            }
        }
        if (x + 1 < board.length) {
            //向下搜寻
            if (board[x + 1][y] == 'O') {
                dfs(board, fl, x + 1, y);
            }
        }
        if (x - 1 >= 0) {
            //向上搜寻
            if (board[x - 1][y] == 'O') {
                dfs(board, fl, x - 1, y);
            }
        }
    }
}
