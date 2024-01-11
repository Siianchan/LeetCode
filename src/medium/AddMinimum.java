package medium;


/**
 * @author siianchan
 * @since 2024/1/11 10:11
 */
public class AddMinimum {

    /**
     * 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
     * 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
     * 示例 1：
     * 输入：word = "b"
     * 输出：2
     * 解释：在 "b" 之前插入 "a" ，在 "b" 之后插入 "c" 可以得到有效字符串 "abc"
     */
    public static void main(String[] args) {
        System.out.println(addMinimum("aaa"));
    }

    public static int addMinimum(String word) {
        int count = 0;
        char[] chars = {'a', 'b', 'c'};
        char[] split = word.toCharArray();
        for (int i = 0, index = 0; i < split.length; index++) {
            if (index > 2) {
                index = 0;
            }
            if (split[i] == chars[index]) {
                i++;
            } else {
                count++;
            }
        }
        if (split[word.length() - 1] == chars[0]) {
            count += 2;
        }
        if (split[word.length() - 1] == chars[1]) {
            count += 1;
        }
        return count;
    }
}
