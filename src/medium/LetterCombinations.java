package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-22 19:21
 * @Description:
 */
public class LetterCombinations {
    /**
     * 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */
    public static void main(String args[]) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        //运用了队列先进先出的特性
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            //将digits字符串转换为数字
            int x = Character.getNumericValue(digits.charAt(i));
            //运用了队列先进先出的原则进行循环，当长度不等于i的时候，说明进入了下一层循环
            while (ans.peek().length() == i) {
                String t = ans.remove();
                //将mapping[x]每个字符单独取出来，和从队列中取出来的组合成新的字符串
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
}
