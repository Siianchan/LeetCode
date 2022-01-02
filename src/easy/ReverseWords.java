package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/2 14:43
 * @Description:
 */
public class ReverseWords {
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
     * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     * 示例 1：
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     */

    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        s = s.trim();
        String str[] = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = str.length - 1; x >= 0; x--) {
            if (str[x].trim().length() > 0) {
                stringBuilder.append(str[x].trim());
                if (x != 0) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }
}
