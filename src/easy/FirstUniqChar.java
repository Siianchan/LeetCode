package easy;

import java.util.HashMap;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/22 16:28
 * @Description:
 */
public class FirstUniqChar {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * 示例 1:
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * 示例 2:
     * 输入：s = ""
     * 输出：' '
     */


    public static void main(String[] args) {
        System.out.println(firstUniqChar("abbaccdeff"));
    }

    public static char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (char c : sc)
            if (dic.get(c)) return c;
        return ' ';
    }
}
