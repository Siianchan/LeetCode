package medium;

/**
 * @author siianchan
 * @since 2024/6/11 11:22
 */
public class CountBattleships {
    /**
     * 甲板上的战舰
     * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，
     * 返回在甲板 board 上放置的 战舰 的数量。
     * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）
     * 的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
     * 输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
     * 输出：2
     */

    public int countBattleships(char[][] board) {
        int ret = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 'X') {
                    //当格子为X的时候，判断左边或者上边有没有X，相当于只计入战舰的开头
                    if ((x == 0 || board[x - 1][y] == '.') && (y == 0 || board[x][y - 1] == '.')) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
}
