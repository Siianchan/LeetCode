package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author siianchan
 * @since 2024/9/2 11:23
 */
public class MaxConsecutiveAnswers {
    /**
     * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。
     * 老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
     * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，
     * 表示你能进行以下操作的最多次数：
     * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
     * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
     */
    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TFFT", 1));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        Map<Character, Integer> ch = new HashMap<>();
        ch.put('T', 0);
        ch.put('F', 0);
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < answerKey.length()) {
            ch.put(answerKey.charAt(right), ch.get(answerKey.charAt(right)) + 1);
            right++;
            if (ch.get('T') > k && ch.get('F') > k) {
                ch.put(answerKey.charAt(left), ch.get(answerKey.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, ch.get('T') + ch.get('F'));
        }
        return max;
    }
}
