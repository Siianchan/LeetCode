package easy;

/**
 * @author siianchan
 * @since 2024/3/11 10:28
 */
public class CapitalizeTitle {
    /**
     * 2129. 将标题首字母大写
     * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成
     * ，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
     * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
     * 否则，将单词首字母大写，剩余字母变成小写。
     * 请你返回 大写后 的 title 。
     */
    public String capitalizeTitle(String title) {
        String[] strs = title.split(" ");
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toLowerCase().toCharArray();
            if (chars.length > 2) {
                chars[0] = Character.toUpperCase(chars[0]);
            }
            strs[i] = String.valueOf(chars);
        }
        return String.join(" ", strs);
    }
}
