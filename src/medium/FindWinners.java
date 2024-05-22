package medium;

import java.util.*;

/**
 * @author siianchan
 * @since 2024/5/22 10:01
 */
public class FindWinners {

    /**
     * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
     * 返回一个长度为 2 的列表 answer ：
     * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
     * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
     * 两个列表中的值都应该按 递增 顺序返回。
     * 注意：
     * 只考虑那些参与 至少一场 比赛的玩家。
     * 生成的测试用例保证 不存在 两场比赛结果 相同 。
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> winMap = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            if (!winMap.containsKey(matches[i][0])) {
                winMap.put(matches[i][0], 0);
            }
            if (!winMap.containsKey(matches[i][1])) {
                winMap.put(matches[i][1], 1);
            } else {
                winMap.put(matches[i][1], winMap.get(matches[i][1]) + 1);
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        winMap.forEach((k, v) -> {
            if (v.equals(0)) {
                ans1.add(k);
            } else if (v.equals(1)) {
                ans2.add(k);
            }
        });
        Collections.sort(ans1);
        Collections.sort(ans2);
        ret.add(ans1);
        ret.add(ans2);
        return ret;
    }
}
