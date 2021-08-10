package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/10 15:25
 * @Description:
 */
public class Merge {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * 示例 1：
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 5}, {1, 4}, {0, 1}};
        Merge merge = new Merge();
        merge.merge(arr);
    }

    public int[][] merge(int[][] intervals) {
        for (int x = 0; x < intervals.length; x++) {
            for (int y = x; y < intervals.length - 1; y++) {
                if (intervals[x][0] > intervals[x + 1][0]) {
                    int temp = intervals[x][0];
                    intervals[x][0] = intervals[x + 1][0];
                    intervals[x + 1][0] = temp;
                    temp = intervals[x][1];
                    intervals[x][1] = intervals[x + 1][1];
                    intervals[x + 1][1] = temp;
                }
            }
        }
        List<int[]> ans = new ArrayList<>();

        int leftMost = intervals[0][0], rightMost = intervals[0][1];
        int i;
        for (i = 0; i < intervals.length; i++) {
            if (rightMost >= intervals[i][0]) {
                rightMost = intervals[i][1] > rightMost ? intervals[i][1] : rightMost;
                //易忽略情况[[1,6],[2,4],[7,9]] ->[1,6] [7,9] 而非 [1,4] [7,9]
                continue;
            } else { //
                int[] oneRange = new int[2];
                oneRange[0] = leftMost;
                oneRange[1] = rightMost;
                ans.add(oneRange);
                leftMost = intervals[i][0];
                rightMost = intervals[i][1];

            }

        }
        int[] oneRange = new int[2];
        oneRange[0] = leftMost;
        oneRange[1] = rightMost;
        ans.add(oneRange);
        int[][] ansArr = new int[ans.size()][];
        return ans.toArray(ansArr);
    }
}
