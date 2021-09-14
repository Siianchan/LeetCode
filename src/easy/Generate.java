package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/14 13:15
 * @Description:
 */
public class Generate {

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     */
    
    public static void main(String[] args) {
        Generate generate = new Generate();
        generate.generate(10);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new LinkedList<>();
        int[][] arr = new int[numRows][numRows];
        for (int x = 0; x < numRows; x++) {
            LinkedList l = new LinkedList();
            for (int y = 0; y <= x; y++) {
                if (y == 0 || y == x) {
                    arr[x][y] = 1;
                } else {
                    arr[x][y] = arr[x - 1][y - 1] + arr[x - 1][y];
                }
                l.add(arr[x][y]);
            }
            lists.add(new LinkedList<>(l));
        }
        return lists;
    }
}
