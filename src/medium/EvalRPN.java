package medium;

import java.util.Stack;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/5 17:26
 * @Description:
 */
public class EvalRPN {
    /**
     * 根据 逆波兰表示法，求表达式的值。
     * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * 说明：
     * 整数除法只保留整数部分。
     * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     * 示例 1：
     * 输入：tokens = ["2","1","+","3","*"]
     * 输出：9
     * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     */

    public static void main(String[] args) {
        EvalRPN v = new EvalRPN();
        String arr[] = new String[]{"10"};
        System.out.println(v.evalRPN(arr));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int x = 0; x < tokens.length; x++) {
            try {
                int num = Integer.valueOf(tokens[x]);
                stack.push(num);
            } catch (Exception e) {
                //识别到运算符
                int b = stack.pop();
                int a = stack.pop();
                switch (tokens[x]) {
                    case "+": {
                        stack.push(a + b);
                        break;
                    }
                    case "-": {
                        stack.push(a - b);
                        break;
                    }
                    case "*": {
                        stack.push(a * b);
                        break;
                    }
                    case "/": {
                        stack.push(a / b);
                        break;
                    }
                }
            }
        }
        return stack.pop();
    }
}
