package medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/17 13:58
 * @Description:
 */
public class Permutation {
    LinkedList<String> linkedList = new LinkedList();

    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.permutation("");
    }

    public String[] permutation(String s) {
        if (s == null) {
            return null;
        }
        char[] ch = s.toCharArray();
        boolean[] fl = new boolean[ch.length];
        Arrays.sort(ch);
        dfs(ch, fl, new StringBuilder(), 0);
        System.out.println(linkedList);
        return linkedList.toArray(new String[]{});
    }

    void dfs(char[] ch, boolean[] fl, StringBuilder stringBuilder, int num) {
        if (num >= ch.length) {
            linkedList.add(stringBuilder.toString());
            return;
        }
        for (int x = 0; x < ch.length; x++) {
            if (x > 0 && ch[x] == ch[x - 1] && !fl[x - 1]) {
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
