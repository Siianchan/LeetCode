package medium;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author siianchan
 * @since 2024/5/29 15:04
 */
public class MaximumLength {
    /**
     * 给你一个仅由小写英文字母组成的字符串 s 。
     * 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc"
     * 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
     * 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
     * 子字符串 是字符串中的一个连续 非空 字符序列。
     */
    public int maximumLength2(String s) {
        int ret = -1;
        char[] ch = s.toCharArray();
        for (int x = 0; x < ch.length - 2; x++) {
            int count = 1;
            int start = x;
            List<Integer> arr = new ArrayList<>();
            //找出所有ch[x]开头的下标
            for (int y = x + 1; y < ch.length; y++) {
                if (ch[y] == ch[start]) {
                    arr.add(y);
                }
            }
            if (arr.size() < 2) {
                //说明没有3个开头字母
                continue;
            }
            while (true) {
                List<Integer> newArr = new ArrayList<>();
                start++;
                for (int i = 0; i < arr.size(); i++) {
                    int index = arr.get(i) + 1;
                    if (index < ch.length && ch[index] == ch[start]) {
                        newArr.add(index);
                    }
                }
                if (newArr.size() >= 2) {
                    //说明这轮成功了
                    count++;
                    arr = newArr;
                } else {
                    arr.clear();
                    break;
                }
            }
            if (count > ret) {
                ret = count;
            }
            x = start - 1;
        }
        return ret;
    }

    /**
     * 由于特殊子串只包含单一字母，我们按照相同字母分组，每组统计相同字母连续出现的长度。
     * 例如字符串 aaaabbbabb 分成 aaaa+bbb+a+bb 四组，字母 a 有长度 444 和长度 111，
     * 字母 b 有长度 333 和长度 222。所以字母 a 的长度列表为 [4,1][4,1][4,1]，字母 b 的长度列表为 [3,2][3,2][3,2]。
     */


    public int maximumLength(String s) {
        char[] ch = s.toCharArray();
        Map<Character, List<Integer>> record = new HashMap<>();
        for (int x = 0; x < ch.length; ) {
            int count = 0;
            char v1 = ch[x];
            while (x < ch.length && ch[x] == v1) {
                x++;
                count++;
            }
            if (!record.containsKey(v1)) {
                record.put(v1, new ArrayList<>());
            }
            record.getOrDefault(v1, new ArrayList<>()).add(count);
        }
        AtomicInteger max = new AtomicInteger(-1);
        record.forEach((k, v) -> {
            Collections.sort(v, (v1, v2) -> v2 - v1);
            if (v.get(0) > 2) {
                max.set(Math.max(max.get(), v.get(0) - 2));
            }
            if (v.size() > 1) {
                max.set(Math.max(max.get(), Math.min(v.get(0) - 1, v.get(1))));
            }
            if (v.size() > 2) {
                max.set(Math.max(max.get(), v.get(2)));
            }
        });
        return max.get() == 0 ? -1 : max.get();
    }

    public static void main(String[] args) {
        System.out.println(new MaximumLength().maximumLength("cbc"));
    }
}
