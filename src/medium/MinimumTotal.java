package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/15 16:48
 * @Description:
 */
public class MinimumTotal {
    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标
     * 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     */

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList linkedList = new LinkedList();
        linkedList.add(-1);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(2);
        linkedList2.add(3);
        LinkedList linkedList3 = new LinkedList();
        linkedList3.add(1);
        linkedList3.add(-1);
        linkedList3.add(-3);
        lists.add(linkedList);
        lists.add(linkedList2);
        lists.add(linkedList3);
        minimumTotal.minimumTotal(null);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() <= 0) return 0;
        List<Integer> result = new LinkedList<>();
        result.add(0);
        for (int x = 0; x < triangle.size(); x++) {
            List<Integer> list = triangle.get(x);
            List<Integer> pre = new LinkedList<>();
            for (int y = 0; y < list.size(); y++) {
                Integer a = list.get(y);
                if (y == 0) {
                    pre.add(a + result.get(y));
                } else if (y == list.size() - 1) {
                    pre.add(a + result.get(y - 1));
                } else {
                    pre.add(a + Math.min(result.get(y), result.get(y - 1)));
                }
            }
            result = new LinkedList<>(pre);
            pre.clear();
        }
        int minNum = Integer.MAX_VALUE;
        for (int x = 0; x < result.size(); x++) {
            if (result.get(x) < minNum) {
                minNum = result.get(x);
            }
        }
        return minNum;
    }

//    public void dfs(List<List<Integer>> triangle, int indexNum, int arrNum, int sum) {
//        if (sum > minNum) return;
//        if (indexNum >= triangle.size()) {
//            if (sum < minNum) {
//                minNum = sum;
//            }
//            return;
//        }
//        List<Integer> list = triangle.get(indexNum);
//        dfs(triangle, indexNum + 1, arrNum, sum + list.get(arrNum));
//        if (arrNum + 1 < list.size())
//            dfs(triangle, indexNum + 1, arrNum + 1, sum + list.get(arrNum + 1));
//    }
}
