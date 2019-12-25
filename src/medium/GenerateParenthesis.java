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
        //运用了回溯递归法
        ArrayList arrayList = new ArrayList();
        generate("", n, n, arrayList);
//        System.out.println(arrayList);
        return arrayList;
    }

    public static void generate(String str, int left, int right, List list) {
        //当左括号和右括号都添加完毕的时候，在集合中添加该条记录，并终止递归
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > 0) {
            //当左括号还没添加完成时，添加一个左括号，进入下一层递归
            generate(str + "(", left - 1, right, list);
        }
        if (left < right) {
            //当左括号多余右括号时，添加一个右括号，进入下一层递归
            generate(str + ")", left, right - 1, list);
        }
    }
}
