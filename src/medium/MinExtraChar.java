package medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author siianchan
 * @since 2024/1/9 13:31
 */
public class MinExtraChar {
    /**
     * 2707. 字符串中的额外字符
     * 给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在 dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。
     * 请你采取最优策略分割 s ，使剩下的字符 最少 。
     * 示例 1：
     * 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
     * 输出：1
     * 解释：将 s 分成两个子字符串：下标从 0 到 3 的 "leet" 和下标从 5 到 8 的 "code" 。只有 1 个字符没有使用（下标为 4），所以我们返回 1 。
     * 示例 2：
     * 输入：s = "sayhelloworld", dictionary = ["hello","world"]
     * 输出：3
     * 解释：将 s 分成两个子字符串：下标从 3 到 7 的 "hello" 和下标从 8 到 12 的 "world" 。下标为 0 ，1 和 2 的字符没有使用，所以我们返回 3 。
     */
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        Set<String> hashSet = Arrays.stream(dictionary).collect(Collectors.toSet());
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            //剩余的字符串等于上一个+1
            d[i] = d[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (hashSet.contains(s.substring(j, i))) {
                    //假如j到i的字符串刚好存在，说明这部分没有剩下的字符串，直接判断d[i]和d[j]哪个剩余更小
                    d[i] = Math.min(d[i], d[j]);
                }
            }
        }
        return d[n];
    }
    public int minExtraChar2(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            String cur = s.substring(i);
            dp[i] = dp[i + 1] + 1;
            for(String word: dictionary)
                if(cur.startsWith(word))
                    dp[i] = Math.min(dp[i], dp[i + word.length()]);
        }
        return dp[0];
    }

}
