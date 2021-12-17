package medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/17 13:58
 * @Description:
 */

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Permutation {
    LinkedList<String> linkedList = new LinkedList();

    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.permutation("");
    }

    public String[] permutation(String s) {
        //全排列，不重复
        if (s == null) {
            return null;
        }
        char[] ch = s.toCharArray();
        boolean[] fl = new boolean[ch.length];
        //先按字典序进行排序
        Arrays.sort(ch);
        dfs(ch, fl, new StringBuilder(), 0);
        System.out.println(linkedList);
        return linkedList.toArray(new String[]{});
    }

    void dfs(char[] ch, boolean[] fl, StringBuilder stringBuilder, int num) {
        if (num >= ch.length) {
            //达到结果，添加到答案中
            linkedList.add(stringBuilder.toString());
            return;
        }
        for (int x = 0; x < ch.length; x++) {
            if (x > 0 && ch[x] == ch[x - 1] && !fl[x - 1]) {
                //如果该元素和上一个元素相同时，上一个元素未使用的话，跳过
                continue;
            }
            if (!fl[x]) {
                fl[x] = true;
                stringBuilder = stringBuilder.append(ch[x]);
                dfs(ch, fl, stringBuilder, num + 1);
                stringBuilder = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                fl[x] = false;
            }
        }
    }

}
