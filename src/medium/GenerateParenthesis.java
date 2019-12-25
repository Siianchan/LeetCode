package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-25 15:08
 * @Description:
 */
public class GenerateParenthesis {
    /**
     * 括号生成
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * 例如，给出 n = 3，生成结果为：
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */
    public static void main(String args[]) {
        generateParenthesis(0);
    }

    public static List<String> generateParenthesis(int n) {

        ArrayList arrayList = new ArrayList();
        generate("", n, n, arrayList);
//        System.out.println(arrayList);
        return arrayList;
    }

    public static void generate(String str, int left, int right, List list) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > 0) {
            generate(str + "(", left - 1, right, list);
        }
        if (left < right) {
            generate(str + ")", left, right - 1, list);
        }
    }
}
