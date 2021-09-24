package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/16 16:40
 * @Description:
 */
public class Combine {
    List<List<Integer>> result = new LinkedList<>();
    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     * 示例 1：
     * 输入：n = 4, k = 2
     * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] a = new int[n + 1];
        for (int x = 1; x < a.length; x++) {
            a[x] = x;
        }
        dfs(1, a, new LinkedList(), k);
        System.out.println(result);
        return null;
    }

    public void dfs(int arr, int[] a, LinkedList linkedList, int k) {
        if (linkedList.size() == k) {
            result.add(new LinkedList<>(linkedList));
            return;
        }
        for (int x = arr; x < a.length; x++) {
            linkedList.add(a[x]);
            dfs(x + 1, a, linkedList, k);
            linkedList.removeLast();
        }
    }
}
