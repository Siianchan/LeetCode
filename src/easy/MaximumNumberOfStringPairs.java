package easy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author siianchan
 * @since 2024/1/17 13:14
 */
public class MaximumNumberOfStringPairs {
    /**
     * 给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
     * 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
     * 字符串 words[i] 等于 words[j] 的反转字符串。
     * 0 <= i < j < words.length
     * 请你返回数组 words 中的 最大 匹配数目。
     * 注意，每个字符串最多匹配一次。
     */
    public static void main(String[] args) {
        System.out.println(maximumNumberOfStringPairs(new String[]{"cd", "ac", "dc", "ca", "zz"}));
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        AtomicInteger count = new AtomicInteger();
        Map<String, Boolean> map = Arrays.stream(words).collect(Collectors.toMap(w -> w, w -> true));
        map.keySet().forEach(k -> {
            String reverse = new StringBuilder(k).reverse().toString();
            if (!k.equals(reverse) && map.containsKey(reverse) && map.get(reverse)) {
                map.put(k, false);
                count.incrementAndGet();
            }
        });
        return count.get();
    }
}
