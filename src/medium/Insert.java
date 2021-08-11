package medium;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/11 21:38
 * @Description:
 */
public class Insert {
    /**
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * 示例 1：
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     */
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = Arrays.copyOf(intervals, intervals.length + 1);
        newIntervals[newIntervals.length - 1] = newInterval;
        List<int[]> list = Arrays.asList(newIntervals);
        List<Integer> headList = list.stream().map(i -> i[0]).sorted().collect(Collectors.toList()), tailList = list.stream().map(i -> i[1]).sorted().collect(Collectors.toList());
        int[][] newArr = new int[headList.size()][];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = new int[]{headList.get(i), tailList.get(i)};
            if (i > 0) {
                if (newArr[i][0] <= newArr[i - 1][1]) newArr[i][0] = newArr[i - 1][0];
                if (newArr[i][0] == newArr[i - 1][0]) newArr[i - 1] = null;
            }
        }
        List<int[]> tempList = Arrays.stream(newArr).filter(Objects::nonNull).collect(Collectors.toList());
        return tempList.toArray(new int[tempList.size()][]);
    }
}
