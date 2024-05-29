package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author siianchan
 * @since 2024/5/28 09:33
 */
public class FindPeaks {
    /**
     * 给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。
     * 以数组形式返回给定数组中 峰值 的下标，顺序不限 。
     * 注意：
     * 峰值 是指一个严格大于其相邻元素的元素。
     * 数组的第一个和最后一个元素 不 是峰值。
     */
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList();
        for (int x = 1; x < mountain.length - 1; x++) {
            if ((mountain[x] > mountain[x - 1]) && (mountain[x] > mountain[x + 1])) {
                ans.add(x);
                x++;
            }
        }
        return ans;
    }
}
