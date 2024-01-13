package medium;

/**
 * @author siianchan
 * @since 2024/1/13 16:37
 */
public class RepeatLimitedString {
    /**
     * 2182. 构造限制重复的字符串
     * 给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，
     * 使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
     * 返回 字典序最大的 repeatLimitedString 。
     * 如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，
     * 则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
     */
    public static void main(String[] args) {
        System.out.println(repeatLimitedString("aabababbbbbbbbbbbbbbbb", 2));
    }

    static String str = new String("abcdefghijklmnopqrstuvwxyz");

    public static String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder ret = new StringBuilder();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int limit;
        for (int i = 25; i >= 0; i--) {
            limit = 0;
            while (count[i] > 0) {
                if (limit == repeatLimit) {
                    Character c = getNextChar(i - 1, count);
                    if (c == null) {
                        break;
                    } else {
                        ret.append(c);
                    }
                    limit = 0;
                }
                ret.append(str.charAt(i));
                count[i]--;
                limit++;
            }
        }
        return ret.toString();
    }

    public static Character getNextChar(int i, int[] count) {
        for (int x = i; x >= 0; x--) {
            if (count[x] > 0) {
                count[x]--;
                return str.charAt(x);
            }
        }
        return null;
    }
}
