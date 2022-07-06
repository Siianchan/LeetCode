package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/7/6 9:28
 * @Description:
 */
public class FindAndReplacePattern {

    /**
     * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
     * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
     * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
     * 返回 words 中与给定模式匹配的单词列表。
     * 你可以按任何顺序返回答案。
     * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
     * 输出：["mee","aqq"]
     */

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new LinkedList<>();
        String patternNum = transWord(pattern);
        for (int x = 0; x < words.length; x++) {
            if (transWord(words[x]).equals(patternNum)) {
                list.add(words[x]);
            }
        }
        return list;
    }

    private String transWord(String pattern) {
        //hash表，将字符串转为统一的编码格式
        HashMap hashMap = new HashMap<Character, Integer>();
        int num = 1;
        char[] ch = pattern.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : ch
        ) {
            if (hashMap.get(c) == null) {
                hashMap.put(c, num);
                stringBuilder.append(num);
                num++;
            } else {
                stringBuilder.append(hashMap.get(c));
            }
            //只用数字分割会导致1和2 与12等价
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        new FindAndReplacePattern().findAndReplacePattern(null, "abbccdd");
        System.out.println(new FindAndReplacePattern().transWord("abcdefghijklab"));
        System.out.println(new FindAndReplacePattern().transWord("abcdefghijklab"));
        System.out.println(new FindAndReplacePattern().transWord("abcdefghijkabl"));

    }

}
